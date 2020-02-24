package com.example.hp.com.yourvote;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.com.yourvote.Models.Users;
import com.example.hp.com.yourvote.Resources.UserResource;
import com.example.hp.com.yourvote.Utils.RetrofitInst;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class signup extends AppCompatActivity {


    private static final String TAG="signup";
    private  EditText etDate;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
         etDate=(EditText)findViewById(R.id.etBirthdate);
        btnSignUp =(Button) findViewById(R.id.btn_signup);
        Toast.makeText(this, "ahsdfhagf", Toast.LENGTH_SHORT).show();



        final EditText etFirstName= (EditText)findViewById(R.id.et_first_name);
        final EditText etLastName= (EditText)findViewById(R.id.et_last_name);
        final EditText etEmail= (EditText)findViewById(R.id.et_email);
        final EditText etBirthdate= (EditText)findViewById(R.id.etBirthdate);
        final EditText etmobileNumber= (EditText)findViewById(R.id.et_phone_number);
        final EditText etAadharnumber= (EditText)findViewById(R.id.et_aadhar_number);
        final EditText etVoterId= (EditText)findViewById(R.id.et_voter_number);
        final EditText etPassword= (EditText)findViewById(R.id.et_password);




        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit r = RetrofitInst.getRetrofit();
                UserResource userResource = r.create(UserResource.class);
                Users users = new Users();

                users.setFirstName(etFirstName.getText().toString());
                users.setLastName(etLastName.getText().toString());
                users.setEmail(etEmail.getText().toString());
                users.setBirthdate(etBirthdate.getText().toString());
                users.setMobileNumber(etmobileNumber.getText().toString());
                users.setAadharNumber(etAadharnumber.getText().toString());
                users.setVoterId(etVoterId.getText().toString());
                users.setPassword(etPassword.getText().toString());

                Call<Users> c = userResource.register(users);
                c.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        Users afterCall = response.body();
                        if(afterCall != null) {
                            if(afterCall.getAadharNumber().equals("Not found")) {
                                Toast.makeText(signup.this, "Failed", Toast.LENGTH_SHORT).show();
                            } else if(afterCall.getAadharNumber().equals("Already registered")) {
                                Toast.makeText(signup.this, "Already registered", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent i = new Intent(getApplicationContext(), HomePage.class);
                                startActivity(i);
                                Toast.makeText(signup.this, "Successfully registered", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(signup.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {

                    }
                });
            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(signup.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                String date=month + "/" + day + "/" + year;
                etDate.setText(date);
            }
        };
    }
}
