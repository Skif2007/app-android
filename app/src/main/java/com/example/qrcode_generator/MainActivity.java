package com.example.qrcode_generator;
//Здесь основные зависимости проекта
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import net.glxn.qrgen.android.QRCode;

public class MainActivity extends AppCompatActivity {

    ImageView qrCodeImageView;
    EditText edittext;
    Button button ;
    public void gen_qr_code(String data, ImageView imageView) {
        Bitmap qrbitmap = QRCode.from(data).withSize(500,500).bitmap();
        imageView.setImageBitmap(qrbitmap);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        qrCodeImageView = findViewById(R.id.imageView3);
        edittext = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = edittext.getText().toString();
                gen_qr_code(text, qrCodeImageView);
            }
        });
    }

}
