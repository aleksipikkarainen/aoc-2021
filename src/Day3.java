import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Day3 {

    public Day3() {

    }


    public void run() {
        try {
            String[] s = readLines("input3.txt");

            int[] values = new int[12];
            for(int i = 0; i < s.length; i++) {
                for(int k = 0; k < 12; k++) {
                    if(s[i].charAt(k) == '0') {
                        values[k]--;
                    } else {
                        values[k]++;
                    }
                }
            }

            for(int m = 0; m < 12; m++) {
                if(values[m] < 0) {
                    values[m] = 0;
                } else {
                    values[m] = 1;
                }
            }

            String bin = "";
            for(int n = 0; n < 12; n++) {
                bin += values[n];
            }
            System.out.println(bin);
            int gamma = Integer.parseUnsignedInt(bin, 2);
            System.out.println(gamma);
            String bin2 = bin.replace('0', '2').replace('1', '0').replace('2', '1');
            int epsilon = Integer.parseUnsignedInt(bin2, 2);
            System.out.println(epsilon);

            System.out.println(gamma*epsilon);


        } catch (IOException e) {
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

    public void run2() {
        try {
            String[] s = readLines("input3.txt");
            ArrayList<String> list = new ArrayList<>(Arrays.asList(s));
            ArrayList<String> list2 = new ArrayList<>(Arrays.asList(s));
            int counter;
            int counter2;
            for(int i = 0; i < 12; i++) {
                counter = 0;
                counter2 = 0;
                for(int k = 0; k < list.size(); k++) {
                    if(list.get(k).charAt(i) == '1' ) {
                        counter++;
                    } else {
                        counter2++;
                    }
                }
                if(list.size() != 1) {
                    if(counter >= counter2) {
                        for(int k = 0; k < list.size(); k++) {
                            if(list.get(k).charAt(i) == '0' ) {
                                list.remove(k);
                                k--;
                            }
                        }
                    } else {
                        for(int k = 0; k < list.size(); k++) {
                            if(list.get(k).charAt(i) == '1' ) {
                                list.remove(k);
                                k--;
                            }
                        }
                    }
                }
            }
            int ogr = Integer.parseUnsignedInt(list.get(0), 2);
            System.out.println(ogr);

            int counter3;
            int counter4;
            for(int i = 0; i < 12; i++) {
                counter3 = 0;
                counter4 = 0;
                for(int k = 0; k < list2.size(); k++) {
                    if(list2.get(k).charAt(i) == '1' ) {
                        counter3++;
                    } else {
                        counter4++;
                    }
                }
                System.out.println(list2.size());
                if(list2.size() != 1) {
                    if(counter3 >= counter4) {
                        for(int k = 0; k < list2.size(); k++) {
                            if(list2.get(k).charAt(i) == '1' ) {
                                list2.remove(k);
                                k--;
                            }
                        }
                    } else {
                        for(int k = 0; k < list2.size(); k++) {
                            if(list2.get(k).charAt(i) == '0' ) {
                                list2.remove(k);
                                k--;
                            }
                        }
                    }
                }
            }
            int co2 = Integer.parseUnsignedInt(list2.get(0), 2);
            System.out.println(ogr*co2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
