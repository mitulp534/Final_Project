package com.example.hp.com.yourvote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class Vote extends Fragment {
    VoterAuthentication objAuthh = new VoterAuthentication();
    TutorialFragment tutorialFragment = new TutorialFragment();
    Button btn;
    public Vote() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_vote, container, false);
        Button registerNow = (Button)rootView.findViewById(R.id.register_now);
        registerNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_bottom,objAuthh).addToBackStack(null).commit();
            }
        });

        Button startTutorial=(Button)rootView.findViewById(R.id.btn_tutorial);
        startTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_bottom,tutorialFragment).addToBackStack(null).commit();
            }
        });
        return rootView;
    }

}
