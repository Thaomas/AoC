package Days;

import java.io.BufferedReader;
import java.io.IOException;

public class Day4 implements Day {
    @Override
    public void run(BufferedReader data) throws IOException {
        String elves;
        int sum = 0;

        while ((elves = data.readLine()) != null) {
            sum += checkPairWorkP2(elves);
        }
        System.out.println(sum);

    }

    private int checkPairWorkP1(String elves) {
        Elf elf1 = new Elf(elves.substring(0, elves.indexOf(",")));
        Elf elf2 = new Elf(elves.substring(elves.indexOf(",") + 1));
        return (elf1.containsElf(elf2) || elf2.containsElf(elf1))? 1:0 ;
    }

    private int checkPairWorkP2(String elves) {
        Elf elf1 = new Elf(elves.substring(0, elves.indexOf(",")));
        Elf elf2 = new Elf(elves.substring(elves.indexOf(",") + 1));
        return (elf1.overlapElf(elf2) || elf2.overlapElf(elf1))? 1:0 ;
    }

    private class Elf{
        int first;
        int second;

        public Elf(String in) {
            first = Integer.parseInt(in.substring(0, in.indexOf("-")));
            second = Integer.parseInt(in.substring(in.indexOf("-")+1));
        }

        public boolean containsElf(Elf elf2) {
            return first <= elf2.first && second >= elf2.second;
        }

        public boolean overlapElf(Elf elf2){
            if (first > elf2.second || second < elf2.first){

                System.out.println(this);
                System.out.println(elf2);
                System.out.println();
                return false;
            }
            if (true)
                return true;
            return first <= elf2.first || second >= elf2.second;
        }

        @Override
        public String toString() {
            return first +" " + second;
        }
    }
}
