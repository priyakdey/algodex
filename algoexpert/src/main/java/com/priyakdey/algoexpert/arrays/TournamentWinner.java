package com.priyakdey.algoexpert.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class TournamentWinner {

    // use a hashmap to maintain the overall scores for each team.
    // iterate over hashmap to get the winner

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions,
                                   ArrayList<Integer> results) {
        Map<String, Integer> scorecard = new HashMap<>();

        String overallWinner = "";
        int highestScore = 0;

        for (int i = 0, competitionsSize = competitions.size(); i < competitionsSize; i++) {
            ArrayList<String> competition = competitions.get(i);
            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            int result = results.get(i);
            String winner = result == 1 ? homeTeam : awayTeam;
            scorecard.compute(winner, (_, score) -> score == null ? 1 :
                    score + 3);
            int score = scorecard.get(winner);
            if (score >= highestScore) {
                highestScore = score;
                overallWinner = winner;
            }
        }

        return overallWinner;
    }

}
