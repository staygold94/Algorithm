import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // StringBuilder로는 reverse 메서드가 있다.
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(sb.append(st.nextToken()).reverse().toString());

        // StringBuilder 초기화 방법 : 길이를 0으로 지정
        sb.setLength(0);
        int b = Integer.parseInt(sb.append(st.nextToken()).reverse().toString());

        System.out.println(a > b ? a : b);
    }
}