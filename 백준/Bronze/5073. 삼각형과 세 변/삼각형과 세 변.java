import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            int[] arr = new int[3];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }

            // 정렬
            Arrays.sort(arr);
            
            if(arr[0] + arr[1] <= arr[2]) {
                System.out.println("Invalid");
            } else if(arr[0] == arr[1] && arr[1] == arr[2]) {
                System.out.println("Equilateral");
            } else if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
