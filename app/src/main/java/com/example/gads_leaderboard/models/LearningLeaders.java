package com.example.gads_leaderboard.models;

public class LearningLeaders {

    /*
    "name":"Kojo Yeboah",
      "hours":63,
      "country":"Ghana",
      "badgeUrl":"https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png"
    * */

    private String name;
    private int hours;
    private String country;
    private String badgeUrl;

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }
}
