package com.example.hp.com.yourvote;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.com.yourvote.Models.Login;
import com.example.hp.com.yourvote.Models.OneTimeAuth;
import com.example.hp.com.yourvote.Models.Users;
import com.example.hp.com.yourvote.Resources.OneTimeAuthResource;
import com.example.hp.com.yourvote.Resources.UserResource;
import com.example.hp.com.yourvote.Utils.RetrofitInst;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.hp.com.yourvote.Utils.RetrofitInst.retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class VoterAuthentication extends Fragment {

    Context mctx;
    EditText etDate;
    EditText etfillotp;
    DatePickerDialog.OnDateSetListener setListener;
    VoteCastingFragment voteCastingFragment = new VoteCastingFragment();

    public VoterAuthentication() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_voter_auth, container, false);
        Button submit = (Button) rootView.findViewById(R.id.submit_auth_btn);
        Button resend = (Button) rootView.findViewById(R.id.btn_resendotp);
        etfillotp = (EditText) rootView.findViewById(R.id.et_fillotp);
        sendOTP();
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOTP();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkOTP();

            }
        });
        mctx = container.getContext();



        return rootView;
    }

    private void checkOTP() {
        Retrofit r = RetrofitInst.getRetrofit();
        UserResource userResource = r.create(UserResource.class);
        Call<OneTimeAuth> c = userResource.getOTP(etfillotp.getText().toString());
        c.enqueue(new Callback<OneTimeAuth>() {
            @Override
            public void onResponse(Call<OneTimeAuth> call, Response<OneTimeAuth> response) {
                if (response.body() != null) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_bottom, voteCastingFragment).commit();
                }
            }

            @Override
            public void onFailure(Call<OneTimeAuth> call, Throwable t) {

            }
        });
    }

    private void sendOTP() {
        Retrofit r = RetrofitInst.getRetrofit();
        UserResource userResource = r.create(UserResource.class);

        Call<Users> c = userResource.getOTP(login.loggedInUser);

        c.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.body() != null) {
                    Toast.makeText(getContext(), "OTP sent Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                Log.d("OTP", "onFailure: " + t);
            }
        });


    }
}
