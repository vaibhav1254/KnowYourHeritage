package com.example.bob.knowyourheritage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText passEt,userEt;
    Button loginBtn;
    TextView clickTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        passEt = (EditText) findViewById(R.id.passet);
        userEt = (EditText) findViewById(R.id.useret);
        loginBtn = (Button) findViewById(R.id.loginbtn);
        clickTv = (TextView) findViewById(R.id.clicktv);

        loginBtn.setOnClickListener(this);
        clickTv.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(R.drawable.exit_dialog).setTitle("Exit")
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

            case R.id.loginbtn:
                submit();
                break;
            case R.id.clicktv:
                redirect();
                break;
        }
    }

    public void submit() {

            Intent intent = new Intent(LoginActivity.this,DrawerActivity.class);
            startActivity(intent);
            finish();

    }

    public void redirect() {
        Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
        startActivity(intent);
        finish();
    }
}