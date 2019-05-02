package com.example.p03_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class third_activity extends AppCompatActivity {

    RadioGroup rg;
    Button submit;
    TextView week1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_activity);

        Intent i = getIntent();
        String week = i.getStringExtra("weekVal");

        week1.setText("Week " + week);



        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg = findViewById(R.id.rg);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                //Get the radio button object from the Id we had gotten above
                RadioButton rb = findViewById(selectedButtonId);
                //Show a Toast that display the tex on the selected radio button
                String grade = rb.getText().toString();

                Intent i = new Intent();
                i.putExtra("grade",grade);
                setResult(RESULT_OK, i);
                finish();
            }
        });


    }
}
