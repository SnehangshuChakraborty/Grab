package com.example.grab;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {

    private TextView loginTextView;
    private FrameLayout parentFramelayout;
    private EditText registerEmailId;
    private EditText registerName;
    private EditText registerPassword;
    private EditText confirmPassword;
    private Button signUpButton;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        loginTextView = view.findViewById(R.id.login_textview);
        registerEmailId = view.findViewById(R.id.registerEmail);
        registerName = view.findViewById(R.id.registername);
        registerPassword = view.findViewById(R.id.registerpassword);
        confirmPassword = view.findViewById(R.id.confirmPassword);
        parentFramelayout = getActivity().findViewById(R.id.framelayout);
        signUpButton = view.findViewById(R.id.sign_up_button);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Validate Input from user
        registerEmailId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        registerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        registerPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // If Sign Up Button is clicked
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataToFirebase();
            }
        });

        // If the textview is clicked
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new SignInFragment());
            }
        });
    }

    private void checkInput() {
        if(!TextUtils.isEmpty(registerEmailId.getText())){
            if(!TextUtils.isEmpty(registerName.getText())){
                if(!TextUtils.isEmpty(registerPassword.getText()) && registerPassword.length() >=8){
                    if(!TextUtils.equals(registerPassword.getText(),confirmPassword.getText())){
                        signUpButton.setEnabled(true);
                    }else{
                        Toast.makeText(getActivity().getApplicationContext(), "Password Not Matched", Toast.LENGTH_SHORT).show();
                        signUpButton.setEnabled(false);
                    }
                }else{
                    signUpButton.setEnabled(false);
                }
            }else{
                signUpButton.setEnabled(false);
            }
        }else{
            signUpButton.setEnabled(false);
        }
    }

    private void sendDataToFirebase() {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getActivity().getApplicationContext() , "Details Submitted", duration);
        toast.show();
    }

    private void validateInputs() {

    }

    private void setFragment(Fragment signInFragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFramelayout.getId(),signInFragment);
        fragmentTransaction.commit();
    }
}
