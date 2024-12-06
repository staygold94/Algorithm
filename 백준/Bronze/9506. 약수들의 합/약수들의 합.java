import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int num = Integer.parseInt(br.readLine());

            if(num == -1) break;

            int sum = 0;
            StringBuilder tmp = new StringBuilder();
            for(int i=1; i<num; i++) {
                if(num % i == 0) {
                    if(tmp.length() == 0) tmp.append(i);
                    else tmp.append(" + " + i);
                    sum += i;
                }
            }
            if(sum == num) {
                sb.append(num + " = " + tmp + "\n");
            } else {
                sb.append(num + " is NOT perfect.\n");
            }
        }
        System.out.print(sb.toString());
    }
}