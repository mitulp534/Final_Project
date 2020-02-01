package com.example.hp.com.yourvote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


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

        castVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_bottom,voteFinished).addToBackStack(null).commit();
            }
        });



        return rootView;
    }

}