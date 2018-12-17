package com.nauval.indeksberatbadan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Hitung extends AppCompatActivity {
    EditText edtNama, edtBB, edtTB;
    double beratBadan, tinggiBadan, bmi;
    String hasil, ket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung);

        edtNama = findViewById(R.id.edit_text_nama);
        edtBB = findViewById(R.id.edit_text_bb);
        edtTB = findViewById(R.id.edit_text_tb);
    }

    public void cekHasil(View view) {
        String nama = edtNama.getText().toString().trim();
        String sBeratBadan = edtBB.getText().toString().trim();
        String sTinggiBadan = edtTB.getText().toString().trim();

        if(edtNama.getText().toString().equals("")||edtBB.getText().toString().equals("")||edtTB.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Data Masih Kosong",Toast.LENGTH_SHORT).show();
        }
        else{
             beratBadan = Double.parseDouble(sBeratBadan);
            tinggiBadan = Double.parseDouble(sTinggiBadan);
            //rumus
            //BMI = Berat Badan kg/ (Tinggi Badan m * Tinggi Badan m)
            bmi = beratBadan/(tinggiBadan*tinggiBadan*0.0001);
            Log.d("tag","Nama = "+nama+"\nbmi = "+bmi+"");
            if (bmi<18.5){
                //Log.d("keterangan Perempuan", "Under Weight/Kurus – Sebaiknya mulai menambah berat badan dan mengkonsumsi makanan berkarbohidrat di imbangi dengan olah raga");
                hasil="Under Weight/Kurus";
                ket = "Sebaiknya mulai menambah berat badan dan mengkonsumsi makanan berkarbohidrat di imbangi dengan olah raga";
            }
            else if(bmi>=18.5&&bmi<25){
                //Log.d("keterangan Perempuan","Normal Weight/Normal – Bagus, berat badan anda termasuk kategori ideal");
                hasil="Normal Weight/Normal";
                ket = "Bagus, berat badan anda termasuk kategori ideal";
            }
            else if (bmi>=25&&bmi<30){
                //Log.d("keterangan Perempuan","Over Weight/Kegemukan – anda sudah masuk kategori gemuk. sebaiknya hindari makanan berlemak dan mulailah meningkatkan olahraga seminggu minimal 2 kali");
                hasil = "Over Weight/Kegemukan";
                ket = "Anda sudah masuk kategori gemuk. sebaiknya hindari makanan berlemak dan mulailah meningkatkan olahraga seminggu minimal 2 kali";
            }
            else{
                //Log.d("keterangan Perempuan","\tObesitas – Sebaiknya segera membuat program menurunkan berat badan karena anda termasuk kategori obesitas/ terlalu gemuk dan tidak baik bagi kesehatan");
                hasil="Obesitas";
                ket = "Sebaiknya segera membuat program menurunkan berat badan karena anda termasuk kategori obesitas/ terlalu gemuk dan tidak baik bagi kesehatan";
            }
            Log.d("tag","Nama = "+nama+"\nbmi = "+bmi+"\n"+"hasil : "+hasil+"\nket : "+ket+"\n");

        }

        Intent intent = new Intent(Hitung.this,Hasil.class);
        intent.putExtra("EXTRA_NAMA", nama);
        intent.putExtra("EXTRA_BB",beratBadan);
        intent.putExtra("EXTRA_TB",tinggiBadan);
        intent.putExtra("EXTRA_BMI",bmi);
        intent.putExtra("EXTRA_HASIL",hasil);
        intent.putExtra("EXTRA_KET",ket);
        startActivity(intent);
    }
}
