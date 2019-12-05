package com.example.rohit.pythonide;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class program extends Fragment {


    private EditText editProgram,editInput;
    private TextView txtResult;
    private Button btnExecute;
    private IMyService iMyService;
    FragmentTransaction fragmentTransaction;


    public program() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_program, container, false);
        btnExecute = (Button)view.findViewById(R.id.btnExecute);
        editProgram = (EditText)view.findViewById(R.id.editProgram);

        btnExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = RetrofitClient.getInstance();
                iMyService = retrofit.create(IMyService.class);
                String program = editProgram.getText().toString();
                final Call<MessageResult> sendProgram =iMyService.sendProgram(program,InputFragment.input);
                sendProgram.enqueue(new Callback<MessageResult>() {
                    @Override
                    public void onResponse(Call<MessageResult> call, Response<MessageResult> response) {
                        Log.d("Call", "onResponse: "+response.body().getMessage());
                        //txtResult.setText(response.body().getMessage());
                        output.fOutput = response.body().getMessage();
                        Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<MessageResult> call, Throwable t) {
                        Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
                        //output.fOutput = response.body().getMessage();
                    }
                });

                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.program,new output());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



        return view;
    }

}
