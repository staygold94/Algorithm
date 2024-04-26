import java.util.*;

class Solution {
    List<int[]> list;
    public int[][] solution(int n) {
        int[][] answer = {};

        // 정답을 담을 list
        list = new ArrayList<>();

        Hanoi(n, 1, 3, 2);

        return list.toArray(new int[0][2]);
    }

    public void Hanoi(int n, int from, int to, int mid) {

        // 만약 1이라면 바로 to로 가면 된다
        if(n == 1) {
            list.add(new int[] {from, to});
            return;
        }

        // 맨마지막을 제외한 원판들을 보조 원판으로 옮긴다
        Hanoi(n-1, from, mid, to);

        // 맨마지막 원판을 목적지로 옮긴다
        list.add(new int[] {from, to});

        // 보조원판에 있던 것을 목적지로 옮긴다
        Hanoi(n-1, mid, to, from);
        
    }
}