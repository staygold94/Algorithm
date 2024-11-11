import java.io.*;

public class Main {
    public static String[] arr;
    public static boolean isValid;
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            arr = br.readLine().split("");
            isValid = true;
            cnt = 0;
            isPalindrome(0, arr.length-1);
            sb.append((isValid ? 1 : 0) + " " + cnt + "\n");
        }

        System.out.print(sb.toString());
    }

    public static void isPalindrome(int l, int r) {

        // 호출횟수 카운트
        cnt++;

        if(l >= r) {
            return;
        }

        if(!arr[l].equals(arr[r])) {
            isValid = false;
            return;
        } else {
            isPalindrome(l+1, r-1);
        }
    }
}
