package com.example.loginrest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Retrofit;

public class AdaptadorComidas extends RecyclerView.Adapter<AdaptadorComidas.ComidaViewHolder> {

    Context context;

    List<Comida> listaComidas;

    List<OrdenDetalles> listaOrdenDetalles;

    AdaptadorOrdenesDetalles adaptadorOrdenesDetalles;

    Retrofit retrofit;

    APIRest api;

    public Integer idComida;


    public AdaptadorComidas(Context context, List<Comida> listaComidas){
        this.context = context;
        this.listaComidas = listaComidas;
    }

    @NonNull
    @Override
    public AdaptadorComidas.ComidaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.comidas, null, false);
        return new AdaptadorComidas.ComidaViewHolder(vista);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorComidas.ComidaViewHolder holder, int position) {
        if (listaComidas == null) {
            Log.e("AdaptadorComidas", "listaComidas es null");
            return;
        }
        Comida comida = listaComidas.get(position);
        if (comida == null) {
            Log.e("AdaptadorComidas", "comida en la posición " + position + " es null");
            return;
        }

        String resourceName = "comida" + listaComidas.get(position).getId_alimento();
        if (resourceName == null) {
            Log.e("AdaptadorComidas", "resourceName es null para comida con id " + comida.getId_alimento());
            return;
        }

        if (context == null) {
            Log.e("AdaptadorComidas", "context es null");
            return;
        }

        int resourceId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        if (resourceId == 0) {
            Log.e("AdaptadorComidas", "No se encontró el recurso drawable para " + resourceName);
            return;
        }

        if (holder.imageComida == null) {
            Log.e("AdaptadorComidas", "imageComida en holder es null");
            return;
        }

        holder.imageComida.setImageResource(resourceId);
        if (holder.tvNombreComida != null) {
            holder.tvNombreComida.setText(listaComidas.get(position).getNombre());
        } else {
            Log.e("AdaptadorComidas", "tvNombreComida en holder es null");
        }

        if (holder.tvPrecio != null) {
            holder.tvPrecio.setText(listaComidas.get(position).getDescripcion());
        } else {
            Log.e("AdaptadorComidas", "tvPrecio en holder es null");
        }

        holder.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Agregar el elemento a la lista OrdenDetalles
                OrdenDetalle ordenDetalle = new OrdenDetalle();
                ordenDetalle.setId_alimento(comida.getId_alimento());
                ordenDetalle.setCantidad(1); // Por ejemplo, cantidad fija de 1
                ordenDetalle.setPrecio_total(comida.getPrecio()); // Usar el precio de la comida

                // Aquí necesitas una referencia a la lista de OrdenDetalles
                listaOrdenDetalles.add(ordenDetalle);

                // Opcional: mostrar un mensaje al usuario
                Toast.makeText(context, "Agregado a la orden", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaComidas.size();
    }

    public class ComidaViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombreComida, tvPrecio;

        ImageView imageComida;
        Button btnAgregar;


        public ComidaViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombreComida = itemView.findViewById(R.id.tvNombreComida);
            tvPrecio       = itemView.findViewById(R.id.tvPrecio);
            imageComida    = itemView.findViewById(R.id.imagecomida);
            btnAgregar = itemView.findViewById(R.id.btnAgregar);
        }
    }
}
