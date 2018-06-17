package com.irozon.sneakersample;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.irozon.sneaker.Sneaker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btShowError;
    Button btShowSuccess;
    Button btShowWarning;
    Button btToggleStatusBar;

    boolean isStatusBarVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btShowError = (Button) findViewById(R.id.btShowError);
        btShowSuccess = (Button) findViewById(R.id.btShowSuccess);
        btShowWarning = (Button) findViewById(R.id.btShowWarning);
        btToggleStatusBar = (Button) findViewById(R.id.btToggleStatusBar);

        btShowError.setOnClickListener(this);
        btShowSuccess.setOnClickListener(this);
        btShowWarning.setOnClickListener(this);
        btToggleStatusBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btShowError:
                Sneaker.with(this)
                       .setTitle("Error!!")
                       .setMessage("This is the error message")
                       .setTypeface(Typeface.createFromAsset(this.getAssets(), "font/" + "Slabo27px-Regular.ttf"))
                       .sneakError();
                break;
            case R.id.btShowSuccess:
                Sneaker.with(this)
                       .setTitle("Success!!")
                       .setMessage("This is the success message")
                       .setCornerRadius(5, 7)
                       .sneakSuccess();
                break;
            case R.id.btShowWarning:
                Sneaker.with(this)
                       .setTitle("Warning!!")
                       .setMessage("This is the warning message")
                       .sneakWarning();
                break;
            case R.id.btToggleStatusBar:
                Window w = getWindow();
                if (isStatusBarVisible) {
                    w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
                    w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                    isStatusBarVisible = false;
                } else {
                    w.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
                    w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                    isStatusBarVisible = true;
                }

                break;
        }
    }
}