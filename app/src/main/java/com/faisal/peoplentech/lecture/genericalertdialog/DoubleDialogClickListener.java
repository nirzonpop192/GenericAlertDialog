package com.faisal.peoplentech.lecture.genericalertdialog;

import android.content.DialogInterface;

// this is Custom interface
// এটা আমার তৈরি একটা ইন্টারফেইজ
public interface DoubleDialogClickListener {
    // declaration of a method
    // এখানে একটা মেথেড উল্লেখ করা হয়েছে
    // আমি যেহেতু ডাইলোগে দুইটি বাটন রাখব সেহেতু আমি দুইটি মেথড রেখেছি
    // OK Button এর জন্য click করার মেথড
    void onOkClick(DialogInterface dialog, int which);

    // Cancel Button এর জন্য click করার মেথড
    void onCancelClick(DialogInterface dialog,int which);
}
