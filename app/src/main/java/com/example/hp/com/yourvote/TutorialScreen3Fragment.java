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
public class TutorialScreen3Fragment extends Fragment {

    TutorialScreen4Fragment screen4 = new TutorialScreen4Fragment();
    public TutorialScreen3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_tutorial_screen3, container, false);
        Button nextButton = (Button)rootView.findViewById(R.id.screenshotButton3);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_bottom,screen4).addToBackStack(null).commit();
            }
        });
        return rootView;
    }

}
