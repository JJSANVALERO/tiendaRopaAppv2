package com.svalero.appropav2.contract;

public interface DeleteArticuloContract {

    interface Model {
        interface OnDeleteArticuloListener{
            void onDeleteSuccess();
            void onDeleteError(String message);
        }
        void deleteArticulo(long idRopa, OnDeleteArticuloListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
    }

    interface Presenter {
        void deleteArticulo(long idRopa);
    }
}
