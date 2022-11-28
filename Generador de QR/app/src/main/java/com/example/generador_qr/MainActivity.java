package com.example.generador_qr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    ImageView ivCodigoQR;
    EditText etDatos;
    Button btnGenerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivCodigoQR = findViewById(R.id.ivCodigob);
        etDatos = findViewById(R.id.etDatos);
        btnGenerar = findViewById(R.id.btnGenerar);
    }


    public void generar (View view) {

        try {

            /* DATOS PARA MANEJAR
             *  TELEFONO ES: tel:
             *  SMS ES: numero:mensaje
             *  MAIL: mailto
             * */



            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap("mail:"+etDatos.getText().toString(), BarcodeFormat.QR_CODE, 750, 750);

            ivCodigoQR.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}