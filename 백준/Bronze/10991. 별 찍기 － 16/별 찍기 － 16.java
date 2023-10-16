import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int i=1; i<=num; i++) {
            for(int j=num-1; j>=i; j--) {
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++) {
                System.out.print("*");
                if(j!=i) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
