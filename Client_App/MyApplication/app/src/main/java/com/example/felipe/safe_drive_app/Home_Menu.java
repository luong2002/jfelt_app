package com.example.felipe.safe_drive_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class Home_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__menu);
    }

    public void openRequestRide( View view ){
        Intent requestIntent = new Intent( this, RequestRide.class );
        startActivity( requestIntent );
    }

    public void openCancelRide( View view ){
        Intent cancelIntent = new Intent( this, CancelRide.class );
        startActivity( cancelIntent );
    }
    public void openRegisterDriver( View view ){
        Intent registerIntent = new Intent( this, RegisterDriver.class );
        startActivity(registerIntent);
    }

    public void openAboutPage( View view ){
        Intent aboutIntent = new Intent( this, AboutUs.class );
        startActivity( aboutIntent );
    }

    public void gotoFormfill( View view ){
        Intent testIntent = new Intent( this, Form_Fill.class );
        startActivity( testIntent );
    }
}
