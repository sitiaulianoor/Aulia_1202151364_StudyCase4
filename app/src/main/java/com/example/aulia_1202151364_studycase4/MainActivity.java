package com.example.aulia_1202151364_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnListMhs, btnGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnListMhs = findViewById(R.id.bCariNama);
        btnGambar = findViewById(R.id.bCariGambar);

        btnListMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, ListMhsAsyncTask.class));
            }
        });

        btnGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImageAsyntask.class));
            }
        });
    }
}
