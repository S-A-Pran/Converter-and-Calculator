package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Converter extends AppCompatActivity {

    EditText editText1,editText2;
    Button submit1,submit2,back,reset1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editText1 = findViewById(R.id.edit1);
        editText2 = findViewById(R.id.edit2);

        submit1 = findViewById(R.id.submitButton1);
        submit2 = findViewById(R.id.submitButton2);
        back = findViewById(R.id.backButton);
        reset1 = findViewById(R.id.reset);




        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String taka = editText1.getText().toString();
                    double tk = Double.parseDouble(taka);

                    double x = tk/84.64;
                    editText2.setText(String.valueOf(x));
                }catch (Exception e){
                    Toast.makeText(Converter.this,"Enter amount First",Toast.LENGTH_SHORT).show();
                }

            }
        });

        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String doller = editText2.getText().toString();
                    double dl = Double.parseDouble(doller);

                    double y = dl*84.64;

                    editText1.setText(String.valueOf(y));
                }catch (Exception e){
                    Toast.makeText(Converter.this,"Enter amount First",Toast.LENGTH_SHORT).show();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Converter.this,MainActivity.class);
                startActivity(i);
            }
        });

        reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = editText1.getText().toString();
                String num1 = editText2.getText().toString();

                if(num.isEmpty() && num1.isEmpty())
                {
                    Toast.makeText(Converter.this,"Both already empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    editText1.setText("");
                    editText2.setText("");
                }
            }
        });

    }


}
