package com.example.anew.movieselected;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    ImageView image ;
    VideoView video;
    Button button;

    int permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView)findViewById(R.id.imageView);
        video = (VideoView)findViewById(R.id.videoView);
        button = (Button)findViewById(R.id.button);

        permission = ActivityCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(permission != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {READ_EXTERNAL_STORAGE},3);
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 0);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(permission != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this,new String[] {READ_EXTERNAL_STORAGE},3);
                }
                else{
                    Intent intent = new Intent (Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent ,1);
                }
            }
        });

    }

    @Override
    protected void onActivityResult (int requestCode , int resultCode ,Intent data){
        super.onActivityResult(requestCode , resultCode , data);
                switch (requestCode){
                    case 0 :
                        if(resultCode == RESULT_OK){
                            try{
                                Uri imageData = data.getData();
                                String[] filePathCloum = {MediaStore.Images.Media.DATA};
                                Cursor cursor = getContentResolver().query(imageData , filePathCloum ,null,null,null);
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex(filePathCloum[0]);
                                String path = cursor.getString(columnIndex);
                                cursor.close();
                                Bitmap bitmap = BitmapFactory.decodeFile(path);
                                image.setImageBitmap(bitmap);
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }

                        }
                        break;
                    case 1 :
                        if(data == null){
                            break;
                        }
                        Uri videoData = data.getData();
                        video.setVideoURI(videoData);
                        video.start();

                        break;
                }

    }

}
