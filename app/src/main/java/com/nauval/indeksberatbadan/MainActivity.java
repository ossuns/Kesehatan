package com.nauval.indeksberatbadan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_hitung, btn_tentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_hitung = (Button)findViewById(R.id.btn_hitung);
        //set on click listener pada button
        btn_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Hitung.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Hitung Berat Badang Ideal", Toast.LENGTH_SHORT).show();
            }
        });

        btn_tentang = (Button)findViewById(R.id.btn_tentang);
        //set on click listener pada button
        btn_tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Tentang.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Tentang Aplikasi Berat Badang Ideal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

