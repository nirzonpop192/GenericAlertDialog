package com.faisal.peoplentech.lecture.genericalertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       /* AlertDialogManager.getInstance().showInfoDialog(this, "this", new SingleDialogsClickListener() {
            @Override
            public void onOkClick(DialogInterface dialog, int which) {

            }
        });*/
       AlertDialogManager.getInstance(this).showInfoDialog("Double", new SingleDialogsClickListener() {
           @Override
           public void onOkClick(DialogInterface dialog, int which) {
               
           }
       });
    }
}
