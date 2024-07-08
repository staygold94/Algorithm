import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[10];
        int sum = 0;
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            int num = str.charAt(i) - '0';
            arr[num]++;
            sum += num;
        }

        if(sum % 3 == 0 && str.contains("0")) {
            for(int i=arr.length-1; i>=0; i--) {
                while(arr[i] > 0) {
                    sb.append(i);
                    arr[i]--;
                }
            }
            answer = sb.toString();
        } else {
            answer = "-1";
        }
        
        System.out.println(answer);
    }
}