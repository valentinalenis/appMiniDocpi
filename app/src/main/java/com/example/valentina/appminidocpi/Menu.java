package com.example.valentina.appminidocpi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Menu extends AppCompatActivity implements View.OnClickListener , ValueEventListener {
    TextView tvMed, Med;
    ImageButton btnVerificar, btnNovedad, btnListar,btnAjustes;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mPruebaReference = mRootReference.child("Pacientes").child("p1").child("Medicamento");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        iniciar();
        btnVerificar.setOnClickListener(this);
        btnNovedad.setOnClickListener(this);
        btnListar.setOnClickListener(this);
        btnAjustes.setOnClickListener(this);
    }

    public void iniciar(){
        btnVerificar =  findViewById(R.id.btnVerificar);
        btnNovedad = findViewById(R.id.btnNovedad);
        btnListar =  findViewById(R.id.btnListar);
        btnAjustes =  findViewById(R.id.btnAjustes);
        tvMed = findViewById(R.id.tvMed);
        Med = findViewById(R.id.Med);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btnAjustes:
                //startActivity(new Intent(this, listar.class));
                break;
            case  R.id.btnVerificar:
                startActivity(new Intent(this, Confirmar.class));
                break;
            case R.id.btnNovedad:
                startActivity(new Intent(this, Novedad.class));
                break;
            case  R.id.btnListar:
                //startActivity(new Intent(this, listar.class));
                break;

        }
    }


    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!= null){
            String key = dataSnapshot.getKey();
            if(key.equals("Medicamento")){
                String prueba = dataSnapshot.getValue(String.class);
                tvMed.setText(prueba);
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
    @Override
    protected void onStart() {
        super.onStart();
        //mPacienteReference.addValueEventListener(this);
        mPruebaReference.addValueEventListener(this);
    }
}
