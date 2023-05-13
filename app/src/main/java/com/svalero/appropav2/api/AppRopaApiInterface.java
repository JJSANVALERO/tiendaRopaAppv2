package com.svalero.appropav2.api;


import com.svalero.appropav2.domain.Ropa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AppRopaApiInterface {

    @GET("ropas")
    Call<List<Ropa>> getArticulos();

    @GET("ropa/{idRopa}")
    Call<Ropa> getArticulo(@Path("idRopa") long idRopa);

    @POST("ropas")
    Call<Ropa> addArticulo(@Body Ropa ropa);

    @PUT("ropa/{idRopa}")
    Call<Ropa> modifyArticulo(@Path("idRopa") long idRopa ,@Body Ropa updatedRopa);

    @DELETE("ropa/{idRopa}")
    Call<Void> deleteArticulo(@Path("idRopa") long idRopa);
}
