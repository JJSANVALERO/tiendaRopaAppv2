package com.svalero.appropav2.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.svalero.appropav2.R;
import com.svalero.appropav2.contract.RegisterArticuloContract;
import com.svalero.appropav2.domain.Ropa;
import com.svalero.appropav2.presenter.RegisterArticuloPresenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegisterArticuloView extends AppCompatActivity implements RegisterArticuloContract.View{

    private RegisterArticuloPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_articulo);

        presenter = new RegisterArticuloPresenter(this);

    }

    public void saveButton(View view) {
        EditText etNombre = findViewById(R.id.edit_text_nombre);
        EditText etCode = findViewById(R.id.edit_text_code);
        EditText etFecha = findViewById(R.id.edit_text_fecha);
        EditText etPrecio = findViewById(R.id.edit_text_precio);
        EditText etHayStock = findViewById(R.id.edit_text_hayStock);


        String nombre = etNombre.getText().toString();
        String code = etCode.getText().toString();
        String fecha = etFecha.getText().toString();
        double precio = Double.parseDouble(etPrecio.getText().toString());
        Boolean hayStock = Boolean.parseBoolean(etHayStock.getText().toString());



        Ropa ropa = new Ropa(nombre,code,fecha,precio,hayStock);
        presenter.registerArticulo(ropa);
    }


    public void goBackButton(View view) {
        onBackPressed();
    }


    @Override
    public void showError(String errorMessage) {
        Snackbar.make(((EditText) findViewById(R.id.edit_text_nombre)), errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(((EditText) findViewById(R.id.edit_text_nombre)), message,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void resetForm() {
        ((EditText) findViewById(R.id.edit_text_nombre)).setText("");
        ((EditText) findViewById(R.id.edit_text_code)).setText("");
        ((EditText) findViewById(R.id.edit_text_fecha)).setText("");
        ((EditText) findViewById(R.id.edit_text_precio)).setText("");
        ((EditText) findViewById(R.id.edit_text_hayStock)).setText("");

        ((EditText) findViewById(R.id.edit_text_nombre)).requestFocus();
    }
}
