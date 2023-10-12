import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] months = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<month; i++) {
            sum += days[i-1];
        }
        sum += day;
        System.out.println(months[sum%7]);
    }
}
