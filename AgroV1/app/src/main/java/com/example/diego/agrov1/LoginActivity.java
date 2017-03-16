package com.example.diego.agrov1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText user;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onClick(View view){

        /*user = (EditText) findViewById(R.id.user);
        String username = user.getText().toString();
        password = (EditText) findViewById(R.id.password);
        String pass = password.getText().toString();*/
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
        /*if ((username.equals((EditText)"diego")) && (pass.equals("diego"))){

            startActivity(intent);

        }else{

            startActivity(intent);
        }*/

    }
}
