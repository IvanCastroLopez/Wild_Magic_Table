package com.example.wildmagictable;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.wildmagictable.Effect;
import com.example.wildmagictable.WildMagicDb;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText inputNumberEditText;
    private Button rollButton;
    private TextView effectTextView;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch languageToggleButton;

    private WildMagicDb database;

    private boolean isSpanishMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumberEditText = findViewById(R.id.editTextNumber);
        rollButton = findViewById(R.id.buttonRoll);
        languageToggleButton = findViewById(R.id.languageSwitch);

        database = new WildMagicDb(this);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputNumberEditText.getText() != null) {
                    showEffectInDialog();
                } else {
                    showDialog("Not even a number bro");
                }
            }
        });

        languageToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isSpanishMode = isChecked;
                if (!isSpanishMode) {
                    languageToggleButton.setText("🇬🇧");
                    inputNumberEditText.setHint("Input a number");
                } else {
                    languageToggleButton.setText("🇪🇸");
                    inputNumberEditText.setHint("Ingrese un número");
                }

            }
        });

    }

    private void showEffectInDialog() {
        int randomEffectNumber = Integer.parseInt(inputNumberEditText.getText().toString());
        List<Effect> effects = database.getEffects();

        if (randomEffectNumber < 1 || randomEffectNumber > effects.size()) {
            showDialog("Invalid effect number");
            return;
        }

        Effect effect = effects.get(randomEffectNumber - 1);

        if (isSpanishMode) {
            showDialog(effect.getSpanishEffect());
        } else {
            showDialog(effect.getEnglishEffect());
        }
    }

    private void showDialog(String effectText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Wild Magic Effect")
                .setMessage(effectText)
                .setPositiveButton("Ok", null)
                .show();
    }
}