import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double prev = Double.parseDouble(br.readLine());
        double max = prev;

        for(int i=1; i<n; i++) {
            double num = Double.parseDouble(br.readLine());
            prev = Math.max((prev * num), num);
            max = Math.max(max, prev);
        }
        
        System.out.printf("%.3f\n", max);
    }
}