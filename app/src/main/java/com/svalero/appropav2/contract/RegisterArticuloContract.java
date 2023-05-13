package com.svalero.appropav2.contract;

import com.svalero.appropav2.domain.Ropa;

public interface RegisterArticuloContract {

    interface Model {
        interface OnRegisterArticuloListener {
            void onRegisterArticuloSuccess(Ropa ropa);
            void onRegisterArticuloError(String message);
        }
        void registerArticulo (Ropa ropa, OnRegisterArticuloListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
        void resetForm();

    }

    interface Presenter {
        void registerArticulo(Ropa ropa);
    }
}
