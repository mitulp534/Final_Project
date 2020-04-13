package com.example.hp.com.yourvote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.hp.com.yourvote.Models.Login;
import com.example.hp.com.yourvote.Models.Users;
import com.example.hp.com.yourvote.Models.Vote;
import com.example.hp.com.yourvote.Resources.VotingResource;
import com.example.hp.com.yourvote.Utils.RetrofitInst;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class VoteCastingFragment extends Fragment {

    CheckBox btnBjp;
    CheckBox btnCon;
    CheckBox btnBsp;
    CheckBox btnAap;
    private static String party = "";


VoteFinished voteFinished = new VoteFinished();
    public VoteCastingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_vote_casting, container, false);

        Button castVote=(Button)rootView.findViewById(R.id.btn_vote_cast);
        btnBjp=(CheckBox)rootView.findViewById(R.id.checkbox_bjp);
        btnCon=(CheckBox)rootView.findViewById(R.id.checkbox_con);
        btnBsp=(CheckBox)rootView.findViewById(R.id.checkbox_bsp);
        btnAap=(CheckBox)rootView.findViewById(R.id.checkbox_aap);

        btnBjp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnBjp.isChecked()) {
                    btnCon.setChecked(false);
                    btnBsp.setChecked(false);
                    btnAap.setChecked(false);
                    party = btnBjp.getText().toString();
                }
            }
        });
        btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnCon.isChecked()) {
                    btnBjp.setChecked(false);
                    btnBsp.setChecked(false);
                    btnAap.setChecked(false);
                    party = btnCon.getText().toString();
                }
            }
        });

        btnBsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnBsp.isChecked()) {
                    btnBjp.setChecked(false);
                    btnCon.setChecked(false);
                    btnAap.setChecked(false);
                    party = btnBsp.getText().toString();
                }
            }
        });
        btnAap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAap.isChecked()) {
                    btnBjp.setChecked(false);
                    btnCon.setChecked(false);
                    btnBsp.setChecked(false);
                    party = btnAap.getText().toString();
                }
            }
        });

        castVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("party", "onClick: " + party);
                if(!party.equals("")) {
                    Log.d("party", "onClick: inside");
                    Retrofit r = RetrofitInst.getRetrofit();
                    VotingResource votingResource = r.create(VotingResource.class);
                    Vote vote = new Vote();
                    vote.setCandidate("asd");
                    vote.setParty(party);
                    vote.setVoter(login.loggedInUser.getAadharNumber());
                    Call<Vote> c = votingResource.castVote(vote);
                    c.enqueue(new Callback<Vote>() {
                        @Override
                        public void onResponse(Call<Vote> call, Response<Vote> response) {
                            if(response.body() != null) {
                                Toast.makeText(getContext(), "Vote successful", Toast.LENGTH_SHORT).show();
                                //screen change
                                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_bottom,voteFinished).addToBackStack(null).commit();
                            } else {
                                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Vote> call, Throwable t) {
                            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                            Log.d("vote", "onFailure: " + t);
                        }
                    });

                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Select a party", Toast.LENGTH_SHORT).show();
                }

            }
        });



        return rootView;
    }
}
