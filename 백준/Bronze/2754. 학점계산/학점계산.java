import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] arr = {{"A+", "4.3"}, { "A0", "4.0"}, { "A-", "3.7"},
        {"B+", "3.3"}, { "B0", "3.0"}, { "B-", "2.7"},
        {"C+", "2.3"}, { "C0", "2.0"}, { "C-", "1.7"},
        {"D+", "1.3"}, { "D0", "1.0"}, { "D-", "0.7"},
        {"F", "0.0"}};
        String s = br.readLine();
        for(int i=0; i<arr.length; i++) {
            if(s.equals(arr[i][0])) {
                System.out.println(arr[i][1]);
                break;
            }
        }
    }
}