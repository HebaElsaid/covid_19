package com.example.android.anti_corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button signup = (Button) findViewById(R.id.signUP);
        TextView signin = (TextView) findViewById(R.id.signIN);
        final Intent i = new Intent(this,Home.class);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.Name);
                String Name = name.getText().toString();
                EditText email = (EditText) findViewById(R.id.Email);
                String Email = email.getText().toString();
                EditText pass = (EditText) findViewById(R.id.Password);
                String Pass = pass.getText().toString();
                Log.i("MainActivity",Name);
                Log.i("MainActivity",Email);
                Log.i("MainActivity",Pass);
                User u = new User(0,Name,Email,Pass);
                new UserDB().insert(u);
                Toast.makeText(Home.this,"Done" , Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });
    }
    public void SignIN(View v){
        Intent i = new Intent(this,signIN.class);
        startActivity(i);
    }
}
