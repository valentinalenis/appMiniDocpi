package com.example.valentina.appminidocpi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText txtId, txtClave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciar();
    }
    public void iniciar(){
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtClave = (EditText) findViewById(R.id.txtClave);
        txtId = (EditText) findViewById(R.id.txtId);
        btnLogin.setOnClickListener(this);
    }

    public void validacion(){
        if((txtId.getText().toString().equals("123456")) && (txtClave.getText().toString().equals("123456") )){
            startActivity(new Intent(this, Recepcion.class));
        }else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                validacion();
                break;
        }
    }
}
