import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] arr = new int[26][s.length()+1];

        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<26; j++) {
                arr[j][i+1] = arr[j][i];
            }
            arr[s.charAt(i) - 'a'][i+1]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = st.nextToken().charAt(0) - 'a';
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(arr[c][y+1] - arr[c][x] + "\n");
        }
        System.out.print(sb.toString());
    }
}