import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int su = Integer.parseInt(br.readLine());   // 입력받을 수
        int num = Integer.parseInt(br.readLine());  // 필요한 수
        int[] arr = new int[su];
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받은 수를 배열에 넣기
        for(int i=0; i<su; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이중반복문으로 매칭해가며 두 숫자의 합이 num인 경우를 찾음
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] + arr[j] == num) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
