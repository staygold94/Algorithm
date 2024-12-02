import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            set.add(num);
        }
        Integer[] sortedArr = set.toArray(new Integer[0]);
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<sortedArr.length; i++) {
            map.put(sortedArr[i] , i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(map.get(arr[i]) + " ");
        }
        System.out.println(sb.toString());
    }   
}