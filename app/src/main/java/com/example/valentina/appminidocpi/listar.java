package com.example.valentina.appminidocpi;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class listar extends AppCompatActivity implements ValueEventListener{
    TextView tvMed, Med;
    EditText tvPrueba;
    Button btnAc;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mPruebaReference = mRootReference.child("Pacientes").child("p1").child("Formula").child("Medicamento");
    /*
    private DatabaseReference mPacienteReference = mRootReference.child("Pacientes");
    private DatabaseReference mPruebaReference = mRootReference.child("Prueba");
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listar);
        iniciar();


    }

    private void iniciar(){
        tvMed=(TextView) findViewById(R.id.tvMed);
        Med=(TextView) findViewById(R.id.Med);
        tvPrueba=(EditText) findViewById(R.id.tvPrueba);
        btnAc=(Button) findViewById(R.id.btnAc);
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

    public void metAcept(View view) {
        String prueba = tvPrueba.getText().toString();
        mPruebaReference.setValue(prueba);
        tvPrueba.setText("");
    }
}
