import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[8][2];

        for(int i=0; i<8; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i+1;
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int answer = 0;
        int[] tmp = new int[5];
        for(int i=3; i<8; i++) {
            answer += arr[i][0];
            tmp[i-3] = arr[i][1];
        }
        System.out.println(answer);
        Arrays.sort(tmp);
        for(int i : tmp) {
            System.out.print(i + " ");
        }
    }
}