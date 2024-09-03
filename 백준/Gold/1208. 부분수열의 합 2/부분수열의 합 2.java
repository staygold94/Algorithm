import java.io.*;
import java.util.*;

public class Main {
    public static int n, s;
    public static long answer = 0;
    public static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        List<Long> leftList = new ArrayList<>();
        List<Long> rightList = new ArrayList<>();

        // 시간복잡도가 2의 n승이므로, 반반 나눠서 부분합을 먼저 찾아준다.
        dfs(0, n/2, 0, leftList);
        dfs(n/2, n, 0, rightList);

        // 정렬
        Collections.sort(leftList);
        Collections.sort(rightList);

        int left = 0;
        int right = rightList.size() - 1;

        // 각 포인터가 리스트 마지막까지 도달할 때까지 탐색
        while(left < leftList.size() && right >= 0) {

            long leftSum = leftList.get(left);
            long rightSum = rightList.get(right);
            long sum = leftSum + rightSum;

            if(sum == s) {
                long leftCnt = 0;
                long rightCnt = 0;

                while(left < leftList.size() && leftSum == leftList.get(left)) {
                    left++;
                    leftCnt++;
                }

                while(right >= 0 && rightSum == rightList.get(right)) {
                    right--;
                    rightCnt++;
                }

                answer += leftCnt * rightCnt;
            } else if(sum < s) {
                left++;
            } else {
                right--;
            }
        }

        if(s == 0) answer--;

        System.out.println(answer);
    }

    public static void dfs(int start, int end, long sum, List<Long> list) {

        if(start == end) {
            list.add(sum);
            return;
        }

        dfs(start+1, end, sum, list);
        dfs(start+1, end, sum + arr[start], list);
    }
}