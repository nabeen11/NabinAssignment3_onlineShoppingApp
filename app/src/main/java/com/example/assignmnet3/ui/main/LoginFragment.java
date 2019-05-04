package com.example.assignmnet3.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.Toast;

import com.example.assignmnet3.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends Fragment {

    EditText username, password;
    Button login;

    SharedPreferences preferences;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static LoginFragment newInstance(int index) {
        LoginFragment fragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.login_fragment, container, false);

        username = root.findViewById(R.id.edt_username);
        password = root.findViewById(R.id.edt_pass);
        login = root.findViewById(R.id.btn_log);

        preferences = getActivity().getSharedPreferences("User",Context.MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = preferences.getString("regEmail","");
                String pass = preferences.getString("regPassword","");

                Log.d("val",user+pass);

                if(username.getText().toString().equals(user) && password.getText().toString().equals(pass) ){
                    Toast.makeText(getActivity(), "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), DashboardMain.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(getActivity(), "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }
}