package it.michele.permissionapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ErrorDialog extends AppCompatDialogFragment {

    /*
    Crea un Dialog contenente il messaggio di richiesta connessione ad internet.
    Al click del testo "Ok" l'applicazione viene chiusa
     */
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Errore")
                .setMessage("L'applicazione deve essere connessa ad internet")
                .setPositiveButton("Ok", (dialog, which) -> {
                    getActivity().finishAndRemoveTask();
                    System.exit(0);
                });
        return builder.create();
    }
}
