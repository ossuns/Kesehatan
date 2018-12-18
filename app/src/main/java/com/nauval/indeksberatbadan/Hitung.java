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
            if (bmi<15){
                //Log.d("keterangan Perempuan", "Under Weight/Kurus – Sebaiknya mulai menambah berat badan dan mengkonsumsi makanan berkarbohidrat di imbangi dengan olah raga");
                hasil="Very Severely Underweight/Sangat Kurus Sekali";
                ket = "Sebaiknya melakukan konsultasi pada dokter" +
                        "Perlu diingat BMI tidak dapat diaplikasikan kepada anak-anak, wanita hamil, orang berbadan berotot, dan orang tua";
            }
            else if(bmi>=15&&bmi<16){
                //Log.d("keterangan Perempuan","Normal Weight/Normal – Bagus, berat badan anda termasuk kategori ideal");
                hasil="Severely Underweight/Normal";
                ket = "Mulai melakukan konsultasi dokter dan memulai makan makanan yang banyak mengandung karbohidrat tinggi, kalori dan makanan padat" +
                        "Perlu diingat BMI tidak dapat diaplikasikan kepada anak-anak, wanita hamil, orang berbadan berotot, dan orang tua";
            }
            else if(bmi>=16.00&&bmi<18.5){
                //Log.d("keterangan Perempuan","Normal Weight/Normal – Bagus, berat badan anda termasuk kategori ideal");
                hasil="Underweight/Normal";
                ket = "Perbanyak konsumsi makanan yang mengandung karbohidrat tinggi, kalori dan makanan padat" +
                        "Perlu diingat BMI tidak dapat diaplikasikan kepada anak-anak, wanita hamil, orang berbadan berotot, dan orang tua";
            }
            else if(bmi>=18.5&&bmi<25){
                //Log.d("keterangan Perempuan","Normal Weight/Normal – Bagus, berat badan anda termasuk kategori ideal");
                hasil="Healthy Weight/Normal";
                ket = "Bagus, berat badan anda termasuk kategori ideal. Menjaga pola makan dan olahraga agar tidak mengalami penurunan dan penambahan berat badan" +
                        "Perlu diingat BMI tidak dapat diaplikasikan kepada anak-anak, wanita hamil, orang berbadan berotot, dan orang tua";
            }
            else if (bmi>=25&&bmi<30){
                //Log.d("keterangan Perempuan","Over Weight/Kegemukan – anda sudah masuk kategori gemuk. sebaiknya hindari makanan berlemak dan mulailah meningkatkan olahraga seminggu minimal 2 kali");
                hasil = "Over Weight/Kegemukan";
                ket = "Anda sudah masuk kategori gemuk. sebaiknya hindari makanan berlemak, yang mengandung karbohidrat dan kalori tinggi. Mulailah meningkatkan olahraga serta menjaga pola makan" +
                        "Perlu diingat BMI tidak dapat diaplikasikan kepada anak-anak, wanita hamil, orang berbadan berotot, dan orang tua";
            }
            else{
                //Log.d("keterangan Perempuan","\tObesitas – Sebaiknya segera membuat program menurunkan berat badan karena anda termasuk kategori obesitas/ terlalu gemuk dan tidak baik bagi kesehatan");
                hasil="Obesitas";
                ket = "Pada kategori ini lebih baik anda mulai melakukan konsultasi dokter dan ikuti program penurunan berat badan sebisa mungkin" +
                        "Perlu diingat BMI tidak dapat diaplikasikan kepada anak-anak, wanita hamil, orang berbadan berotot, dan orang tua";
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
