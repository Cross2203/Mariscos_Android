package com.example.loginrest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface APIRest {

    String URL_PHP = "API_REST.php";
    @GET(URL_PHP)
    Call<List<Comida>> obtenerComida();
    @GET(URL_PHP)
    Call<Comida> obtenerComida(
            @Query("idComida") String idComida
    );

    @POST(URL_PHP)
    Call<Void> agregarComida(
            @Body Comida comida
    );

    @PUT(URL_PHP)
    Call<Void> editarComida(
            @Body Comida comida
    );

    @DELETE(URL_PHP)
    Call<Void> eliminarComida(
            @Query("idComida") String idComida
    );

    @GET(URL_PHP)
    Call<Orden> obtenerOrden(
            @Query("idCliente") String idCliente
    );

    @POST(URL_PHP)
    Call<Void> agregarOrden(
            @Body Orden orden
    );

    @PUT(URL_PHP)
    Call<Void> editarOrden(
            @Body Orden orden
    );

    @DELETE(URL_PHP)
    Call<Void> eliminarOrden(
            @Query("idOrden") String idOrden
    );

    @GET(URL_PHP)
    Call<List<Usuario>> obtenerUsuarios();

    @GET(URL_PHP)
    Call<Usuario> obtenerUsuario(
            @Query("idUsuario") String idUsuario
    );
}
