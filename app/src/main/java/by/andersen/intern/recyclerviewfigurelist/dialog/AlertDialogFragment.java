package by.andersen.intern.recyclerviewfigurelist.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import by.andersen.intern.recyclerviewfigurelist.R;

/**
 * Работа с RecyclerView. Список из 10 элементов произвольного содержания (например, геометрические фигуры).
 * При нажатии отображать AlertDialogFragment с номером элемента (цифрой и, в скобках, словами, например - 1 (первый)).
 */

public class AlertDialogFragment extends DialogFragment {
    private static final String TAG = "AlertDialog";

    private Button buttonOk;
    private String transmittedText = null;

    public AlertDialogFragment() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Log.w(TAG, " i'm here ");
        
        if(getArguments() != null) {
            Bundle bundle = getArguments();
          transmittedText = bundle.getString("transmitted_text");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setMessage(transmittedText)
                .setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (buttonOk == null) {
                            dismiss();
                        }
                    }
                });

        Log.w(TAG, " done");
        return builder.create();
    }
}


