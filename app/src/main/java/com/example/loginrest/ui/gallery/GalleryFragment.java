package com.example.loginrest.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginrest.APIRest;
import com.example.loginrest.AdaptadorComidas;
import com.example.loginrest.AdaptadorOrdenesDetalles;
import com.example.loginrest.AdaptadorRetrofit;
import com.example.loginrest.Comida;
import com.example.loginrest.Orden;
import com.example.loginrest.OrdenDetalles;
import com.example.loginrest.databinding.FragmentGalleryBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    RecyclerView rvOrden;

    List<OrdenDetalles> listaOrdenDetalles = new ArrayList<>();

    List<Comida> listaComidas = new ArrayList<>();

    AdaptadorOrdenesDetalles adaptadorOrdenesDetalles;

    Retrofit retrofit;

    APIRest api;

    String idUltimaOrden;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        rvOrden = binding.rvOrden;
        rvOrden.setLayoutManager(new GridLayoutManager(getContext(), 1));
        retrofit = new AdaptadorRetrofit().getAdaptador();
        api = retrofit.create(APIRest.class);
        getOrdenes(api);

        return root;
    }

    public void getOrdenes(APIRest api){
        listaOrdenDetalles.clear();
        Call<List<Comida>> callcomidas = api.obtenerComidas();

        callcomidas.enqueue(new Callback<List<Comida>>() {
            @Override
            public void onResponse(Call<List<Comida>> call, Response<List<Comida>> response) {
                listaComidas = new ArrayList<Comida>(response.body());
            }

            @Override
            public void onFailure(Call<List<Comida>> call, Throwable t) {
                Toast.makeText(getContext(), "No se pudo conectar", Toast.LENGTH_LONG).show();
                Log.e("TAG", "Error" + t);
            }
        });

        Call<Orden> callUltimaOrden = api.obtenerUltimaOrden();
        callUltimaOrden.enqueue(new Callback<Orden>() {
            @Override
            public void onResponse(Call<Orden> call, Response<Orden> response) {
                if (response.isSuccessful()) {
                    Orden ultimaOrden = response.body();
                    idUltimaOrden = ultimaOrden.getId_orden();

                }
            }

            @Override
            public void onFailure(Call<Orden> call, Throwable t) {
                Toast.makeText(getContext(), "No se pudo conectar", Toast.LENGTH_LONG).show();
                Log.e("TAG", "Error" + t);
            }
        });

        Call<List<OrdenDetalles>> call = api.obtenerOrdenDetalles(idUltimaOrden);
        call.enqueue(new Callback<List<OrdenDetalles>>() {
            @Override
            public void onResponse(Call<List<OrdenDetalles>> call, Response<List<OrdenDetalles>> response) {
                listaOrdenDetalles = new ArrayList<OrdenDetalles>(response.body());
                adaptadorOrdenesDetalles = new AdaptadorOrdenesDetalles(getContext(), listaOrdenDetalles, listaComidas);
                rvOrden.setAdapter(adaptadorOrdenesDetalles);

            }

            @Override
            public void onFailure(Call<List<OrdenDetalles>> call, Throwable t) {
                Toast.makeText(getContext(), "No se pudo conectar", Toast.LENGTH_LONG).show();
                Log.e("TAG", "Error" + t);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}