package com.example.android.anti_corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signIN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_i_n);
        Button signin = (Button) findViewById(R.id.backhome);
        final Intent i = new Intent(this,Home.class);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.Name);
                final String Name = name.getText().toString();
                EditText pass = (EditText) findViewById(R.id.Password);
                final String Pass = pass.getText().toString();
                Log.i("MainActivity",Name);
                Log.i("MainActivity",Pass);

                Toast.makeText(signIN.this,"Done" , Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });
    }
}
