import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 0이 아닌 경우
        if(n != 0) {
            // 나눌 값이 1이 아닌 경우
            while(n != 1) {
                sb.append(Math.abs(n%-2));
                n = (int) Math.ceil((double)n/-2);
            }   
        }
        // 0인 경우 0이 INSERT
        // 1인 경우 마지막 나머지 INSERT
        sb.append(n);
        System.out.println(sb.reverse());
    }
}