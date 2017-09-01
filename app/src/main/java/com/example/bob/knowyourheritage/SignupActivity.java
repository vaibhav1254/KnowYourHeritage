package com.example.bob.knowyourheritage;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import android.widget.Toast;



public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    EditText nameet,numberet,emailet,passet,confpasset;
    Button signupbtn,resetbtn;
    private AwesomeValidation awesomeValidation;
    SharedPreferences preferences;
    TravellerDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        nameet = (EditText) findViewById(R.id.nameET);
        numberet = (EditText) findViewById(R.id.numberET);
        emailet = (EditText) findViewById(R.id.emailET);
        passet = (EditText) findViewById(R.id.passET);
        confpasset = (EditText) findViewById(R.id.confpassET);
        signupbtn = (Button) findViewById(R.id.signupBTN);
        resetbtn = (Button) findViewById(R.id.resetBTN);

        awesomeValidation.addValidation(SignupActivity.this, R.id.nameET, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(SignupActivity.this, R.id.emailET, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(SignupActivity.this, R.id.passET, "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$", R.string.passworderror);
        awesomeValidation.addValidation(SignupActivity.this, R.id.numberET, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);

        signupbtn.setOnClickListener(this);
        resetbtn.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", null).show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.resetBTN:
                resetALL();
                break;
            case R.id.signupBTN:
                submit();
                break;
        }


    }

    public void submit() {

        String name = nameet.getText().toString();
        String number = numberet.getText().toString();
        String email = emailet.getText().toString();
        String paset=passet.getText().toString();
        String repaset=confpasset.getText().toString();
        if(confpasset.getText().toString().length()==0)
        {
            confpasset.setError("password confirmation required");
        }
        if(name.length() < 5) {

            nameet.setError("Name not valid");

        }
        if(!paset.equals(repaset))
        {

            Toast.makeText(this, "Retype password empty or Password Mismatch", Toast.LENGTH_LONG).show();
        }


        dbHelper.addTraveller(new Traveller(name,number,email,paset,repaset));



        if(awesomeValidation.validate())
        {

            Toast.makeText(this,"Registration Succesful..redirecting",Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override

                public void run() {
                    Intent mainIntent = new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(mainIntent);
                    finish();

                }
            },2000);

        }
    }


    public void resetALL() {
        nameet.setText("");
        emailet.setText("");
        passet.setText("");
        confpasset.setText("");
        numberet.setText("");
    }
}

