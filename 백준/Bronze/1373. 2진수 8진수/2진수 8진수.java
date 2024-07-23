import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        // 2진수의 3자리는 0~7까지 나타낼 수 있음 == 8진수 1자리로 나타낼 수 있는 수와 같음

        // 1자리가 남는 경우
        if(n.length() % 3 == 1) {
            sb.append(n.charAt(0));
        }

        // 2자리가 남는 경우
        if(n.length() % 3 == 2) {
            int num = (n.charAt(0) - '0') * 2 + (n.charAt(1) - '0');
            sb.append(num);
        }

        // 나머지수 구하기
        for(int i=n.length() % 3; i<n.length(); i+=3) {
            int num = (n.charAt(i) - '0') * 4 + (n.charAt(i+1) - '0') * 2 + (n.charAt(i+2) - '0');
            sb.append(num);
        }

        System.out.println(sb.toString());
    }
}