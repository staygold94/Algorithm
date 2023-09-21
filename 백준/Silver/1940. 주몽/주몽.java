import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int su = Integer.parseInt(br.readLine());   // 입력받을 수
        int num = Integer.parseInt(br.readLine());  // 필요한 수
        int[] arr = new int[su];
        int s_idx = 0;
        int e_idx = su-1;
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받은 수를 배열에 넣기
        for(int i=0; i<su; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투포인터로 이동하기 위해서 배열을 정렬해준다
        Arrays.sort(arr);

        // *** 포인터를 움직여가며 num 값을 찾는다 ***
        while(s_idx < e_idx) {
            int sum = arr[s_idx] + arr[e_idx];
            if(sum < num) {
                s_idx++;
            } else if (sum == num) {
                // 합이 일치하는 경우 이미 써버린 인덱스는 변경해준다
                cnt++;
                s_idx++;
                e_idx--;
            } else {
                e_idx--;
            }
        }
        System.out.println(cnt);
    }
}
