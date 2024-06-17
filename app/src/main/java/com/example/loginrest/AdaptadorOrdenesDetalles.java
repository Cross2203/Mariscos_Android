package com.example.loginrest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorOrdenesDetalles extends RecyclerView.Adapter<AdaptadorOrdenesDetalles.OrdenesDetallesViewHolder> {

    Context context;

    List<OrdenDetalles> listaOrdenDetalles;

    List<Comida> listaComida;

    public AdaptadorOrdenesDetalles(Context context, List<OrdenDetalles> listaOrdenDetalles, List<Comida> listaComida) {
        this.context = context;
        this.listaOrdenDetalles = listaOrdenDetalles;
        this.listaComida = listaComida;
    }

    @NonNull
    @Override
    public AdaptadorOrdenesDetalles.OrdenesDetallesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.orden, null, false);
        return new AdaptadorOrdenesDetalles.OrdenesDetallesViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorOrdenesDetalles.OrdenesDetallesViewHolder holder, int position) {
        int idAlimento = Integer.parseInt(listaOrdenDetalles.get(position).getId_alimento());
        String nombreAlimento = "";
        for (Comida comida : listaComida) {
            if (Integer.parseInt(comida.getId_alimento()) == idAlimento) {
                nombreAlimento = comida.getNombre();
                break;
            }
        }


        holder.tvItem.setText(nombreAlimento);
        holder.tvCantidad.setText(listaOrdenDetalles.get(position).getCantidad());
        holder.tvTotal.setText(listaOrdenDetalles.get(position).getPrecio_total());
    }

    @Override
    public int getItemCount() {
        return listaOrdenDetalles.size();
    }

    public class OrdenesDetallesViewHolder extends RecyclerView.ViewHolder {

        TextView tvItem, tvCantidad, tvTotal;

        public OrdenesDetallesViewHolder(@NonNull View itemView) {
            super(itemView);

            tvItem = itemView.findViewById(R.id.tvItem);
            tvCantidad = itemView.findViewById(R.id.tvCantidad);
            tvTotal = itemView.findViewById(R.id.tvTotal);

        }
    }
}
