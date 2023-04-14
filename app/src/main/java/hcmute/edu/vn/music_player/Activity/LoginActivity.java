package hcmute.edu.vn.music_player.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

//import hcmute.edu.vn.ecapplication.R;
import hcmute.edu.vn.music_player.R;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }
    public void Signin(View view) {
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if (TextUtils.isEmpty(userEmail)) {
//            Toast.makeText(LoginActivity.this, "Enter Email Address!", Toast.LENGTH_SHORT).show();
//            return;
            new AlertDialog.Builder(LoginActivity.this)
                    .setTitle("Warning!")
                    .setMessage("Enter Email Address!")
                    .setPositiveButton("OK", null)
                    .show();
        }
        if (TextUtils.isEmpty(userPassword)) {
//            Toast.makeText(LoginActivity.this, "Enter Password!", Toast.LENGTH_SHORT).show();
//            return;
            new AlertDialog.Builder(LoginActivity.this)
                    .setTitle("Warning!")
                    .setMessage("Enter Password!")
                    .setPositiveButton("OK", null)
                    .show();
        }
        if (userPassword.length() < 6) {
//            Toast.makeText(LoginActivity.this, "Password to short, Enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
//            return;
            new AlertDialog.Builder(LoginActivity.this)
                    .setTitle("Warning!")
                    .setMessage("Password to short, Enter minimum 6 characters!")
                    .setPositiveButton("OK", null)
                    .show();
        }
        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
//                    Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Login")
                            .setMessage("Logged in successfully!")
                            .setPositiveButton("OK", null)
                            .show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else{
//                    Toast.makeText(LoginActivity.this,
//                            "Invalid username or password. Please try again!" ,
//                            Toast.LENGTH_SHORT).show();
//                    new AlertDialog.Builder(LoginActivity.this)
//                            .setTitle("Error")
//                            .setMessage("Invalid username or password. Please try again!")
//                            .setPositiveButton("OK", null)
//                            .show();
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Error")
                            .setMessage("The account or password is incorrect, please check the account or password again!! If you don't have an account, you can click register now! ")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // Do nothing, just close the dialog
                                }
                            })
                            .setNegativeButton("Register NOW", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                                    startActivity(intent);
                                }
                            })
                            .show();


                }
            }
        });
    }
    public void Signup(View view){
        startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
    }
}