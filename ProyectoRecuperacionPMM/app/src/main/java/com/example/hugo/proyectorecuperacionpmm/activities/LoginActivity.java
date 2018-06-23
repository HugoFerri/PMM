package com.example.hugo.proyectorecuperacionpmm.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hugo.proyectorecuperacionpmm.R;
import com.example.hugo.proyectorecuperacionpmm.data.DBContract;
import com.example.hugo.proyectorecuperacionpmm.data.SQLiteHelper;
import com.example.hugo.proyectorecuperacionpmm.data.UserDAO;
import com.example.hugo.proyectorecuperacionpmm.model.User;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_SIGNUP = 0;
    EditText emailText;
    EditText passwordText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicialización de elementos del layout
        emailText = findViewById(R.id.activity_login_email);
        passwordText = findViewById(R.id.activity_login_password);
        loginButton = findViewById(R.id.activity_login_loginButton);
        TextView signupLink = findViewById(R.id.activity_login_signUpLink);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        // Listener del texto de sign up
        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                // Si el registro se ha llevado a cabo con éxito, volvemos a la actividad principal
                User user = data.getParcelableExtra("user");
                onLoginSuccess(user);
            }
        }
    }

    private void login() {
        if (!validate()) {
            onLoginFailed();
            return;
        }
        loginButton.setEnabled(false);

        // Ocultamos el teclado del usuario en el caso de que él no lo haya hecho
        InputMethodManager manager = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        if (manager != null) {
            manager.hideSoftInputFromWindow(passwordText.getWindowToken(), 0);
        }

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(getResources().getString(R.string.authentication_message));
        progressDialog.show();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();

                SQLiteHelper sqLiteHelper = SQLiteHelper.getInstance(getApplicationContext());
                UserDAO userDAO = new UserDAO(sqLiteHelper);
                Cursor cursor = userDAO.getUserByEmail(email);

                if (!cursor.moveToFirst()) {
                    emailText.post(new Runnable() {
                        @Override
                        public void run() {
                            emailText.setError(getResources()
                                    .getString(R.string.error_email_not_found));
                            onLoginFailed();
                        }
                    });

                } else if (!cursor.getString(cursor
                        .getColumnIndex(DBContract.UserEntry.KEY_PASSWORD))
                        .equals(password)) {
                    passwordText.post(new Runnable() {
                        @Override
                        public void run() {
                            passwordText.setError(getResources()
                                    .getString(R.string.error_password_not_correct));
                            onLoginFailed();
                        }
                    });
                } else {
                    User user = new User(cursor);
                    onLoginSuccess(user);
                }
                cursor.close();
                sqLiteHelper.close();
                progressDialog.dismiss();
            }
        }, 3000);
    }

    private void onLoginSuccess(User user) {
        loginButton.setEnabled(true);
        // Volvemos a la actividad principal mandando el email del usuario
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }


    private void onLoginFailed() {
        Toast.makeText(getBaseContext(), R.string.error_login, Toast.LENGTH_LONG).show();
        loginButton.setEnabled(true);
    }

    private boolean validate() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError(getResources().getString(R.string.error_email));
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError(getResources().getString(R.string.error_password));
            valid = false;
        } else {
            passwordText.setError(null);
        }
        return valid;
    }
}
