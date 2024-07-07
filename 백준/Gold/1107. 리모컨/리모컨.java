import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean[] brokenYN;
    public static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        brokenYN = new boolean[10];
        answer = Math.abs(100 - target); // 초기값은 +, - 버튼만 사용하는 경우

        int n = Integer.parseInt(br.readLine());
        
        if (n != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                brokenYN[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // DFS 호출
        dfs(target, "");

        System.out.println(answer);
    }

    public static void dfs(int target, String now) {
        if (now.length() > 6) { // 채널 번호가 최대 500,000이므로 6자리 이상은 탐색하지 않음
            return;
        }

        if (!now.isEmpty()) { // 현재 조합의 숫자가 비어있지 않을 때만 계산
            int currentNum = Integer.parseInt(now);
            int pressCount = now.length() + Math.abs(currentNum - target);
            answer = Math.min(answer, pressCount);
        }

        for (int i = 0; i <= 9; i++) {
            if (!brokenYN[i]) {
                dfs(target, now + i); // DFS 재귀 호출
            }
        }
    }
}