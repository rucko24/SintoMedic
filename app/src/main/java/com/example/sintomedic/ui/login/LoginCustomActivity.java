package com.example.sintomedic.ui.login;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sintomedic.DoctorRegisterActivity;
import com.example.sintomedic.PacienteRegisterActivity;
import com.example.sintomedic.R;

public class LoginCustomActivity extends AppCompatActivity implements AsyncResponse {

    //MyAsyncTask asyncTask =new MyAsyncTask();
    private LoginViewModel loginViewModel;
    /**
     * Credenciales de pruebas BORRAR!!!!!!!! TRAS PRUEBAS!!!!
     * TO DO: borrar cuando vayas a implementar una autenticación real.
     */
    private static final String DUMMY_USER_ID = "0000000000";
    private static final String DUMMY_PASSWORD = "dummy_password";

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    //private UserLoginTask mAuthTask = null;

    // UI references.
    private ImageView mLogoView;

    private EditText usernameEditText;
    private EditText passwordEditText;

    private CheckBox checkBoxEditText;
    private TextInputLayout mFloatLabelUserId;
    private TextInputLayout mFloatLabelPassword;
    private Button registerPacienteButton;
    private Button registerDoctorButton;
    private Button loginButton;
    private ProgressBar loadingProgressBar;
    private View mProgressView;
    private View mLoginFormView;

    //STRING TIPOS USUARIO
    private String USER_TYPE_1 = "paciente";
    private String USER_TYPE_2 = "doctor";

    // para los intent:

    public static final String EXTRA_MESSAGE = "intentPaciente";

    public static final int TXT_REQ2 = 2;
    private static final int TXT_REQ3 = 3;
    private boolean show;
    private UserLoginTask mAuthTask;
    private Boolean es_doctor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);
        mLogoView = findViewById(R.id.logo_sintomedic);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);

        checkBoxEditText = findViewById(R.id.checkBox);
        loginButton = findViewById(R.id.button_login);
        registerPacienteButton = findViewById(R.id.regPacienteButton);
        registerDoctorButton = findViewById(R.id.regDoctorButton);
        loadingProgressBar = findViewById(R.id.loading);


        //Ahora estableceremos las escuchas para el evento de edición en el campo de texto del
        // password y el click en el botón de login:
        // Setup
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.button_login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        //este boton hace login pero debe primero verificar
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //attemptLogin();
            }
        });


        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }

            private void updateUiWithUser(LoggedInUserView model) {
                String welcome = getString(R.string.welcome) + model.getDisplayName();
                // TODO : initiate successful logged in experience
                String user=null;
                View view = null;
                // IR A LA ACTIVIDAD Y DECIDIR SEGUN USER
                //goToLoginActivity(view);
                Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
            }

            private void showLoginFailed(Integer error) {
            }
        });



        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        //listener del registro del doctor
        registerDoctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                final Intent intent = new Intent(LoginCustomActivity.this, DoctorRegisterActivity.class);
                LoginCustomActivity.this.startActivity(intent);
            }
        });

        //listener del registro del paciente
        registerPacienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                final Intent intent = new Intent(LoginCustomActivity.this, PacienteRegisterActivity.class);
                LoginCustomActivity.this.startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });

    }// FIN ON CREATE

    private void attemptLogin() {
    }

    @Override
    public void processFinish(String output) {
        
    }



}
