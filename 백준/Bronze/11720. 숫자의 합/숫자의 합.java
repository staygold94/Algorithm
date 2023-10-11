import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().substring(0,num).toCharArray();

        int answer = 0;

        for(char ch : arr) {
            answer += ch - 48;
        }

        System.out.println(answer);
    } 
}
