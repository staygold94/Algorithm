import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int holder = 1;

        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            holder++;
            if(c == 'L') i++;
        }
        System.out.println(Math.min(holder, n));
    }
}