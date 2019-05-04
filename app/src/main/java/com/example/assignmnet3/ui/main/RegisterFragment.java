package com.example.assignmnet3.ui.main;


import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignmnet3.R;



public class RegisterFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_SECTION_NUMBER2 = "section_number2";

    EditText name,email,password  ;
    Button  register;
    SharedPreferences preferences;

    private String getArgSectionNumber;
    private String getArgSectionNumber2;

    private OnFragmentInteractionListner mylistner;

    public RegisterFragment(){
        //Req empty public Constructor
    }


    public static RegisterFragment newInstance(String section_number, String section_number2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_NUMBER, section_number);
        args.putString(ARG_SECTION_NUMBER2, section_number2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            getArgSectionNumber = getArguments().getString(ARG_SECTION_NUMBER);
            getArgSectionNumber2 = getArguments().getString(ARG_SECTION_NUMBER2);
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.register_fragment, container, false);

            name = root.findViewById(R.id.regName);
            email = root.findViewById(R.id.regEmail);
            password = root.findViewById(R.id.regPass);


            register = root.findViewById(R.id.btnSignUP);
            register.setOnClickListener(this);

        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mylistner != null) {
            mylistner.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListner) {
            mylistner = (OnFragmentInteractionListner) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mylistner = null;
    }

    @Override
    public void onClick(View v) {

        signUp();
    }

    private void signUp(){
        preferences= getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = preferences.edit();
        mEditor.putString("regName", name.getText().toString());
        mEditor.putString("regEmail", email.getText().toString());
        mEditor.putString("regPassword", password.getText().toString());

        mEditor.commit();

        Toast.makeText(getActivity(),"REGISTRATION SUCCESSFUL", Toast.LENGTH_SHORT).show();
    }
    public interface OnFragmentInteractionListner {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
