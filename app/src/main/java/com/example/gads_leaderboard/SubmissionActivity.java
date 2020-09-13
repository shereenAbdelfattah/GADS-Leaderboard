package com.example.gads_leaderboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gads_leaderboard.services.GadsApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionActivity extends AppCompatActivity {

    private Button submitBtn;
    private EditText firstNameEditTxt;
    private EditText lastNameEditTxt;
    private EditText emailEditTxt;
    private EditText githubLinkEditTxt;
    private ImageView cancelImageV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        Toolbar toolbar = findViewById(R.id.toolbarSubmit);
        setSupportActionBar(toolbar);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //cancelImageV = findViewById(R.id.submissionCloseIV);
        submitBtn = findViewById(R.id.submitBtn);
        firstNameEditTxt = findViewById(R.id.firstNameEditText);
        lastNameEditTxt = findViewById(R.id.lastNameEditText);
        emailEditTxt = findViewById(R.id.emailEditText);
        githubLinkEditTxt = findViewById(R.id.githubLinkEditText);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitProject();
            }
        });

    }


    public void submitProject() {

        if (isValidInputs()) {
            LayoutInflater inflater = LayoutInflater.from(this);
            View view = inflater.inflate(R.layout.confirm_submission, null);

            Button yesSubmissionBtn = view.findViewById(R.id.yesBTN);

            ImageView cancelBtn = view.findViewById(R.id.submissionCloseIV);

            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setView(view)
                    .create();
            alertDialog.show();
            yesSubmissionBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    postToGoogleServers();
                    alertDialog.dismiss();


                }
            });

            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();

                }
            });


        }


    }

    private boolean isValidInputs() {
        if (firstNameEditTxt.getText().toString().trim().equals("")) {
            firstNameEditTxt.setError("Name is required");
            return false;
        }
        if (lastNameEditTxt.getText().toString().trim().equals("")) {
            lastNameEditTxt.setError("Last name is required");
            return false;
        }
        if (emailEditTxt.getText().toString().trim().equals("")
                || !Patterns.EMAIL_ADDRESS.matcher(emailEditTxt.getText().toString().trim()).matches()) {
            emailEditTxt.setError("Enter a valid email");
            return false;
        }
        if (githubLinkEditTxt.getText().toString().trim().equals("")) {
            githubLinkEditTxt.setError("Github Link is required");
            return false;
        }
        return true;
    }

    private void postToGoogleServers() {

        String firstName = firstNameEditTxt.getText().toString().trim();
        String lastName = lastNameEditTxt.getText().toString().trim();
        String email = emailEditTxt.getText().toString().trim();
        String githubLink = githubLinkEditTxt.getText().toString().trim();
        GadsApiClient.getGoogleDocs().submitProject(email, firstName, lastName, githubLink)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            //Log.d("TAG", "-----submitted-----");
                           Toast.makeText(SubmissionActivity.this, "" + response.code(), Toast.LENGTH_LONG).show();

                            LayoutInflater inflater22 = LayoutInflater.from(SubmissionActivity.this);
                            View v = inflater22.inflate(R.layout.success_dialog, null);

                            AlertDialog alertDialog22 = new AlertDialog.Builder(SubmissionActivity.this,
                                    R.style.Theme_MaterialComponents_Light_Dialog)
                                    .setView(v)
                                    .create();
                            alertDialog22.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d("TAG", "------fail-----" + t.getMessage());

                        Toast.makeText(SubmissionActivity.this, "failure...." , Toast.LENGTH_LONG).show();

                        LayoutInflater inflater2 = LayoutInflater.from(SubmissionActivity.this);
                        View view2 = inflater2.inflate(R.layout.submission_fail_dialog, null);

                        AlertDialog alertDialog2 = new AlertDialog.Builder(SubmissionActivity.this,
                                R.style.Theme_MaterialComponents_Light_Dialog)
                                 .setView(view2)
                                .create();
                        alertDialog2.show();

                    }
                });
    }


}