import java.util.*;

class Solution {
    public static int[] parent;

    public static int find(int a) {
        // 현재 노드와 부모노드가 동일하지 않으면 재귀로 찾는다
        if(parent[a] != a) {
            return find(parent[a]);
        } else {
            return a;
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    // 크루스칼 알고리즘을 이용한 풀이
    public int solution(int n, int[][] costs) {
        int answer = 0;

        // 비용 기준으로 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        // 부모 노드를 담는 배열 생성
        parent = new int[n];

        // 기본값은 아무것도 연결되어 있지 않으므로 자기 자신을 값으로 갖는다.
        for(int i=0; i<parent.length; i++) {
            parent[i] = i;
        }

        // 비용이 낮은 순으로 다리를 만들어간다.
        for(int i=0; i<costs.length; i++) {
            // 같은 부모가 아닌 경우(이어져 있지 않은 경우)
            if(find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);    // 유니온 해주고
                answer += costs[i][2];   // 
            }
        }

        return answer;
    }
}