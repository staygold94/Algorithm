import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int depth = 1;
        int max = 1;

        while(true) {
            if(n <= max) {
                System.out.println(depth);
                break;
            }
            max += 6*depth;
            depth++;
        }
    }
}