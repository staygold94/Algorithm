import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] aArr = new int[n];
        int[] bArr = new int[n];
        int[] cArr = new int[n];
        int[] dArr = new int[n];
        long answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            aArr[i] = Integer.parseInt(st.nextToken());
            bArr[i] = Integer.parseInt(st.nextToken());
            cArr[i] = Integer.parseInt(st.nextToken());
            dArr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int[] leftList = new int[n * n];
        int[] rightList = new int[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                leftList[idx] = aArr[i] + bArr[j];
                rightList[idx] = cArr[i] + dArr[j];
                idx++;
            }
        }

        Arrays.sort(leftList);
        Arrays.sort(rightList);

        int left = 0;
        int right = n * n - 1;

        while (left < n * n && right >= 0) {
            int leftSum = leftList[left];
            int rightSum = rightList[right];
            int sum = leftSum + rightSum;

            if (sum == 0) {
                long leftCnt = 0;
                long rightCnt = 0;

                while (left < n * n && leftSum == leftList[left]) {
                    leftCnt++;
                    left++;
                }

                while (right >= 0 && rightSum == rightList[right]) {
                    rightCnt++;
                    right--;
                }

                answer += leftCnt * rightCnt;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(answer);
    }
}
