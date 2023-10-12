import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int max = -1000000;    // 문제 범위로 초기값 지정
        int min = 1000000;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<num; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp > max) max = tmp;
            if(tmp < min) min = tmp;
        }

        System.out.println(min + " " + max);

        /* 버블 정렬 해보려고 했으나 보기 좋게 시간 초과 
        int[] arr = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 버블정렬
        for(int i=0; i<num-1; i++) {
            for(int j=i; j<num-1; j++) {
                int tmp = 0;
                if(arr[i] > arr[j+1]) {
                    tmp = arr[i];
                    arr[i] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        System.out.println(arr[0] + " " + arr[num-1]);
        */
    }
}
