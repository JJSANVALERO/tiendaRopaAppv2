package com.svalero.appropav2.model;

import com.svalero.appropav2.api.AppRopaApi;
import com.svalero.appropav2.api.AppRopaApiInterface;
import com.svalero.appropav2.contract.ArticuloDetailsContract;
import com.svalero.appropav2.domain.Ropa;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticuloDetailsModel implements ArticuloDetailsContract.Model {

    @Override
    public void loadArticulo(ArticuloDetailsContract.Model.OnDetailArticuloListener listener, long idRopa) {
        AppRopaApiInterface appRopaApiInterface = AppRopaApi.buildInstance();
        Call<Ropa> callArticulo = appRopaApiInterface.getArticulo(idRopa);
        callArticulo.enqueue(new Callback<Ropa>() {
            @Override
            public void onResponse(Call<Ropa> call, Response<Ropa> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Ropa ropa = response.body();
                    listener.onDetailArticuloSuccess(ropa);
                } else {
                    listener.onDetailArticuloError("Error al recuperar el articulo");
                }
            }

            @Override
            public void onFailure(Call<Ropa> call, Throwable t) {
                listener.onDetailArticuloError(t.getMessage());
            }
        });
    }
}
