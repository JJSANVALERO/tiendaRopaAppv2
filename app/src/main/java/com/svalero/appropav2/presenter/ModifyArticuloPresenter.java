package com.svalero.appropav2.presenter;

import com.svalero.appropav2.contract.ModifyArticuloContract;
import com.svalero.appropav2.domain.Ropa;
import com.svalero.appropav2.model.ModifyArticuloModel;
import com.svalero.appropav2.view.ArticuloDetailsView;

public class ModifyArticuloPresenter implements ModifyArticuloContract.Presenter, ModifyArticuloContract.Model.OnModifyArticuloListener {
    private ModifyArticuloModel model;
    private ArticuloDetailsView view;

    public ModifyArticuloPresenter(ArticuloDetailsView view){
        model = new ModifyArticuloModel();
        this.view = view;
    }

    @Override
    public void modifyArticulo(Ropa ropa, long idRopa) {
        model.modifyArticulo(ropa, this,idRopa);
    }

    @Override
    public void onModifyArticuloSuccess(Ropa ropa) {
        if (ropa != null) {
            view.showMessage("El articulo: se ha editado correctamente!");
        } else {
            view.showError("El objeto Ropa recibido es nulo.");
        }
    }


    @Override
    public void onModifyArticuloError(String message) {
        view.showError(message);
    }

}
