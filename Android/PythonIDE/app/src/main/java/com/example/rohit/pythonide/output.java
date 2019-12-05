package com.example.rohit.pythonide;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class output extends Fragment {
    static String fOutput;
    private TextView output;


    public output() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_output, container, false);
        output = (TextView)view.findViewById(R.id.txtResult);
        output.setText(fOutput);
        return view;
    }

}
