package com.example.hp.com.yourvote;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Search extends Fragment {

    //defining
    SearchView searchView ;
    ListView searchList;

    //for adapter
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    private Context context;

    public Search() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search,container,false);

        //casting
        searchView =  (SearchView)rootView.findViewById(R.id.searchView);
        searchList = (ListView)rootView.findViewById(R.id.searchList);

        list=new ArrayList<>();
        list.add("Bahujan Samaj Party");
        list.add("Bharatiya Janata Party");
        list.add("Indian National Congress");
        list.add("Communist Party of India");
        list.add("Aam Aadmi Party");
        list.add("Janata Dal United");

        adapter=new ArrayAdapter<>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,list);
        searchList.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });


        return rootView;
    }

}
