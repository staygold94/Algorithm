import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 음수를 반환하면 첫 번째 인자가 두 번째 인자보다 작음을 의미합니다.
        // 0을 반환하면 두 인자가 서로 같음을 의미합니다.
        // 양수를 반환하면 첫 번째 인자가 두 번째 인자보다 큼을 의미합니다.

        Arrays.sort(arr, (o1, o2) -> ((o2 + o1).compareTo(o1 + o2)));

        // 9, 5 -> 59 95
        // 음수 반환
        // 첫번째 인자가 더 작다고 판단하여 정렬 앞으로 옴 

        for(int i=0; i<numbers.length; i++) {
            sb.append(arr[i]);
        }
        return (arr[0].equals("0") ? "0" : sb.toString());
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] numbers = {3, 30, 34, 5, 9};
        String answer = sol.solution(numbers);

        System.out.println(answer);
    }
}