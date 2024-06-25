import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (s1, s2) -> (s2+s1).compareTo(s1+s2));

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
            if(i == 0 && arr[i].equals("0")) break;
        }
        
        return sb.toString();
    }
}