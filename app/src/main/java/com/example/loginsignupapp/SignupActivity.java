package com.example.loginsignupapp;


        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private EditText etUsername, etPassword, etConfirmPassword;
    private FirebaseAuth auth;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ImageView leftIcon = findViewById(R.id.left_icon);
        ImageView rightIcon = findViewById(R.id.right_icon);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignupActivity.this,"You Clicked On Left Icon" ,Toast.LENGTH_SHORT).show();
            }
        });
        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignupActivity.this,"You Clicked On Right Icon" ,Toast.LENGTH_SHORT).show();
            }
        });

        etUsername = findViewById(R.id.etUsernameSignup);
        etPassword = findViewById(R.id.etPasswordSignup);
        etConfirmPassword = findViewById(R.id.etConfirmPasswordSignup);
    }


    public void SignUp(View view) {
        // TODO: 1- Get data from screen
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();

        // TODO: 2- Data validation
        if (username.trim().isEmpty() || password.trim().isEmpty()
                || confirmPassword.trim().isEmpty()) {
            Toast.makeText(this, "Username or password is missing!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match!!", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: 3- Check username and password with Firebase Authentication
        auth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // TODO: commands if successful
                        } else {


                            Toast.makeText(SignupActivity.this, "Username or password is empty!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });


    }

    //TODO: verify email format
//check if email starts with letter or_
    public boolean verifyEmail(String email)
    {
        String username, domain;
        // split string and check if we have formal email structure
        String[] splitString = email.split("@");

        if (splitString.length != 2) {
            Toast.makeText(SignupActivity.this, "Username or password are incorrect!", Toast.LENGTH_SHORT).show();
            return false;

        }

        username = splitString[0];
        domain = splitString[1];


            if (!((username.toLowerCase().charAt(0)>='a' && username.toLowerCase().charAt(0) <='z')||(username.charAt(0)=='_')))
            return false;

        for (int i=1;i<username.length();i++) {
            //check the rest of the string before '@'

            if (!((username.toLowerCase().charAt(0) >= 'a' && username.toLowerCase().charAt(0) <= 'z') || (username.charAt(0) == '_')) || (username.charAt(i) == '.') || (username.charAt(i) == '@'))
                return false;
        }

        return true;
    }

    public boolean CheckPassword(AppCompatActivity activity, String password) {
        int countCap = 0, countSmall = 0, countNum = 0, countWildCard = 0, countChars = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
                countCap++;
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
                countSmall++;
            for (int j = 0; j < 9; j++) {
                if (password.charAt(i) == i)
                    countNum++;
            }
            for (int j = 0; j < 9; j++) {
                if (password.charAt(i) != i) {
                    if (password.charAt(i) < 'A' && password.charAt(i) > 'Z')
                        countWildCard++;
                }
            }
        }
        countChars = countCap + countSmall;
        if (countChars >= 8 && countChars <= 30) {
            if (countCap < 1) {
                Toast.makeText(activity, "it must be at least one capital letter!", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (countSmall < 1) {
                Toast.makeText(activity, "it must be at least one capital letter!", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (countNum < 1) {
                Toast.makeText(activity, "it must be at least one number from 0-9!", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (countWildCard < 1) {
                Toast.makeText(activity, "it must be at least one  wild card (@, #, $, ….)!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }



    }

