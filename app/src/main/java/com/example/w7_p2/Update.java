package com.example.w7_p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    private EditText corr,wron;
    private Button upd, del;
    private DB db;
    String correct,falseword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        corr = findViewById(R.id.ecorr);
        wron = findViewById(R.id.efalse);
        upd = findViewById(R.id.btnup);
        del = findViewById(R.id.btndel);

        db = new DB(Update.this);

        correct = getIntent().getStringExtra("Correct");
        falseword = getIntent().getStringExtra("Wrong");

        corr.setText(correct);
        wron.setText(falseword);

        upd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                db.update(corr.getText().toString(),wron.getText().toString());

                Toast.makeText(Update.this, "Pair Updated", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Update.this,MainActivity.class);
                startActivity(i);
            }
        });
        del.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                db.delete(correct);
                Toast.makeText(Update.this,"Deleted the pair", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Update.this,MainActivity.class);
                startActivity(i);
            }




        });


    }
}