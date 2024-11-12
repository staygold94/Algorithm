import java.util.*;
import java.io.*;

public class Main {
    public static int n, k, cnt, answer;
    public static int[] arr;
    public static int depth = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cnt = 0;
        answer = 0;
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        merge_sort(0, n-1);

        System.out.println(cnt < k ? -1 : answer);
    }

    public static void merge_sort(int p, int r) {
        if(p < r) {
            int q = (p + r) / 2;
            merge_sort(p, q);
            merge_sort(q + 1, r);
            merge(p, q, r);
        }
    }

    public static void merge(int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;
        int[] tmp = new int[r - p + 1];

        while(i <= q && j <= r) {
            if(arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        // 왼족 배열 부분이 남은 경우
        while(i <= q) {
            tmp[t++] = arr[i++];
        }

        // 오른쪽 배열 부분이 남은 경우
        while(j <= r) {
            tmp[t++] = arr[j++];
        }

        i = p;
        t = 0;

        // 결과를 arr 배열에 저장
        while(i <= r) {
            if(++cnt == k) {
                answer = tmp[t];
                return;
            }
            arr[i++] = tmp[t++];
        }
    }
}