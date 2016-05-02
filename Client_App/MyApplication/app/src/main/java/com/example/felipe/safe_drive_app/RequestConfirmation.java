package com.example.felipe.safe_drive_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RequestConfirmation extends AppCompatActivity {

    Client client = new Client();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_confirmation);

        Intent intent = getIntent();

        String message = "Not Answered";

        client.firstName = intent.getStringExtra(RequestRide.EXTRA_FIRSTNAME);
        client.lastName = intent.getStringExtra(RequestRide.EXTRA_LASTNAME);
        client.idNumber = intent.getStringExtra(RequestRide.EXTRA_IDNUMBER);
        client.pickupAddress = intent.getStringExtra(RequestRide.EXTRA_PICKADD);
        client.dropoffAddress = intent.getStringExtra(RequestRide.EXTRA_DROPADD);
        client.otherComments = intent.getStringExtra(RequestRide.EXTRA_COMMENT);
        client.hasID = intent.getBooleanExtra(RequestRide.EXTRA_HASID, false);
        client.pickWithin10 = intent.getBooleanExtra(RequestRide.EXTRA_PICKWITHIN, false);
        client.dropWithin10 = intent.getBooleanExtra(RequestRide.EXTRA_DROPWITHIN, false);
        client.groupSize = intent.getBooleanExtra(RequestRide.EXTRA_GROUPSIZE, false);

        TextView firstName = (TextView) findViewById(R.id.confirm_first_name_output);
        if(client.firstName != null)
            firstName.setText(client.firstName);

        TextView lastName = (TextView) findViewById(R.id.confirm_last_name_output);
        if(client.lastName != null)
            lastName.setText(client.lastName);

        TextView idNumber = (TextView) findViewById(R.id.confirm_id_number_output);
        if(client.idNumber != null)
            idNumber.setText(client.idNumber);

        TextView pickAdd = (TextView) findViewById(R.id.confirm_pickup_address_output);
        if(client.pickupAddress != null)
            pickAdd.setText(client.pickupAddress);

        TextView dropAdd = (TextView) findViewById(R.id.confirm_dropoff_address_output);
        if(client.dropoffAddress != null)
            dropAdd.setText(client.dropoffAddress);

        TextView textComments = (TextView) findViewById(R.id.confirm_other_comments_output);
        if(client.otherComments != null)
            textComments.setText(client.otherComments);

        String yesMessage = "Yes";
        String noMessage = "No";

        TextView questAns1 = (TextView) findViewById(R.id.confirm_answer_1);
        if( client.hasID )
            questAns1.setText(yesMessage);
        else
            questAns1.setText(noMessage);

        TextView questAns2 = (TextView) findViewById(R.id.confirm_answer_2);
        if( client.hasID )
            questAns2.setText(yesMessage);
        else
            questAns2.setText(noMessage);

        TextView questAns3 = (TextView) findViewById(R.id.confirm_answer_3);
        if( client.hasID )
            questAns3.setText(yesMessage);
        else
            questAns3.setText(noMessage);

        TextView questAns4 = (TextView) findViewById(R.id.confirm_answer_4);
        if( client.hasID )
            questAns4.setText(yesMessage);
        else
            questAns4.setText(noMessage);



    }
}
