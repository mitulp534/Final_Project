package com.example.hp.com.yourvote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class VoteCastingFragment extends Fragment {

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
        CheckBox btnBjp=(CheckBox)rootView.findViewById(R.id.checkbox_bjp);
        CheckBox btnCon=(CheckBox)rootView.findViewById(R.id.checkbox_con);
        CheckBox btnBsp=(CheckBox)rootView.findViewById(R.id.checkbox_bsp);
        CheckBox btnAap=(CheckBox)rootView.findViewById(R.id.checkbox_aap);

        btnBjp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getActivity().getApplicationContext(),"Bhartiya Janata Party",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
            }
        });
        btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getActivity().getApplicationContext(),"Indian National Congress",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
            }
        });

        btnBsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getActivity().getApplicationContext(),"Bahujan Samajvadi Party",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
            }
        });
        btnAap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getActivity().getApplicationContext(),"Aam aadmi party",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
            }
        });

        castVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_bottom,voteFinished).addToBackStack(null).commit();
            }
        });



        return rootView;
    }

}
