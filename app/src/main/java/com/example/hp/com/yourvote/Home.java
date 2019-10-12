package com.example.hp.com.yourvote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment  {


    NewsAdapter adapter;
    List<News> newsList = new ArrayList<>();

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);
        TextView tv = rootView.findViewById(R.id.news_title);
        Log.d(TAG, "onCreateView: " + tv);
        RecyclerView recyclerView= rootView.findViewById(R.id.recycler_view_news);
        Log.d(TAG, "onCreateView: " + recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        newsList.add(
                new News(
                        1,
                        "Not Concerned By Interference in US Election, Trump Told Russians In 2017",
                        "President Donald Trump told two senior Russian officials in a 2017 Oval Office meeting that he was unconcerned about Moscow's interference in the U.S. election because the United States did the same in other countries, an assertion that prompted alarmed White House officials to limit access to the remarks to an unusually small number of people, according to three former officials with knowledge of the matter.",
                        R.drawable.news_image1)
        );
        newsList.add(
                new News(
                        2,
                        "WhatsApp Was Extensively Abused During India Elections, Study Claims",
                        "Despite WhatsApp's efforts to reduce the spread of fake news by limiting the number of forwards to five, the platform was extensively abused to spread unfounded rumours and create misinformation campaigns during recent elections in India and Brazil, a study has revealed.",
                        R.drawable.news_image_2)
        );

        newsList.add(
                new News(
                        3,
                        "Congress announces candidates for by-elections",
                        "The Congress on Saturday announced the names of candidates for the upcoming Assembly by-elections in Assam, Puducherry and Chhattisgarh",
                        R.drawable.news_image_3)
        );

        newsList.add(
                new News(
                        4,
                        "Maharashtra Assembly Elections 2019: Date, full schedule, results, all you need to know",
                        "The Election Commission announced the dates for the Maharashtra Assembly Elections today. The state will go to polls on October 21st while the result is scheduled to be out on October 24th.",
                        R.drawable.news_image_4)

        );

        adapter = new NewsAdapter( getActivity().getApplicationContext(),newsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

}
