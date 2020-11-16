package com.faisal.peoplentech.lecture.genericalertdialog;

import android.content.DialogInterface;

// this is Custom interface
// এটা আমার তৈরি একটা ইন্টারফেইজ
public interface SingleDialogsClickListener {

    // declaration of a method
    // এখানে একটা মেথেড উল্লেখ করা হয়েছে
    // আমি যেহেতু ডাইলোগে একটা বাটন রাখব সেহেতু আমি একটা মেথড রেখেছি
    void onOkClick(DialogInterface dialog, int which);
}
