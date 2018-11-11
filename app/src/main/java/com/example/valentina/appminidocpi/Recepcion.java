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

    Button btnConfirmarMed;
    TextView txtHorario;
    Integer dosis;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mPruebaReference = mRootReference.child("Pacientes").child("p1").child("Formula").child("Medicamento");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);
        iniciar();
    }

    private void iniciar() {
        btnConfirmarMed = findViewById(R.id.btnConfirmarMed);
        txtHorario = findViewById(R.id.txtHorario);
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class) != null){
            String key = dataSnapshot.getKey();
            if(key.equals("Dosis")){
                String estado = dataSnapshot.getValue(String.class);
                dosis = Integer.parseInt(estado);
                txtHorario.setText(dosis - 1);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
    public void confirmarMedicina(View view) {
        int recibido=0 ;
        recibido= recibido + 1;
        mPruebaReference.setValue(recibido);
        startActivity(new Intent(this, Menu.class));
    }
}