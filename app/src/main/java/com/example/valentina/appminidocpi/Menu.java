package com.example.valentina.appminidocpi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    ImageButton btnVerificar, btnNovedad, btnListar,btnAjustes;
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
        btnVerificar = (ImageButton) findViewById(R.id.btnVerificar);
        btnNovedad = (ImageButton) findViewById(R.id.btnNovedad);
        btnListar = (ImageButton) findViewById(R.id.btnListar);
        btnAjustes = (ImageButton) findViewById(R.id.btnAjustes);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnVerificar:

                break;
            case  R.id.btnListar:
                startActivity(new Intent(this, listar.class));
                break;
        }
    }

    // Read from the database
/*myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            String value = dataSnapshot.getValue(String.class);
            Log.d(TAG, "Value is: " + value);
        }

        @Override
        public void onCancelled(DatabaseError error) {
            // Failed to read value
            Log.w(TAG, "Failed to read value.", error.toException());
        }
    });*/
}
