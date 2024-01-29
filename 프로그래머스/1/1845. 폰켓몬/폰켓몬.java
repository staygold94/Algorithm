import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;   // 가지고 갈 수 있는 최대 종류 (다 다른 걸 고른다면)

        Set<Integer> set = new HashSet<>();
        for(int i:nums) {
            set.add(i);
        }

        return set.size() > max ? max : set.size();
    }
}