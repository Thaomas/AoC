package Days;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;

public class Day2 implements Day {
    @Override
    public void run(BufferedReader data) throws IOException {
        int p1Score = 0, p2Score = 0;
        String move;
        while ((move = data.readLine()) != null) {
            Pair<Integer, Integer> p = checkMoveP2(move);
            p1Score += p.getKey();
            p2Score += p.getValue();
        }
        System.out.printf("P1 Score: %s P2 Score: %s%n", p1Score, p2Score);
    }

    private Pair<Integer, Integer> checkMoveP1(String move) {
        int p1Score = move.charAt(0) - '@';
        int p2Score = move.charAt(2) - 'W';

        if (p1Score == p2Score) {
            p1Score += 3;
            p2Score += 3;
        } else {
            if (((p1Score + 1) % 3) == p2Score - 1)
                p1Score += 6;
            else
                p2Score += 6;
        }

        return new Pair<>(p1Score, p2Score);
    }

    private Pair<Integer, Integer> checkMoveP2(String move) {
        int p1Score = move.charAt(0) - '@';
        int p2Score = 0;

        switch (move.charAt(2)) {
            case 'X':
                p2Score = p1Score - 1;
                if (p2Score == 0)
                    p2Score = 3;
                p1Score += 6;
                break;
            case 'Y':
                p1Score += 3;
                p2Score = p1Score;
                break;
            case 'Z':
                p2Score = (p1Score + 1) % 3;

                if (p2Score == 0)
                    p2Score = 3;

                p2Score += 6;
                break;
        }
        return new Pair<>(p1Score, p2Score);
    }
}
