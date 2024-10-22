import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] arr = new String[5][15];

        for(int i=0; i<5; i++) {
            Arrays.fill(arr[i], "-");
            String[] tmp = br.readLine().split("");
            for(int j=0; j<tmp.length; j++) {
                arr[i][j] = tmp[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<15; i++) {
            for(int j=0; j<5; j++) {
                if(!arr[j][i].equals("-")) {
                    sb.append(arr[j][i]);
                }
            }
        }
        System.out.println(sb.toString());
    }
}