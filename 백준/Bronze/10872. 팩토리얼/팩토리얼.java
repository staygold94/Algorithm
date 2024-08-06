import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 1;
        int n = Integer.parseInt(br.readLine());

        // 팩토리얼을 계산할 필요 없는 경우
        if(n == 0 || n == 1) {
            System.out.println(1);
            return;
        }

        // 계산해봅시다!
        for(int i=2; i<=n; i++) {
            answer *= i;
        }

        System.out.println(answer);
    }
}