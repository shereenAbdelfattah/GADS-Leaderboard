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

import com.example.gads_leaderboard.adapters.SkillAdapter;
import com.example.gads_leaderboard.models.SkillIqLeaders;
import com.example.gads_leaderboard.services.GadsApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * create an instance of this fragment.
 */
public class SkillIQLeadersFragment extends Fragment {

    RecyclerView recyclerView;
    private SkillAdapter skillAdapter;

    private ProgressBar learnersPBar;


    public SkillIQLeadersFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerViewSkills);
        learnersPBar = rootView.findViewById(R.id.progressBarSkills);

        getSkillLeaders();

        return rootView;
    }

    private void getSkillLeaders() {
        GadsApiClient.getLeadersApi()
                .getSkillLeaders()
                .enqueue(new Callback<List<SkillIqLeaders>>() {
                    @Override
                    public void onResponse(Call<List<SkillIqLeaders>> call, Response<List<SkillIqLeaders>> response) {
                        if (response.isSuccessful()) {
                            List<SkillIqLeaders> skillIqList = response.body();
                            //  skillAdapter = new LearnersAdapter(skillIqList, getActivity().getApplicationContext());
                            skillAdapter = new SkillAdapter(skillIqList, getActivity());
                            recyclerView.setAdapter(skillAdapter);

                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                            learnersPBar.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<SkillIqLeaders>> call, Throwable t) {
                        learnersPBar.setVisibility(View.VISIBLE);


//                        Toast.makeText(getActivity().getApplicationContext()
//                                , "" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });


    }
}