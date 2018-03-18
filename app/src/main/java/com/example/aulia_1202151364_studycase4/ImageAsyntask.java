package com.example.aulia_1202151364_studycase4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.InputStream;
import java.net.URL;

public class ImageAsyntask extends AppCompatActivity {

    private EditText edURL;
    private Button btnCari;
    private ImageView imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_asyntask);

        edURL = findViewById(R.id.edit_url);
        btnCari = findViewById(R.id.cari_image);
        imageUrl = findViewById(R.id.image_url);
    }

    class LoadImage extends AsyncTask<Void, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(Void... voids) {
            Bitmap bitmap = null;

            //menyimpan url dalam sebuah string
            String url = edURL.getText().toString();

            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageUrl.setImageBitmap(bitmap);
            } else {
                Toast.makeText(ImageAsyntask.this, "Link Salah", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void Cari(View view) {
        //mengekseskusi method LoadImage
        new LoadImage().execute();
    }
}
