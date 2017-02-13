package com.example.dm2.xml;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button act1,act2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        act1 = (Button) findViewById(R.id.btnact1);
        act2 = (Button) findViewById(R.id.btnact2);
    }


    public void actividad1(View v)
    {
        Intent intent = new Intent(MainActivity.this, Actividad1.class);
        startActivity(intent);
    }
    public void actividad2(View v)
    {
        Intent intent = new Intent(MainActivity.this, Actividad2.class);
        startActivity(intent);
    }
}
