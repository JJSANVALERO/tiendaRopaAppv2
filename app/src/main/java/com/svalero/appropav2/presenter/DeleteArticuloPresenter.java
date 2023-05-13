package com.svalero.appropav2.presenter;

import com.svalero.appropav2.adapter.RopaAdapter;
import com.svalero.appropav2.contract.DeleteArticuloContract;
import com.svalero.appropav2.model.DeleteArticuloModel;

public class DeleteArticuloPresenter implements DeleteArticuloContract.Presenter,
        DeleteArticuloContract.Model.OnDeleteArticuloListener {

    private DeleteArticuloModel model;

    private RopaAdapter view;


    public DeleteArticuloPresenter(RopaAdapter view) {
        this.view = view;
        model = new DeleteArticuloModel();

    }

    @Override
    public void deleteArticulo(long idRopa) {
        model.deleteArticulo(idRopa, this);
    }

    @Override
    public void onDeleteSuccess() {
        view.showMessage("El articulo se ha eliminado correctamente");
    }

    @Override
    public void onDeleteError(String message) {
        view.showError("Se ha producido un error al eliminar el articulo. Intentelo de nuevo");
    }
}