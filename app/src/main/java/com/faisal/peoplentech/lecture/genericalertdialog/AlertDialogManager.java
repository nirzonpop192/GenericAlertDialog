package com.faisal.peoplentech.lecture.genericalertdialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import java.lang.ref.WeakReference;

public class AlertDialogManager {
    /**
     * class variable
     */
    private static AlertDialogManager manager = null;

    private AlertDialog.Builder mBuilder = null;

    private Context context;

    /**
     * Default Constructor
     */
    private AlertDialogManager() {
        // nothing to do here
    }
    private AlertDialogManager(Context context) {
        // nothing to do here
        this.context=context;
    }

    public static AlertDialogManager getInstance() {
        if (manager == null)
            manager = new AlertDialogManager();
        return manager;
    }

    public static AlertDialogManager getInstance(Context context) {
        if (manager == null)
            manager = new AlertDialogManager(context);
        return manager;
    }
    public void showCallDialog(Context context, DoubleDialogClickListener clickListener) {
        showSimple_2_AlertDialog(context, "Call", "Your Answer did n't match. please contract call center", R.drawable.ic_call, clickListener);
    }

    public void showInfoDialog(Context context, String msg, SingleDialogsClickListener clickListener) {
        showSimple_1_AlertDialog(context, "", msg, R.drawable.ic_info, clickListener);
    }
    public void showInfoDialog( String msg, SingleDialogsClickListener clickListener) {
        showSimple_1_AlertDialog(this.context, "", msg, R.drawable.ic_info, clickListener);
    }

    /**
     * @param context       কোন activity call করল সেটার context কারন system এর কাছ থেকে resource এর access চাই
     * @param title         Dialog এর title
     * @param msg           Dialog এর message
     * @param iconResId     Dialog এর icon
     * @param clickListener Dialog এর Click Listener Interface
     */
    private void showSimple_1_AlertDialog(Context context, String title, String msg, int iconResId, SingleDialogsClickListener clickListener) {

        final WeakReference<SingleDialogsClickListener> ref = new WeakReference<SingleDialogsClickListener>(clickListener);

        createBuilder(context, title, msg, iconResId);

        mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ref.get().onOkClick(dialog, which);
            }
        });

        mBuilder.show();
    }

    /**
     * @param context       কোন activity call করল সেটার context কারন system এর কাছ থেকে resource এর access চাই
     * @param title         Dialog এর title
     * @param msg           Dialog এর message
     * @param iconResId     Dialog এর icon
     * @param clickListener Dialog এর Click Listener Interface
     */
    private void showSimple_2_AlertDialog(Context context, String title, String msg, int iconResId, DoubleDialogClickListener clickListener) {

        final WeakReference<DoubleDialogClickListener> ref = new WeakReference<DoubleDialogClickListener>(clickListener);
        createBuilder(context, title, msg, iconResId);

        mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ref.get().onOkClick(dialog, which);
            }
        });
        mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ref.get().onCancelClick(dialogInterface, i);
            }
        });

        mBuilder.show();
    }

    private void createBuilder(Context context, String title, String msg, int iconResId) {

//        if (mBuilder.getContext() == null) {
//            Log.e("Log", "Dialog is null");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                mBuilder = new AlertDialog.Builder(context, R.style.AlertDialogTheme);
            else
                mBuilder = new AlertDialog.Builder(context);
//        }
        mBuilder.setTitle(title);
        mBuilder.setCancelable(false);
        mBuilder.setMessage(msg);
        mBuilder.setIcon(iconResId);
    }
}