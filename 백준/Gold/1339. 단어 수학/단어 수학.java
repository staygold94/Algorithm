import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[26];

        // 알파벳별 자릿수만큼 저장 (ex. 10100)
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<s.length(); j++) {
                int idx = s.charAt(j) - 65;
                arr[idx] += Math.pow(10, s.length() - j - 1);
            }
        }

        // 정렬
        Arrays.sort(arr);

        // 높은 자릿수부터 9씩 분배하여 최댓값 구함
        int num = 9;
        int answer = 0;
        for(int i=25; i>=17; i--) {
            answer += num * arr[i];
            num--;
        }
        System.out.println(answer);
    }
}