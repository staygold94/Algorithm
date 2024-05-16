import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] arr = s.split("");
        Arrays.sort(arr, Comparator.reverseOrder());

        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}