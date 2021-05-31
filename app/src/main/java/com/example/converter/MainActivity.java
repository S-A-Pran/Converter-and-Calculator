package com.example.converter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] chose;
    private Spinner spinner;
    private TextView textView1;
    private TextView textView2;
    private Button button;
    private ImageView imageView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menue_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.share)
        {
            Toast.makeText(MainActivity.this,"Share is selected",Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.feedback)
        {
            Toast.makeText(MainActivity.this,"Feedback is selected",Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.about)
        {
            Intent intent = new Intent(MainActivity.this,About.class);
            startActivity(intent);

        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chose=getResources().getStringArray(R.array.chose);

        spinner = findViewById(R.id.choise);
        button = findViewById(R.id.submit);
        imageView = findViewById(R.id.sabbir);
        final int currentItem = 0;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.sampleid,chose);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                try {
                    if(currentItem == position)
                    {
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(MainActivity.this,Calculator.class);
                                startActivity(intent);
                            }
                        });
                    }
                    else
                    {
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(MainActivity.this,Converter.class);
                                startActivity(intent);
                            }
                        });
                    }

                }catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"Select one first",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this,"Select an item first",Toast.LENGTH_SHORT).show();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Sabbir Alam Pran. Diu-Cse: 46th Batch",Toast.LENGTH_LONG).show();
            }
        });

    }


}
