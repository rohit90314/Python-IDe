package com.example.rohit.pythonide;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    private EditText edtInput;
    private Button setInput;
    static String input;

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        edtInput = (EditText)view.findViewById(R.id.editInput);
        setInput = (Button)view.findViewById(R.id.setInput);

        setInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = edtInput.getText().toString();
            }
        });

        return view;
    }

}
