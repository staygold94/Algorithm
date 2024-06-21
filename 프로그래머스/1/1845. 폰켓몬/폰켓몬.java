import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : nums) {
            set.add(i);
        }

        // 종류가 n/2보다 크면 종류 개수 : n/2
        // 종류가 n/2보다 작거나 같으면 종류 개수 : set.size
        return set.size() > nums.length/2 ? nums.length/2 : set.size();
    }
}