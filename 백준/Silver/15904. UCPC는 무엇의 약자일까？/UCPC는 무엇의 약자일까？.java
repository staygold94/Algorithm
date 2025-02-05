import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean answer = true;

        char[] arr = {'U', 'C', 'P', 'C'};
        for(int i=0; i<4; i++) {
            if(s.indexOf(arr[i]) > -1) {
                s = s.substring(s.indexOf(arr[i]) + 1);
            } else {
                answer = false;
                break;
            }
        }
        System.out.println(answer ? "I love UCPC" : "I hate UCPC");
    }
}