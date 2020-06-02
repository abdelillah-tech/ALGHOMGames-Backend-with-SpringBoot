package com.alghom.alghomsudoku.jwtauthentification.message.response;

import com.alghom.alghomsudoku.jwtauthentification.model.Statistics;

public class StatResponse {
    private Integer wins;
    private Integer defeats;

    public StatResponse(Statistics statistics) {
        this.wins = statistics.getWins();
        this.defeats = statistics.getDefeats();
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getDefeats() {
        return defeats;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public void setDefeats(Integer defeats) {
        this.defeats = defeats;
    }
}
