import java.util.*;
import java.io.*;

public class Main {
    public static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int idx = findIdx(arr[i]);

            if(idx < list.size()) {
                list.set(idx, arr[i]);
            } else {
                list.add(arr[i]);
            }
        }

        System.out.println(list.size());
    }

    public static int findIdx(int num) {

        int left = 0;
        int right = list.size() - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int tmp = list.get(mid);

            if(tmp < num) {
                left = mid + 1;

            // 이때 tmp값이 num을 만족하게 되는데, 추가적으로 right의 이동이 있으므로 리턴은 left로 함
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}