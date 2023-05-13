package com.svalero.appropav2.presenter;

import com.svalero.appropav2.contract.ArticuloDetailsContract;
import com.svalero.appropav2.domain.Ropa;
import com.svalero.appropav2.model.ArticuloDetailsModel;

public class ArticuloDetailsPresenter implements ArticuloDetailsContract.Presenter, ArticuloDetailsContract.Model.OnDetailArticuloListener {

    private ArticuloDetailsContract.View view;
    private ArticuloDetailsContract.Model model;

    public ArticuloDetailsPresenter(ArticuloDetailsContract.View view) {
        this.view = view;
        model = new ArticuloDetailsModel();
    }

    @Override
    public void loadArticulo(long idRopa) {
        model.loadArticulo(this, idRopa);
    }

    @Override
    public void onDetailArticuloSuccess(Ropa ropa) {
        if (view != null) {
            view.showArticulo(ropa);
        }
    }

    @Override
    public void onDetailArticuloError(String message) {
        if (view != null) {
            view.showError(message);
        }
    }

}
