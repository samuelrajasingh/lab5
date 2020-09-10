package com.urk17cs290.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Spinner;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final SharedPreferences myprefs=getSharedPreferences("myprefs",MODE_PRIVATE);
        final Spinner spinner;
        MaterialButton btn=findViewById(R.id.button);
        final ConstraintLayout cl;
        cl=findViewById(R.id.layout);
        MaterialButton log=findViewById(R.id.button2);

        switch (  myprefs.getString("color","")){
            case "Red":cl.setBackgroundColor(Color.RED);
                break;
            case "Blue":cl.setBackgroundColor(Color.BLUE);
                break;
            case "Green":cl.setBackgroundColor(Color.GREEN);
                break;
            case "Yellow":cl.setBackgroundColor(Color.YELLOW);
                break;
            default:
                break;
        }

        spinner=findViewById(R.id.spinner);
        spinner.setPrompt("Select a Color");


        btn.setOnClickListener(v->{
            String color=spinner.getSelectedItem().toString();
            SharedPreferences.Editor editor=myprefs.edit();
            editor.putString("color",color);
            editor.apply();
            switch (color){
                case "red":cl.setBackgroundColor(Color.RED);
                    break;
                case "blue":cl.setBackgroundColor(Color.BLUE);
                    break;

                case "green":cl.setBackgroundColor(Color.GREEN);
                    break;
                case "yellow":cl.setBackgroundColor(Color.YELLOW);
                    break;


            }
        });
        log.setOnClickListener(v->{
            SharedPreferences.Editor editor=myprefs.edit();

            editor.putString("username","");
            editor.putString("password","");
            editor.apply();
            Intent myintent3 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(myintent3);
        });
    }
}