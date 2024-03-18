import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        // 문제는 최솟값을 8 초과인 경우 -1 리턴을 요구함
        // 1부터 8까지 담을 것
        Set<Integer>[] set = new Set[9];
        int tmp = N;

        // i 개수로 만들 수 있는 숫자를 담자
        for(int i=1; i<9; i++) {
            set[i] = new HashSet<Integer>();
            // N을 사용해서 만들 수 있는 조합 저장
            // ex) N이 5인 경우, i가 1일 때 5 저장, i가 2일 때 55 저장
            set[i].add(tmp);
            tmp = tmp * 10 + N;
        }

        // 만들 수 있는 갯수
        for(int i=1; i<9; i++) {
            for(int j=1; j<i; j++) {
                // 기존 값들의 조합으로 만들자. i가 5면 j는 
                for(Integer x:set[j]) {
                    for(Integer y:set[i-j]) {
                        set[i].add(x+y);
                        set[i].add(x-y);
                        set[i].add(y-x);
                        set[i].add(x*y);
                        if(x != 0) set[i].add(y/x);
                        if(y != 0) set[i].add(x/y);
                    }
                }
            }
        }

        // number를 가진 set이 있으면 해당 키 값인 i 리턴
        for(int i=1; i<9; i++) {
            if(set[i].contains(number)) {
                return i;
            }
        }

        return -1;  // 없을시 -1 리턴
    }
}