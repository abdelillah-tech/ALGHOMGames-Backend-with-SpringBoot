package com.alghom.alghomsudoku.jwtauthentification.controller;

import com.alghom.alghomsudoku.jwtauthentification.exception.ResourceNotFoundException;
import com.alghom.alghomsudoku.jwtauthentification.message.response.StatResponse;
import com.alghom.alghomsudoku.jwtauthentification.model.Statistics;
import com.alghom.alghomsudoku.jwtauthentification.repository.StatRepository;
import com.alghom.alghomsudoku.jwtauthentification.repository.UserRepository;
import com.alghom.alghomsudoku.jwtauthentification.security.services.CurrentUser;
import com.alghom.alghomsudoku.jwtauthentification.security.services.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stat")
public class StatisticsAPIs {

    @Autowired
    private StatRepository statRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public StatResponse getStatistics(@CurrentUser UserPrinciple userPrinciple) {
        Statistics statistics = statRepository.findByUserId(userPrinciple.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrinciple.getId()));
        return new StatResponse(statistics);
    }

    @GetMapping("/win")
    public StatResponse incrementWin(@CurrentUser UserPrinciple userPrinciple) {
        Statistics statistics = statRepository.findByUserId(userPrinciple.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrinciple.getId()));
        statistics.setWins(statistics.getWins() + 1);
        statRepository.save(statistics);
        return new StatResponse(statistics);
    }

    @GetMapping("/defeat")
    public StatResponse incrementDef(@CurrentUser UserPrinciple userPrinciple) {
        Statistics statistics = statRepository.findByUserId(userPrinciple.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrinciple.getId()));
        statistics.setDefeats(statistics.getDefeats() + 1);
        statRepository.save(statistics);
        return new StatResponse(statistics);
    }

}
