package es.iessaladillo.pedrojoya.tipcalculator.utils;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class TextChangedListener {
    private TextChangedListener(){

    }

    public static void is_changed(EditText texto, TextView label, Activity activity){
        texto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkText(texto, label, s, activity);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private static void checkText(EditText txt, TextView lbl, CharSequence word, Activity activity) {
        boolean empty = (word.length() == 0 || word.toString().equals("0"));
        if (empty) {
            lbl.setEnabled(false);
        } else {
            lbl.setEnabled(true);
        }
    }
}
