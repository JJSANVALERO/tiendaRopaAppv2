package com.svalero.appropav2.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.svalero.appropav2.R;
import com.svalero.appropav2.contract.DeleteArticuloContract;
import com.svalero.appropav2.domain.Ropa;
import com.svalero.appropav2.presenter.DeleteArticuloPresenter;
import com.svalero.appropav2.view.ArticuloDetailsView;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class RopaAdapter extends RecyclerView.Adapter<RopaAdapter.RopaHolder>
        implements DeleteArticuloContract.View{

    private Context context;
    private List<Ropa> listaRopa;

    private Intent intentFrom;

    private DeleteArticuloPresenter deleteRopaPresenter;

    private String token;

    private View snackBarView;

    public Context getContext() {
        return context;
    }


    public RopaAdapter(Context context, List<Ropa> dataList) {
        this.context = context;
        this.listaRopa = dataList;
        deleteRopaPresenter = new DeleteArticuloPresenter(this);

    }

    @Override
    public RopaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_articulo_item, parent, false);
        return new RopaHolder(view);
    }

    @Override
    public void onBindViewHolder(RopaHolder holder, int position) {
        holder.nombrePrenda.setText(listaRopa.get(position).getNombre());
        Log.d("tag", "He recibido la información");
        holder.precioPrenda.setText(String.valueOf(listaRopa.get(position).getPrecio()));
        holder.fechaAltaPrenda.setText(String.valueOf(listaRopa.get(position).getFechaAlta()));
    }

    @Override
    public int getItemCount() {
        return listaRopa.size();
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(snackBarView, errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(snackBarView, message,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    public class RopaHolder extends RecyclerView.ViewHolder {
        public TextView nombrePrenda;
        public TextView codigoPrenda;
        public TextView fechaAltaPrenda;
        public TextView precioPrenda;
        public TextView hasStockPrenda;

        public Button seeDetailsRopaButton;
        public Button deleteRopaButton;
        public View parentView;

        public RopaHolder(View view) {
            super(view);
            parentView = view;
            snackBarView = parentView;


            nombrePrenda = view.findViewById(R.id.tv_articulo_nombre);
            precioPrenda = view.findViewById(R.id.tv_articulo_precio);
            fechaAltaPrenda = view.findViewById(R.id.tv_articulo_fecha);
            seeDetailsRopaButton = view.findViewById(R.id.see_details_articulo_button);
            deleteRopaButton = view.findViewById(R.id.delete_articulo_button);


            // Ver detalles
            seeDetailsRopaButton.setOnClickListener(v -> seeDetails(getAdapterPosition()));
            // Eliminar tarea
            deleteRopaButton.setOnClickListener(v -> deleteRopa(getAdapterPosition()));
            //Modificar tarea



        }
    }

    private void seeDetails(int position) {
        Ropa ropa = listaRopa.get(position);
        Intent intent = new Intent(context, ArticuloDetailsView.class);
        intent.putExtra("idRopa", ropa.getIdRopa());
        context.startActivity(intent);
    }


    private void deleteRopa(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.are_you_sure_message)
                .setTitle(R.string.remove_ropa_message)
                .setPositiveButton(R.string.yes, ((dialog, id) -> {
                    Ropa ropa = listaRopa.get(position);
                    deleteRopaPresenter.deleteArticulo(ropa.getIdRopa());

                    listaRopa.remove(position);
                    notifyItemRemoved(position);
                }))
                .setNegativeButton(R.string.no, (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }



}