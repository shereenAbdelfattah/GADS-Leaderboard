package com.example.gads_leaderboard.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads_leaderboard.R;
import com.example.gads_leaderboard.models.SkillIqLeaders;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.SkillViewHolder> {

    List<SkillIqLeaders> learningLeadersList ;
    Context mContext;

    public SkillAdapter(List<SkillIqLeaders> learningLeadersList, Context context) {
        this.learningLeadersList = learningLeadersList;
        mContext = context;
    }

    public  static  class SkillViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTextView;
        public TextView countryAndScoreTextView;
        public ImageView badgeImageView;

        public SkillViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.learnerName);
            countryAndScoreTextView = itemView.findViewById(R.id.countryAndScoreOrHours);
            badgeImageView = itemView.findViewById(R.id.learnerBadge);
        }
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaders_list_item,parent,false);
        SkillViewHolder skillViewHolder = new SkillViewHolder(v);

        return skillViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {


        SkillIqLeaders currentLearner = learningLeadersList.get(position);

        holder.nameTextView.setText(currentLearner.getName());

        holder.countryAndScoreTextView.setText(currentLearner.getScore() + " Skill IQ, " + currentLearner.getCountry());

        Picasso.get()
                .load(Uri.parse(currentLearner.getBadgeUrl()))

                .into(holder.badgeImageView);


    }

    @Override
    public int getItemCount() {
        return learningLeadersList.size();
    }
}
