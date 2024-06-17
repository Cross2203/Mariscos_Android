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

    String URL_PHP = "alimentos/";

    String URL_ORDENES = "ordenes/";

    String URL_ORDENES_DETALLES = "ordenes_detalles/";

    String URL_ULTIMA_ORDEN = "ultimaorden/";

    @GET(URL_PHP)
    Call<List<Comida>> obtenerComidas();
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

    @GET(URL_ORDENES)
    Call<Orden> obtenerOrden(
            @Query("idOrden") String idOrden
    );

    @POST(URL_ORDENES)
    Call<Void> agregarOrden(
            @Body Orden orden
    );

    @PUT(URL_ORDENES)
    Call<Void> editarOrden(
            @Body Orden orden
    );

    @DELETE(URL_ORDENES)
    Call<Void> eliminarOrden(
            @Query("idOrden") String idOrden
    );

    @GET(URL_ORDENES)
    Call<List<Usuario>> obtenerUsuarios();

    @GET(URL_ORDENES)
    Call<Usuario> obtenerUsuario(
            @Query("idOrden") String idOrden
    );

    @GET(URL_ULTIMA_ORDEN)
    Call<Orden> obtenerUltimaOrden();

    @GET(URL_ORDENES_DETALLES)
    Call<List<OrdenDetalles>> obtenerOrdenDetalles(
            @Query("idOrden") String idOrden
    );

    @POST(URL_ORDENES_DETALLES)
    Call<Void> agregarOrdenDetalles(
            @Body Orden orden
    );

    @PUT(URL_ORDENES_DETALLES)
    Call<Void> editarOrdenDetalles(
            @Body Orden orden
    );

    @DELETE(URL_ORDENES_DETALLES)
    Call<Void> eliminarOrdenDetalles(
            @Query("idOrden") String idOrden
    );

}
