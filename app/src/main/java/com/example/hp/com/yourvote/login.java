package com.example.hp.com.yourvote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.com.yourvote.Models.Users;
import com.example.hp.com.yourvote.Resources.UserResource;
import com.example.hp.com.yourvote.Utils.RetrofitInst;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_login);


        Button btnLogin = (Button) findViewById(R.id.btn_login);
        final EditText etUsername = (EditText) findViewById(R.id.et_username);
        final EditText etPassword= (EditText) findViewById(R.id.et_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit r = RetrofitInst.getRetrofit();
                UserResource userResource = r.create(UserResource.class);

                Call<Users> c = userResource.authenticate(Integer.parseInt(etUsername.getText().toString()),etPassword.getText().toString());

                c.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        Users u = response.body();
                       if(u!=null) {
                           if(etUsername.getText().toString().equals(u.getEmail().toString()) && etPassword.getText().toString().equals(u.getPassword())) {
                               Toast.makeText(login.this, "Success", Toast.LENGTH_SHORT).show();
                           }
                       } else {
                           Toast.makeText(login.this, "Failed", Toast.LENGTH_SHORT).show();
                       }
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {

                    }
                });
            }
        });

        final TextView noAccount=(TextView)findViewById(R.id.tv_no_account);

        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,signup.class);
                startActivity(intent);
            }
        });

        final TextView forgotPassword = (TextView)findViewById(R.id.forgot_password_id);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,ForgotPassword.class);
                startActivity(intent);
            }
        });

    }
}
