package com.example.coursevisualizer;

import android.content.Intent;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;




//    private Button showPie;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  
  //        showPie = (Button) findViewById(R.id.showPie);
//        showPie.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openPieChartActivity();
//            }
//        });
    }

//    private void openPieChartActivity() {
//        Intent pieIntent = new Intent(this, PieChartActivity.class);
//        startActivity(pieIntent);
//    }


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {// if the user has successfully logged in
                    //Change to screen after log in here :)
//                    Intent i = new Intent(MainActivity.this, LoginTestActivity.class);
//                    startActivity(i);
                }
            }
        };

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSignIn();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startSignIn() {
        String email =  Name.getText().toString();
        String password = Password.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            //change this to display a proper error message
            Toast.makeText(MainActivity.this, "Field not filled in", Toast.LENGTH_LONG).show();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()) {
                        //change this to display a proper error message
                        Toast.makeText(MainActivity.this, "Sign in failed", Toast.LENGTH_LONG).show();
                    } else {
                        Intent i = new Intent(MainActivity.this, LoginTestActivity.class);
                        startActivity(i);
                    }
                }
            });
        }
    }

}
