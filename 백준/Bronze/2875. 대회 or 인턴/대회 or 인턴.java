import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int team = Math.min(n/2, m);
        int intern = n + m - team * 3;

        if(intern < k) {
            int minusTeam = (k - intern) % 3 == 0 ? (k - intern) / 3 : (k - intern) / 3 + 1;
            team -= minusTeam;
        }

        System.out.println(team);
    }
}