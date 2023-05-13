package com.svalero.appropav2.model;

import android.database.sqlite.SQLiteConstraintException;

import com.svalero.appropav2.api.AppRopaApi;
import com.svalero.appropav2.api.AppRopaApiInterface;
import com.svalero.appropav2.contract.RegisterArticuloContract;
import com.svalero.appropav2.domain.Ropa;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterArticuloModel implements RegisterArticuloContract.Model {


    @Override
    public void registerArticulo(Ropa ropa, RegisterArticuloContract.Model.OnRegisterArticuloListener listener) {
        try {
            AppRopaApiInterface appRopaApiInterface = AppRopaApi.buildInstance();
            Call<Ropa> callRopa = appRopaApiInterface.addArticulo(ropa);
            callRopa.enqueue(new Callback<Ropa>() {
                @Override
                public void onResponse(Call<Ropa> call, Response<Ropa> response) {
                    Ropa ropa = response.body();
                    listener.onRegisterArticuloSuccess(ropa);

                }

                @Override
                public void onFailure(Call<Ropa> call, Throwable t) {
                    t.printStackTrace();
                    String message = "Error invocando a la operacion";
                    listener.onRegisterArticuloError(message);

                }
            });
        }catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
        }
    }
}