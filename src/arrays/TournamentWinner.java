package arrays;

import java.util.*;

public class TournamentWinner {
    public static void main(String[] args) {
        ArrayList<String> gameOne = new ArrayList<>();
        gameOne.add("HTML");
        gameOne.add("C#");

        ArrayList<String> gameTwo = new ArrayList<>();
        gameTwo.add("C#");
        gameTwo.add("Python");

        ArrayList<String> gameThree = new ArrayList<>();
        gameThree.add("Python");
        gameThree.add("HTML");

        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        competitions.add(gameOne);
        competitions.add(gameTwo);
        competitions.add(gameThree);

        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(1);


        System.out.println(tournamentWinner(competitions, results));

    }

    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        int maxNrOfWins = 0;
        Map<String, Integer> victories = new HashMap<>();
        ArrayList<String> winners = new ArrayList<>();


        // retrieve only the winning teams
        for (int i = 0; i < competitions.size(); i++) {
            if (results.get(i) == 0) {
                winners.add(competitions.get(i).get(1));
            } else {
                winners.add(competitions.get(i).get(0));
            }
        }

        for (int i = 0; i < winners.size(); i++) {
            if(victories.containsKey(winners.get(i))) {
               int frequency = victories.get(winners.get(i));
               frequency++;
               victories.put(winners.get(i), frequency);
            } else {
                victories.put(winners.get(i), 1);
            }
        }

        // retrieve the team with the biggest nr of wins
        for (Integer nrOfWins : victories.values()) {
            if (nrOfWins > maxNrOfWins) {
                maxNrOfWins = nrOfWins;
            }
        }

        for (Map.Entry<String, Integer> entry : victories.entrySet()) {
            if(entry.getValue() == maxNrOfWins) {
                return entry.getKey();
            }
        }

        return "";
    }
}
