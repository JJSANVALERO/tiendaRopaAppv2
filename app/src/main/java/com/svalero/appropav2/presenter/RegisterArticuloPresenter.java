package com.svalero.appropav2.presenter;

import com.svalero.appropav2.contract.RegisterArticuloContract;
import com.svalero.appropav2.domain.Ropa;
import com.svalero.appropav2.model.RegisterArticuloModel;
import com.svalero.appropav2.view.RegisterArticuloView;

public class RegisterArticuloPresenter implements RegisterArticuloContract.Presenter,
        RegisterArticuloContract.Model.OnRegisterArticuloListener {

    private RegisterArticuloModel model;

    private RegisterArticuloView view;

    public RegisterArticuloPresenter(RegisterArticuloView view) {
        this.view = view;
        model = new RegisterArticuloModel();

    }

    @Override
    public void registerArticulo(Ropa ropa) {
        model.registerArticulo(ropa, this);
    }

    @Override
    public void onRegisterArticuloSuccess(Ropa ropa) {
        view.showMessage("El articulo se ha registrado correctamente");
    }

    @Override
    public void onRegisterArticuloError(String message) {
        view.showError("Se ha producido un error al registrar el articulo. Intentelo de nuevo");
    }
}
