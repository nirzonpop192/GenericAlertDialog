package com.faisal.peoplentech.lecture.genericalertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                AlertDialogManager.getInstance().showInfoDialog(MainActivity.this, "Open Activity", new SingleDialogsClickListener() {
//                    @Override
//                    public void onOkClick(DialogInterface dialog, int which) {
//                        startActivity(new Intent(MainActivity.this,Main2Activity.class));
//                    }
//                });

                AlertDialogManager.getInstance(MainActivity.this).showInfoDialog("Context opne", new SingleDialogsClickListener() {
                    @Override
                    public void onOkClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(MainActivity.this,Main2Activity.class));
                    }
                });
            }
        });
    }
}
