package com.svalero.appropav2.model;

import android.database.sqlite.SQLiteConstraintException;

import com.svalero.appropav2.api.AppRopaApi;
import com.svalero.appropav2.api.AppRopaApiInterface;
import com.svalero.appropav2.contract.DeleteArticuloContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteArticuloModel implements DeleteArticuloContract.Model {

    @Override
    public void deleteArticulo(long idRopa, OnDeleteArticuloListener listener) {
        try {
            AppRopaApiInterface bestReadApi = AppRopaApi.buildInstance();
            Call<Void> callArticulos = bestReadApi.deleteArticulo(idRopa);
            callArticulos.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    listener.onDeleteSuccess();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    t.printStackTrace();
                    String message = "Error invocando a la operacion";
                    listener.onDeleteError(message);
                }
            });
        }catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
        }
    }
}