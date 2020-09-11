package by.andersen.intern.recyclerviewfigurelist.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import androidx.fragment.app.DialogFragment;

import by.andersen.intern.recyclerviewfigurelist.R;



public class AlertDialogFragment extends DialogFragment {

    Button buttonOk;
    TextView inputTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alert_dialog_fragment, container, false);
        buttonOk = view.findViewById(R.id.buttonOK);
        inputTextView = view.findViewById(R.id.text_title);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.title)
                .setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               dismiss();
            }
        });


        return view;
    }



}
