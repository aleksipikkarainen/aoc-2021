import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Day1 {

    public Day1() {

    }

    public void run(){
        try {
            String[] s = readLines("input.txt");
            int[] arr = Stream.of(s)
                    .mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(arr));
            int counter = 0;
            int counter2 = 0;
            for(int i = 0; i < arr.length-1; i++) {
                if(arr[i] < arr[i+1]) {
                    counter++;
                }
            }
            System.out.println(counter);
            System.out.println(arr.length);
            System.out.println("Part 2:");
            int[] arr2 = new int[arr.length-2];
            for(int i = 0; i < arr.length-2; i++) {
                arr2[i] = (arr[i] + arr[i+1] + arr[i+2]);
            }
            for(int i = 0; i < arr2.length-1; i++) {
                if(arr2[i] < arr2[i+1]) {
                    counter2++;
                }
            }
            System.out.println(counter2);
            System.out.println(arr2.length);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }
}
