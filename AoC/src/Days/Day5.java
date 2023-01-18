package Days;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Day5 implements Day {
    BufferedReader data;
    String next;
    Stack<Character>[] stacks = new Stack[9];

    @Override
    public void run(BufferedReader data) throws IOException {
        this.data = data;

        createStacks();
        checkStackP2();

        for (Stack<Character> s: stacks)
            System.out.print(s.pop());

    }

    private void createStacks() throws IOException {
        for (int i = 0; i < stacks.length; i++)
            stacks[i] = new Stack<>();

        for (int i = 0; i < 8; i++) {
            next = data.readLine();
            for (int j = 0; j < 9; j++) {
                char c = next.charAt(1 + (j * 4));
                if (c == ' ') {
                    continue;
                }
                stacks[j].add(0, c);
            }
        }

        data.readLine();
        data.readLine();
    }

    private void checkStackP1() throws IOException {
        while ((next = data.readLine()) != null) {
            int[] moves = parseMove(next);

            for (int i = 0; i < moves[0]; i++)
                stacks[moves[2]].add(stacks[moves[1]].pop());
        }
    }

    private void checkStackP2() throws IOException{
        PriorityQueue<Character> queue = new PriorityQueue<>();
        while ((next = data.readLine()) != null){
            int[] moves = parseMove(next);

            for (int i = 0; i < moves[0]; i++) {
                queue.add(stacks[moves[1]].pop());
            }
            while (!queue.isEmpty())
                stacks[moves[2]].add(queue.poll());
        }
    }

    private int[] parseMove(String in) {
        int[] moves = new int[3];
        moves[0] = getNumber(in, "move ");
        moves[1] = getNumber(in, " from ") - 1;
        moves[2] = getNumber(in, " to ") - 1;
        return moves;
    }

    private int getNumber(String in, String pattern) {
        in = in.substring(in.indexOf(pattern) + pattern.length());
        int index = in.indexOf(' ');
        return Integer.parseInt((index != -1) ? in.substring(0, index) : in);
    }
}
