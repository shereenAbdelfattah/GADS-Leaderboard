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
import com.example.gads_leaderboard.models.LearningLeaders;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LearnersAdapter extends RecyclerView.Adapter<LearnersAdapter.LearnersViewHolder> {

    List<LearningLeaders> learningLeadersList ;
    Context mContext;

    public LearnersAdapter(List<LearningLeaders> learningLeadersList, Context context) {
        this.learningLeadersList = learningLeadersList;
        mContext = context;
    }

    public static class LearnersViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView countryTextView;
        public ImageView badgeImageView;


        public LearnersViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.learnerName);
            countryTextView = itemView.findViewById(R.id.countryAndScoreOrHours);
            badgeImageView = itemView.findViewById(R.id.learnerBadge);

        }
    }


    @NonNull
    @Override
    public LearnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View learnerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaders_list_item, parent, false);
        LearnersViewHolder learnersViewHolder = new LearnersViewHolder(learnerView);

        return learnersViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LearnersViewHolder holder, int position) {

        LearningLeaders currentLearner = learningLeadersList.get(position);

        holder.nameTextView.setText(currentLearner.getName());

        holder.countryTextView.setText(currentLearner.getHours() + " learning hours, " + currentLearner.getCountry());

        Picasso.get()
                .load(Uri.parse(currentLearner.getBadgeUrl()))

                .into(holder.badgeImageView);
        /*
        quaredImageView view = (SquaredImageView) convertView;
  if (view == null) {
    view = new SquaredImageView(context);
  }
  String url = getItem(position);

  Picasso.get().load(url).into(view);
        */


    }

    @Override
    public int getItemCount() {
        return learningLeadersList.size();
    }
}
