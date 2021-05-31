package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity implements View.OnClickListener{

    private Button addButton,subButton,divButton,mulButton,backButton,reset1;
    private EditText editText1,editText2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText1 = findViewById(R.id.editext1);
        editText2 = findViewById(R.id.editext2);

        addButton = findViewById(R.id.add);
        subButton = findViewById(R.id.sub);
        divButton = findViewById(R.id.div);
        mulButton = findViewById(R.id.mul);
        backButton = findViewById(R.id.back);
        reset1 = findViewById(R.id.reset);

        textView = findViewById(R.id.result);

        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Calculator.this,MainActivity.class);
                startActivity(intent);
            }
        });
        reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = editText1.getText().toString();
                String y = editText2.getText().toString();
                String z = textView.getText().toString();

                if(x.isEmpty() && y.isEmpty() && z.isEmpty())
                {
                    Toast.makeText(Calculator.this,"Already empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    editText1.setText("");
                    editText2.setText("");
                    textView.setText("");
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

        try {

            String number1 = editText1.getText().toString();
            String number2 = editText2.getText().toString();

            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            if(view.getId()==R.id.add)
            {
                double sum = num1+num2;
                textView.setText("Result: "+sum);
            }
            else if(view.getId() == R.id.sub)
            {
                double sub = num1-num2;
                textView.setText("Result: "+sub);
            }
            else if(view.getId() == R.id.div)
            {
                double div = num1/num2;
                textView.setText("Result: "+div);
            }
            else if(view.getId() == R.id.mul)
            {
                double mul = num1*num2;
                textView.setText("Result: "+mul);
            }


        }catch (Exception e)
        {
            Toast.makeText(Calculator.this, "Enter something first", Toast.LENGTH_SHORT).show();
        }


    }
}
