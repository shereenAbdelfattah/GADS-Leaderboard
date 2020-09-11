package com.example.gads_leaderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gads_leaderboard.adapters.LearnersAdapter;
import com.example.gads_leaderboard.models.LearningLeaders;
import com.example.gads_leaderboard.services.GadsApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LeadersFragment extends Fragment {


    private RecyclerView recyclerView;

    private LearnersAdapter learnersAdapter;

    private ProgressBar learnersBar;



    public LeadersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_leaders, container, false);
        recyclerView = rootView.findViewById(R.id.leadersRecyclerVw);
        learnersBar = rootView.findViewById(R.id.progressBarLeaders);

        getLearningLeaders();


        return rootView;
    }

    private void getLearningLeaders() {

        GadsApiClient.getLeadersApi()
                .getLearningLeaders()
                .enqueue(new Callback<List<LearningLeaders>>() {
                    @Override
                    public void onResponse(Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {

                        if (response.isSuccessful()) {
                            List<LearningLeaders> learnersList = response.body();
                            learnersAdapter = new LearnersAdapter(learnersList, getActivity().getApplicationContext());
                            recyclerView.setAdapter(learnersAdapter);

                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                            learnersBar.setVisibility(View.GONE);


                        }

                    }

                    @Override
                    public void onFailure(Call<List<LearningLeaders>> call, Throwable t) {

                        learnersBar.setVisibility(View.VISIBLE);


                      //  Toast.makeText(getActivity().getApplicationContext()
                        //        , "" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });


    }
}