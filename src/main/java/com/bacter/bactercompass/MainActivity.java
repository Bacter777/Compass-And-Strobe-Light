package com.bacter.bactercompass;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txtMarquee;
    private Activity mActivity;
    private ImageButton CompassBtn;
    private ImageButton strobeBtn;
    //private Button AccBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        txtMarquee= findViewById (R.id.dev);
        txtMarquee.setSelected (true);

        Context mContext = getApplicationContext ();
        mActivity = MainActivity.this;


        //onClick strobe button
        strobeBtn = findViewById (R.id.strobeButton);
        strobeBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v){
                moveToStrobe();
            }
        });
        // onClick compass button
        CompassBtn =findViewById(R.id.compassButton);
        CompassBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                moveToCompass();
            }
        });
    }
    // move to compass activity
    public void moveToCompass(){
        Intent intent = new Intent(this,CompassActivity.class);
        startActivity (intent);
    }
    // move to strobe activity
    public void moveToStrobe() {
        Intent intent = new Intent(this,StrobeActivity.class);
        startActivity (intent);
    }
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder (mActivity);
        builder.setTitle ("Confirm Exit?");
        //builder.setMessage ("Are You sure You Want To Exit?");
        builder.setCancelable (false);
        builder.setPositiveButton ("Yes",new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog,int id) {
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton ("No",new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog,int id) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
