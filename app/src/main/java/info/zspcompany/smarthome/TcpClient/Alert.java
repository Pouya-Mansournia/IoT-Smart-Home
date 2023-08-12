package info.zspcompany.smarthome.TcpClient;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;

import info.zspcompany.smarthome.fragment.livingroomFragment;

public class Alert {

    private static Context context=null;

    /**
     * Init void.
     *
     * @param context the context
     */
    public static void init(livingroomFragment context){

    }

    /**
     * Info void.
     *
     * @param msg the msg
     * @param callback the callback
     */
    public static void info(String Title, String msg, OnClickListener callback){
        Builder alertDialogBuilder = new Builder(context);
        alertDialogBuilder
                .setTitle(Title)
                .setMessage(msg)
                .setPositiveButton("Ok",null);

        alertDialogBuilder.show();
    }

    /**
     * Show progress.
     *
     * @param msg the msg
     * @return the alert dialog
     */
    public static ProgressDialog showProgress(String msg){
        return ProgressDialog.show(context,
                msg, null, true, true);
    }



}
