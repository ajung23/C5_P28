package com.example.w7_p2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    private EditText spell,cor,wro;
    private Button adbt, readbt, check;
    private DB dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        spell = findViewById(R.id.checktxt);
        check = findViewById(R.id.btncheck);

        cor = findViewById(R.id.trueword);
        wro = findViewById(R.id.falseword);
        adbt = findViewById(R.id.addpair);
        readbt = findViewById(R.id.showlist);

        dbh = new DB(MainActivity.this);


        check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String sp = spell.getText().toString();
                String kk = dbh.verify(sp);
                Toast.makeText(MainActivity.this,""+kk,Toast.LENGTH_LONG).show();
            }
        });





        adbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cst = cor.getText().toString();
                String csf = wro.getText().toString();

                if (cst.isEmpty() && csf.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter both field", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbh.add(cst,csf);
                Toast.makeText(MainActivity.this, "Word Pair has been added.", Toast.LENGTH_SHORT).show();
                cor.setText("");
                wro.setText("");

            }
        });
        readbt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this , Readc.class);
                startActivity(i);
            }

        });


    }


    }
