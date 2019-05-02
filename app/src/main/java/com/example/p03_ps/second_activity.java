package com.example.p03_ps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class second_activity extends AppCompatActivity {

    int requestCodeC347 = 347;

    Button btnInfo, btnAdd, btnEmail;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<DailyCA> al;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        lv = findViewById(R.id.lvDg);



        al = new ArrayList<DailyCA>();
        al.add(new DailyCA("A", "B", 1));
        al.add(new DailyCA("B", "C", 2));
        al.add(new DailyCA("C", "A", 3));

        aa = new CAAdapter(this, R.layout.dgrow, al);
        lv.setAdapter(aa);

        int whichWeek = al.size();
        int weekWhat = whichWeek + 1;
        String weekString = Integer.toString(weekWhat);


        for (int i = 0; i < al.size(); i++) {
            message = "Week " + " : DG: " + "\n";
        }

        btnInfo = findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }


        });

        btnEmail = findViewById(R.id.email);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT,
                        "q");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });

        btnAdd = findViewById(R.id.add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i = new Intent(second_activity.this, third_activity.class);
                i.putExtra("weekVal", weekString);
                startActivityForResult(i,requestCodeC347);

            }
        });

        }
    @Override
    protected void onActivityResult(int requestCode, int 				resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 2nd activity
                String grade = data.getStringExtra("grade");
                String statement = "";
                // If it is activity started by clicking 				//  Superman, create corresponding String
                if(requestCode == requestCodeC347){
                    al.add(new DailyCA(grade, "C347", weekString));
                }
        }
    }



}
}
