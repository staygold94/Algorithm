import java.io.*;
import java.util.*;

public class Main {
    public static int n,s;
    public static int answer = 0;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);
        
        // 만약 s가 0이라면, 공집합도 카운트 될 수 있으므로 -1 해준다.
        if(s == 0) answer--;
        
        System.out.println(answer);
    }

    public static void dfs(int idx, int total) {

        if(idx == n) {
            if(total == s) answer++;
            return;
        }

        // 해당 문제는 연속하지 않는 부분 수열의 합을 구하는 문제로,
        // 모든 요소를 완전탐색 하되 선택할지 or 말지에 포인트가 있다.
        dfs(idx+1, total+arr[idx]);
        dfs(idx+1, total);
    }
}