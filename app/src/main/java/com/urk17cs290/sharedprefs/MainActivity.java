package com.urk17cs290.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText userEdit;
        TextInputEditText passEdit;
        userEdit = findViewById(R.id.username);
        passEdit = findViewById(R.id.password);
        MaterialButton login = findViewById(R.id.login);
        MaterialCheckBox cb;
        cb = findViewById(R.id.remember);
        final SharedPreferences myprefs=getSharedPreferences("myprefs",MODE_PRIVATE);
        if(myprefs.getString("username","").equals("sam")){
            if(myprefs.getString("password","").equals("123")){
                Intent myintent1 = new Intent(getApplicationContext(), MainActivity2.class);
                myintent1.putExtra("user", "sam");

                startActivity(myintent1);
            }
        }
        login.setOnClickListener(v->{
            String username = Objects.requireNonNull(userEdit.getText()).toString().trim();
            String password = Objects.requireNonNull(passEdit.getText()).toString().trim();
            if (username.equals("") || password.equals("")){
                Toast.makeText(MainActivity.this,"Enter username and password" , Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                if(cb.isChecked()){
                    SharedPreferences.Editor editor=myprefs.edit();
                    editor.putString("username",username);
                    editor.putString("password",password);
                    editor.apply();

                if(username.equals("sam")&&password.equals("123")) {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    Intent myintent = new Intent(getApplicationContext(), MainActivity2.class);
                    myintent.putExtra("user", username);
                    startActivity(myintent);
                }
                else
                    Toast.makeText(getApplicationContext(),"Wrong username and password", Toast.LENGTH_SHORT).show();
            }
            }
        });


    }
}