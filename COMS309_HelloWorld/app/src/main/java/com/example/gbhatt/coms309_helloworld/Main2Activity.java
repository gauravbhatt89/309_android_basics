package com.example.gbhatt.coms309_helloworld;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private Button back;

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private Button init;
    private Bitmap bitmap;
    private int PICK_IMAGE_REQUEST = 1;
    private boolean initialized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView1  = (ImageView) findViewById(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                changeImage();
            }
        });
        imageView2  = (ImageView) findViewById(R.id.imageView2);
        imageView3  = (ImageView) findViewById(R.id.imageView3);
        imageView4  = (ImageView) findViewById(R.id.imageView4);
        imageView5  = (ImageView) findViewById(R.id.imageView5);

        init = (Button) findViewById(R.id.init);
        init.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                initialized = false;
                initialize_cells();
            }
        });

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(myIntent);
            }
        });
    }

    private void changeImage() {
        initialize_cells();
        imageView1.setImageBitmap(bitmap);
    }

    private void initialize_cells() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //Setting the Bitmap to ImageView
                if(!initialized) {
                    imageView1.setImageBitmap(bitmap);
                    imageView2.setImageBitmap(bitmap);
                    imageView3.setImageBitmap(bitmap);
                    imageView4.setImageBitmap(bitmap);
                    imageView5.setImageBitmap(bitmap);
                    initialized = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
