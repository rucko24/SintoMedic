package com.example.sintomedic.ui.login;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sintomedic.DoctorRegisterActivity;
import com.example.sintomedic.MainActivityDoctor;
import com.example.sintomedic.MainActivityPaciente;
import com.example.sintomedic.PacienteRegisterActivity;
import com.example.sintomedic.R;
import com.example.sintomedic.UnsafeOkHttpClient;
import com.example.sintomedic.Usuario;


import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {


    private LoginViewModel loginViewModel;
    /**
     * Credenciales de pruebas BORRAR!!!!!!!! TRAS PRUEBAS!!!!
     * TO DO: borrar cuando vayas a implementar una autenticación real.
     */
    private static final String DUMMY_USER_ID = "0000000000";
    private static final String DUMMY_PASSWORD = "dummy_password";
    //STRING TIPOS USUARIO
    private String USER_TYPE_1 = "paciente";
    private String USER_TYPE_2 = "doctor";

    // para los intent:

    public static final int TXT_REQ2 =2;
    private static final int TXT_REQ3 =3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final CheckBox checkBoxEditText = findViewById(R.id.checkBox);
        final Button loginButton = findViewById(R.id.login);
        final Button registerPacienteButton = findViewById(R.id.regPacienteButton);
        final Button registerDoctorButton = findViewById(R.id.regDoctorButton);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

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

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });
    }



    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        String user=null;
        View view = null;
        // IR A LA ACTIVIDAD Y DECIDIR SEGUN USER
        goToLoginActivity(view);
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    /**
     * Method that performs RESTful webservice invocations
     *
     * @param //params
     */

    /*
    public void invokeWS(RequestParams params){
        // Show Progress Dialog
        prgDialog.show();
        // Make RESTful webservice call using AsyncHttpClient object
        UnsafeOkHttpClient client = new UnsafeOkHttpClient();
        client.get("http://192.168.2.2:9999/useraccount/login/dologin",params ,new UnsafeOkHttpClient() {
            // When the response returned by REST has Http response code '200'
            @Override
            public void onSuccess(String response) {
                // Hide Progress Dialog
                prgDialog.hide();
                try {
                    // JSON Object
                    JSONObject obj = new JSONObject(response);
                    // When the JSON response has status boolean value assigned with true
                    if(obj.getBoolean("status")){
                        Toast.makeText(getApplicationContext(), "You are successfully logged in!", Toast.LENGTH_LONG).show();
                        // Navigate to Home screen
                        goToRegisterActivity();
                    }
                    // Else display error message
                    else{
                        errorMsg.setText(obj.getString("error_msg"));
                        Toast.makeText(getApplicationContext(), obj.getString("error_msg"), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }
            }
            // When the response returned by REST has Http response code other than '200'
            @Override
            public void onFailure(int statusCode, Throwable error,
                                  String content) {
                // Hide Progress Dialog
                prgDialog.hide();
                // When Http response code is '404'
                if(statusCode == 404){
                    Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                }
                // When Http response code is '500'
                else if(statusCode == 500){
                    Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                }
                // When Http response code other than 404, 500
                else{
                    Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

        */


    //MODIFICACION SERGIO DEL LOGIN ACTIVITY PARA DIRIGIR A UNO U OTRA ACTIVIDAD SEGUN TIPO USER

    public void goToLoginActivity(View view) {
        //coger el tipo usuario que sea

        Intent intent = null;
        Usuario user = null;
        if(user.equals(USER_TYPE_1)){
             intent = new Intent(this, MainActivityPaciente.class);
        }else if(user.equals(USER_TYPE_2)){
             intent = new Intent(this, MainActivityDoctor.class);
        }
        if(intent!=null){
            //lanzar actividad esperando una respuesta
            startActivityForResult(intent,TXT_REQ2);
            //startActivity(intent);
        }


    }
    // revisar
    public void LoginActivity(View view) {
    }

    public void DoctorRegisterActivity(View view) {
    }

    public void PacienteRegisterActivity(View view) {
    }
}
