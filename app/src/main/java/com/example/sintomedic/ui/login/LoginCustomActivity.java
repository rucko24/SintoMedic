package com.example.sintomedic.ui.login;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sintomedic.R;

public class LoginCustomActivity extends AppCompatActivity {

    // UI references.
    private LoginViewModel loginViewModel;
    private ImageView mLogoView;

    private EditText userEditText;
    private EditText passwordEditText;

    private CheckBox checkBoxEditText;
    private TextInputLayout mFloatLabelUserId;
    private TextInputLayout mFloatLabelPassword;
    private Button registerPacienteButton;
    private Button registerDoctorButton;
    private  Button loginButton;
    private ProgressBar loadingProgressBar;
    private View mProgressView;
    private View mLoginFormView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);
        mLogoView=findViewById(R.id.logo_sintomedic);

        userEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);

        checkBoxEditText = findViewById(R.id.checkBox);
        loginButton = findViewById(R.id.button_login);
        registerPacienteButton = findViewById(R.id.regPacienteButton);
        registerDoctorButton = findViewById(R.id.regDoctorButton);
        loadingProgressBar = findViewById(R.id.loading);

        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.button_login || id == EditorInfo.IME_NULL) {
                    userLogin();
                    return true;
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });






    }//FIN ON CREATE
    public  void userLogin(){
        String usuario=userEditText.getText().toString().trim();
        String pass=passwordEditText.getText().toString().trim();

        //VALIDACIONES





    }
   /* @Override
    public  void onClick(View view){
        switch (view.getId()){
            case R.id.button_login:
                userLogin();
                break;
            case R.id.button_registro_doctor:
                break;
            case R.id.button_registro_paciente:
                break;
        }

    }*/



}
