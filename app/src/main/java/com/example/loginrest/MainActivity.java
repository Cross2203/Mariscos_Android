package com.example.loginrest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText et_Usuario, et_Password;
    private Button btn_Login;

    private List<Usuario> listaUsuarios = new ArrayList<>();
    private Button btn_login;



    Retrofit retrofit;

    private APIRest api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_login = findViewById(R.id.btnlogin);
        et_Password = findViewById(R.id.etpassword);
        et_Usuario = findViewById(R.id.etusuario);
        retrofit = new AdaptadorRetrofit().getAdaptador();

        api = retrofit.create(APIRest.class);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarOrden(api);
                Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(intent);


            }
        });



    }

    public void agregarOrden (final APIRest api){
        Orden orden = new Orden();
        orden.setId_cliente("1");
        orden.setDireccion_entrega("Valle de los Chillos");
        orden.setId_estado("1");
        orden.setEstado("pendiente");
        orden.setFecha("2022-05-05");
        orden.setTotal("0.00");

        Call<Void> call = api.agregarOrden(orden);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                switch (response.code()){
                    case 400:
                        Toast.makeText(MainActivity.this, "Faltan campos", Toast.LENGTH_LONG).show();
                        System.out.println("No vale");
                        break;

                    case 200:
                        Toast.makeText(MainActivity.this, "Se inserto correctamente", Toast.LENGTH_LONG).show();
                        System.out.println("Esto es un juego");

                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No se pudo conectar", Toast.LENGTH_LONG).show();
                Log.e("TAG", "Error" + t);
            }
        });

    }

}