package Days;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Day3 implements Day {
    @Override
    public void run(BufferedReader data) throws IOException {
        String bags;
        int sum = 0;

        while ((bags = data.readLine()) != null) {
            sum += checkRuckSackP2(bags);

        }
        System.out.println(sum);
    }

    private int checkRuckSackP1(String bags) {
        String bag1 = bags.substring(0, bags.length() / 2);
        String bag2 = bags.substring(bags.length() / 2);
        System.out.println(bags);
        System.out.println(bag1 + " " + bag2);
        TreeSet<Character> set = new TreeSet<>();
        for (char c : bag1.toCharArray()) {
            set.add(c);
        }
        for (char c: bag2.toCharArray()) {
            if (set.contains(c))
                return charToScore(c);
        }

        return 0;
    }

    int count = 0;
    HashSet<Character> items = new HashSet<>();
    private int checkRuckSackP2(String bag) {
        if (count == 0){
            for (char c : bag.toCharArray())
                items.add(c);
        }
        else{
            items.removeIf(character -> bag.indexOf(character) == -1);
        }
        if (count < 2){
            count++;
            return 0;
        }
        count = 0;
        System.out.println(items);
        int points = 0;
        for (char c : items) {
            System.out.println(charToScore(c));
            points = charToScore(c);
        }
        items = new HashSet<>();
        return points;
    }


    private int charToScore(char c) {
        return c - ((c > 'Z') ? 'a' : 'A' - 26) + 1;
    }

}
