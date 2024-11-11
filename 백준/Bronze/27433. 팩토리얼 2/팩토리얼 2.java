import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 1;

        for(int i=n; i>0; i--){
            answer *= i;
        }
    
        System.out.println(answer);
    }
}