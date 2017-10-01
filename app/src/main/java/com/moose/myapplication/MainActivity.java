package com.moose.myapplication;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView view= (TextView) findViewById(R.id.textView);

        String text="";

        //Determine screen size
        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            text="LargeScreen";
        }
        else if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
            text="MediumScreen";
        }
        else if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL) {
            text="SmallScreen";
        }
        else {
            text="None";
        }



        //Determine density
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float density = metrics.density;
        float dpWidth=metrics.widthPixels/density;
        float dpHeight=metrics.heightPixels/density;

        text=text + " with density of "+metrics.densityDpi+ " which is a multiplier of "+density+", width of "+dpWidth+"dp, height of "+dpHeight+"dp";

        view.setText(text);
    }
}
