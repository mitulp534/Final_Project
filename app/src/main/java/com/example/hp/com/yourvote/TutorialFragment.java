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
public class TutorialFragment extends Fragment {

    TutorialScreen1Fragment screen1 = new TutorialScreen1Fragment();

    public TutorialFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tutorial, container, false);

            Button nextButton = (Button)rootView.findViewById(R.id.btn_watch_screenshot);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_bottom,screen1).addToBackStack(null).commit();
                }
            });

        return rootView;
    }

}
