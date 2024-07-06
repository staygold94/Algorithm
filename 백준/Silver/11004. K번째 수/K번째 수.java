import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] test = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 초기화 배열
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 정렬
        Arrays.sort(arr);

        // K번째 수 출력
        System.out.println(arr[test[1]-1]);
    }
}