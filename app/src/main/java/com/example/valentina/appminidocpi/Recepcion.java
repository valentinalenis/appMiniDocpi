package com.example.valentina.appminidocpi;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Recepcion extends AppCompatActivity implements ValueEventListener {

    TextView tvMed, Med;


    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mPruebaReference = mRootReference.child("Pacientes").child("p1").child("Medicamento");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepcion);
        iniciar();
    }

    private void iniciar() {
        tvMed = findViewById(R.id.tvMed);
        Med = findViewById(R.id.Med);

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

    public void actionConfirmar(View view) {
        startActivity(new Intent(this, Confirmar.class));
    }

    public void actionNovedad(View view) {
        startActivity(new Intent(this, Novedad.class));
    }
}