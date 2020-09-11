package com.example.gads_leaderboard.models;

import java.security.PrivateKey;

public class SkillIqLeaders {
    /* {
      "name":"Perry Oluwatobi",
      "score":173,
      "country":"Nigeria",
      "badgeUrl":"https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"
   }*/


    private String name;

    private  int score;

    private String country;

    private String badgeUrl;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }


}
