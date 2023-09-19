import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // bw.write("첫번재 변수를 입력하세요!");
        
        try {
            //System.out.println("첫번재 변수를 입력하세요");
        
            // 횟수 (1번째 변수)
            int num = Integer.parseInt(bf.readLine());

            //System.out.println("두번재 변수를 입력하세요");

            // char 배열 (2번째 변수 -> 배열로 변환)
            char[] arr = bf.readLine().substring(0,num).toCharArray();

            // 합계
            int answer = 0;

            for(char ch : arr) {
                answer += ch - 48;
            }

            System.out.println(answer);
        } catch (IOException e) {
            System.err.println("입력을 읽어오는 중 오류 발생 : " + e.getMessage());
        }
    }
}