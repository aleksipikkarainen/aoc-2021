import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 {


    public Day2() {
    }

    public void run() {
        try {
            String[] s = readLines("input2.txt");
            int x = 0;
            int y = 0;
            int a = 0;
            int z = 0;
            int d = 0;
            String ss;
            for(int i = 0; i < s.length; i++) {
                ss = s[i].substring(s[i].length() - 1);
                if (s[i].charAt(0) == 'f') {
                    y += Integer.parseInt(ss);
                } else if (s[i].charAt(0) == 'u') {
                    x -= Integer.parseInt(ss);
                } else {
                    x += Integer.parseInt(ss);
                }
            }
            System.out.println(x*y);
            for(int i = 0; i < s.length; i++) {
                ss = s[i].substring(s[i].length() - 1);
                if (s[i].charAt(0) == 'f') {
                    z += Integer.parseInt(ss);
                    d += (Integer.parseInt(ss)*a);
                } else if (s[i].charAt(0) == 'u') {
                    a -= Integer.parseInt(ss);
                } else {
                    a += Integer.parseInt(ss);
                }
            }
            System.out.println(z*d);
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
}
