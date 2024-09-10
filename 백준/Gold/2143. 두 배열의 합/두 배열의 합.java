import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] aArr = new long[a];
        List<Long> aDp = new ArrayList<>();
        for(int i=0; i<a; i++) {
            aArr[i] = Long.parseLong(st.nextToken());
        }

        int b = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] bArr = new long[b];
        List<Long> bDp = new ArrayList<>();
        for(int i=0; i<b; i++) {
            bArr[i] = Long.parseLong(st.nextToken());
        }

        dfs(aArr, aDp);
        dfs(bArr, bDp);

        Collections.sort(aDp);
        Collections.sort(bDp);

        int left = 0;
        int right = bDp.size() - 1;
        long answer = 0;

        while(left < aDp.size() && right >= 0) {
            long leftSum = aDp.get(left);
            long rightSum = bDp.get(right);
            long sum = leftSum + rightSum;

            if(sum == t) {
                long leftCnt = 0;
                long rightCnt = 0;

                while(left < aDp.size() && leftSum == aDp.get(left)) {
                    leftCnt++;
                    left++;
                }

                while(right >= 0 && rightSum == bDp.get(right)) {
                    rightCnt++;
                    right--;
                }
                answer += leftCnt * rightCnt;
            } else if(sum < t) {
                left++;
            } else {
                right--;
            }
            
        }

        System.out.println(answer);
    }

    public static void dfs(long[] arr, List<Long> list) {

        for(int i=0; i<arr.length; i++) {
            long sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                list.add(sum);
            }
        }
    }
}