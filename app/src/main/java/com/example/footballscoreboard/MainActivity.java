package com.example.footballscoreboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer accountRussia = 0;
    private Integer accountGermany = 0;


    TextView textView2; // Табло России
    TextView textView3; // Табло Германии

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Находим View-элементы
        textView3 = findViewById(R.id.textView3);
        textView3.setText(String.valueOf(accountGermany));
        textView2 = findViewById(R.id.textView2);
        textView2.setText(String.valueOf(accountRussia));
    }

    // Табло Германии
    public void clickOnGermany(View view) {
        accountGermany++;
        textView3.setText(String.valueOf(accountGermany));
    }

    // Табло России
    public void clickOnRussia(View view) {
        accountRussia++;
        textView2.setText(String.valueOf(accountRussia));
    }

    public void clickOnReset(View view) {
        textView3.setText(String.valueOf(accountGermany = 0));
        textView2.setText(String.valueOf(accountRussia = 0));
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState !=null && savedInstanceState.containsKey("accountRussia") && savedInstanceState.containsKey("accountGermany")){
            accountRussia = savedInstanceState.getInt("accountRussia");
            accountGermany = savedInstanceState.getInt("accountGermany");
            textView2.setText(String.valueOf(accountRussia));
            textView3.setText(String.valueOf(accountGermany));
        }

    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("accountRussia", accountRussia);
        outState.putInt("accountGermany", accountGermany);
    }
}