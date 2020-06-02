package com.alghom.alghomsudoku.jwtauthentification.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "wins")
    private Integer wins = 0;

    @Column(name = "defeats")
    private Integer defeats = 0;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Statistics() {}

    public Statistics(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getDefeats() {
        return defeats;
    }

    public User getUser() { return user; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public void setDefeats(Integer defeats) {
        this.defeats = defeats;
    }

    public void setUser(User user) { this.user = user; }
}
