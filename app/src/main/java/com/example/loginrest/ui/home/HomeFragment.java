package com.example.loginrest.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginrest.APIRest;
import com.example.loginrest.AdaptadorComidas;
import com.example.loginrest.AdaptadorRetrofit;
import com.example.loginrest.Comida;
import com.example.loginrest.R;
import com.example.loginrest.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    RecyclerView rvComidas;

    List<Comida> listaComidas = new ArrayList<>();

    AdaptadorComidas adaptadorComidas;

    Retrofit retrofit;

    APIRest api;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        rvComidas = binding.rvComidas;
        rvComidas.setLayoutManager(new GridLayoutManager(getContext(), 1));
        retrofit = new AdaptadorRetrofit().getAdaptador();
        api = retrofit.create(APIRest.class);
        getComidas(api);


        return root;
    }

    public void getComidas(APIRest api){
        listaComidas.clear();
        Call<List<Comida>> call = api.obtenerComidas();

        call.enqueue(new Callback<List<Comida>>() {
            @Override
            public void onResponse(Call<List<Comida>> call, Response<List<Comida>> response) {
                listaComidas = new ArrayList<Comida>(response.body());
                adaptadorComidas = new AdaptadorComidas(getContext(), listaComidas);
                rvComidas.setAdapter(adaptadorComidas);

            }

            @Override
            public void onFailure(Call<List<Comida>> call, Throwable t) {
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