import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 변수 (과목수)
        Double[] arr = new Double[Integer.parseInt(br.readLine())];

        // 두번째 변수 (과목별 점수 입력 -> 배열로 변환)
        String[] tmp = br.readLine().split(" ");
        double maxVal = 0;    // 가장 높은 점수
        double answer = 0;    // 반환값

        // int 배열로 변환, 가장 높은 점수 찾기
        for(int i=0; i<arr.length; i++) {
            arr[i] = Double.parseDouble(tmp[i]);
            if(maxVal < arr[i]) maxVal = arr[i];
        }

        for(int i=0; i<arr.length; i++) {
            arr[i] = arr[i] / maxVal * 100;
            answer += arr[i];
        }

        System.out.println(answer / arr.length);
    }
}
