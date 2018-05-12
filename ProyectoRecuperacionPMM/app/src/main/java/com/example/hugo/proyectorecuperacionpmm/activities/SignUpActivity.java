package com.example.hugo.proyectorecuperacionpmm.activities;

import android.app.ProgressDialog;
import android.content.Context;
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
import com.example.hugo.proyectorecuperacionpmm.data.SQLiteHelper;
import com.example.hugo.proyectorecuperacionpmm.models.User;
import com.example.hugo.proyectorecuperacionpmm.data.UserDao;

public class SignUpActivity extends AppCompatActivity {
    EditText emailText;
    EditText passwordText;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailText = findViewById(R.id.activity_sign_up_email);
        passwordText = findViewById(R.id.activity_sign_up_password);
        signUpButton = findViewById(R.id.activity_sign_up_signUpButton);
        TextView loginLink = findViewById(R.id.activity_sign_up_loginLink);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volvemos a la actividad de login
                finish();
            }
        });
    }

    public void signUp() {
        if (!validate()) {
            onSignUpFailed();
            return;
        }
        signUpButton.setEnabled(false);

        InputMethodManager manager = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(passwordText.getWindowToken(), 0);

        final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(getResources().getString(R.string.creating_account_message));
        progressDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();

                SQLiteHelper sqLiteHelper = SQLiteHelper.getInstance(getApplicationContext());
                UserDao userDao = new UserDao(sqLiteHelper);
                Cursor cursor = userDao.getUserByEmail(email);

                if (cursor.moveToFirst()) {
                    emailText.post(new Runnable() {
                        @Override
                        public void run() {
                            emailText.setError(getResources()
                                    .getString(R.string.error_email_already_used));
                            onSignUpFailed();
                        }
                    });
                } else {
                    userDao.insertUser(new User(email, password));
                    onSignUpSuccess();
                }
                cursor.close();
                sqLiteHelper.close();
                progressDialog.dismiss();
            }
        }, 3000);
    }

    private void onSignUpSuccess() {
        signUpButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    private void onSignUpFailed() {
        Toast.makeText(getBaseContext(), R.string.error_signup, Toast.LENGTH_LONG).show();
        signUpButton.setEnabled(true);
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
