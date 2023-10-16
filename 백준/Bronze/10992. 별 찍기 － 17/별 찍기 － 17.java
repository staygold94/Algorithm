import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int i=1; i<num; i++) {
            for(int j=num-i; j>0; j--) {
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j=1; j<=2*i-3; j++) {
                System.out.print(" ");
            }
            if(i!=1) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1; i<=num*2-1; i++) {
            System.out.print("*");
        }
    }
}