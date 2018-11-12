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

public class Confirmar extends AppCompatActivity implements ValueEventListener, View.OnClickListener {

    Button btnConfirmarMed;
    TextView txtHorario;
    static Integer dosis=0 ;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mEstadoReference = mRootReference.child("Pacientes").child("p1").child("Recibido");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);
        iniciar();
    }

    private void iniciar() {
        btnConfirmarMed = findViewById(R.id.btnConfirmarMed);
        btnConfirmarMed.setOnClickListener(this);
        txtHorario = findViewById(R.id.txtHorario);
    }

    public void confirmarMedicina(Integer result) {
        Integer recibido = result;
        mEstadoReference.setValue(recibido);
        btnConfirmarMed.setEnabled(Boolean.TRUE);
        
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(Integer.class) != null){
            String key = dataSnapshot.getKey();
            if(key.equals("Dosis")) {
                Integer dosis = dataSnapshot.getValue(Integer.class);
                txtHorario.setText(dosis.toString());
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

    @Override
    public void onClick(View v) {
        confirmarMedicina(++dosis);
        startActivity(new Intent(this, Recepcion.class));
    }
}
