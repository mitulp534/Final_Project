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
public class TutorialScreen1Fragment extends Fragment {

    TutorialScreen2Fragment screen2 = new TutorialScreen2Fragment();
    public TutorialScreen1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview =inflater.inflate(R.layout.fragment_tutorial_screen1, container, false);
        Button nextButton = (Button)rootview.findViewById(R.id.screenshotButton1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_bottom,screen2).addToBackStack(null).commit();
            }
        });
        return rootview;
    }

}
