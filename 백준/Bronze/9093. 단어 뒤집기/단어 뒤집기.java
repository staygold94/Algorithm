import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int k=0; k<n; k++) {
            String[] arr = br.readLine().split(" ");

            for(int i=0; i<arr.length; i++) {
                for(int j=arr[i].length() - 1; j>=0; j--) {
                    sb.append(arr[i].charAt(j));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}