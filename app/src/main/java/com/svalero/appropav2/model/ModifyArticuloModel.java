package com.svalero.appropav2.model;

import com.svalero.appropav2.api.AppRopaApi;
import com.svalero.appropav2.api.AppRopaApiInterface;
import com.svalero.appropav2.contract.ModifyArticuloContract;
import com.svalero.appropav2.domain.Ropa;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModifyArticuloModel implements ModifyArticuloContract.Model {
    @Override
    public void modifyArticulo(Ropa ropa, OnModifyArticuloListener listener, long idRopa) {
        AppRopaApiInterface appRopaApiInterface = AppRopaApi.buildInstance();
        Call<Ropa> callArticulo = appRopaApiInterface.modifyArticulo(idRopa,  ropa);
        callArticulo.enqueue(new Callback<Ropa>() {
            @Override
            public void onResponse(Call<Ropa> call, Response<Ropa> response) {
                listener.onModifyArticuloSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Ropa> call, Throwable t) {
                t.printStackTrace();
                String message = "No se ha podido editar el articulo";
                listener.onModifyArticuloError(message);
            }
        });
    }

}
