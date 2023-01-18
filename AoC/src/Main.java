import Days.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Day d = new Day5();
        try (BufferedReader reader = new BufferedReader(new FileReader("Data/"+d.getClass().getSimpleName()+".txt"))) {

            d.run(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
