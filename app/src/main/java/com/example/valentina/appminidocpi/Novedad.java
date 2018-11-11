package com.example.valentina.appminidocpi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v13.view.DragStartHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Novedad extends AppCompatActivity  {
    EditText txtNovedad;
    Button btnEnvNovedad;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mNovedadReference = mRootReference.child("Pacientes").child("p1").child("Novedad");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novedad);
        iniciar();
    }

    private void iniciar() {
        txtNovedad =(EditText) findViewById(R.id.txtNovedad);
        btnEnvNovedad =(Button) findViewById(R.id.btnEnvNovedad);

    }



    @Override
    protected void onStart() {
        super.onStart();
    }

    public void enviarNovedad(View view) {
        String novedad = txtNovedad.getText().toString();
        mNovedadReference.setValue(novedad);
        startActivity(new Intent(this, Menu.class));
    }
}
