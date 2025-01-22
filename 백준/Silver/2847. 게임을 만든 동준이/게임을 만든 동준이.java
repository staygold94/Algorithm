import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int answer = 0;

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            for(int j=i; j>0; j--) {
                if(arr[j] <= arr[j-1]) {
                    int minus = arr[j-1] - arr[j] + 1;
                    arr[j-1] -= minus;
                    answer += minus;
                }
            }
        }
        System.out.println(answer);
    }
}