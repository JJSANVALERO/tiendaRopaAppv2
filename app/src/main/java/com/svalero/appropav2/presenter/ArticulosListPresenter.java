package com.svalero.appropav2.presenter;

import com.svalero.appropav2.contract.ArticulosListContract;
import com.svalero.appropav2.domain.Ropa;
import com.svalero.appropav2.model.ArticulosListModel;
import com.svalero.appropav2.view.ArticulosListView;

import java.util.List;

public class ArticulosListPresenter implements ArticulosListContract.Presenter,
        ArticulosListContract.Model.OnLoadArticulosListener{

    private ArticulosListModel model;
    private ArticulosListView view;

    public ArticulosListPresenter(ArticulosListView view) {
        this.view = view;
        this.model = new ArticulosListModel();

    }

    @Override
    public void loadAllArticulos() {
        model.loadAllArticulos(this);
    }

    @Override
    public void loadArticuloByNombre(String nombre) {

    }

    @Override
    public void deleteArticulo(Ropa ropa) {

    }

    @Override
    public void onLoadArticulosSuccess(List<Ropa> listaRopa) {
        view.showArticulos(listaRopa);
    }

    @Override
    public void onLoadArticulosError(String message) {
        view.showMessage(message);
    }
}