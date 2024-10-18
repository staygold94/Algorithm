import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int answer = 0;

        /*
            합분해 문제의 key!!!
            더할 수 있는 합의 최대치 : 자릿수 * 9
            만약 세 자리 수라면 9 + 9 + 9 = 27이 최대 더할 수 있는 수이다.
            즉 n - 27부터 합분해 범위에 들어오는 것. 그리고 n보다 작은 수까지 순회한다.
        */ 
        for(int i=n - 9*s.length(); i<n; i++) {
            int sum = i + getSum(i);
            if(sum == n) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    public static int getSum(int n) {

        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}