package com.bacter.bactercompass;

import android.hardware.camera2.CameraManager;
import android.os.Build;
import androidx.annotation.RequiresApi;

public class Strobe implements Runnable {
    boolean check;
    String CamId;
    CameraManager camera;
   // private boolean isCheck= false;
    int fr=0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void run()
    {
        while (!check)
        {
            try {
                camera.setTorchMode (CamId,true);
                Thread.sleep (500-fr);
                camera.setTorchMode (CamId,false);
                Thread.sleep (500-fr);
            } catch (Exception e){
                e.printStackTrace ();
            }
        }
    }
}
