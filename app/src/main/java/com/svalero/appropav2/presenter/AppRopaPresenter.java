package com.svalero.appropav2.presenter;

import com.svalero.appropav2.contract.AppRopaContract;
import com.svalero.appropav2.domain.Ropa;
import com.svalero.appropav2.model.AppRopaModel;
import com.svalero.appropav2.view.AppRopaView;

public class AppRopaPresenter implements AppRopaContract.Presenter {

    private AppRopaModel model;
    private AppRopaView view;

    public AppRopaPresenter(AppRopaView view) {
        this.model = new AppRopaModel();
        this.view = view;
    }

    @Override
    public void loadAllArticulos() {

    }

    @Override
    public void loadArticuloByNombre(String nombre) {

    }

    @Override
    public void deleteArticulo(Ropa ropa) {

    }
}
