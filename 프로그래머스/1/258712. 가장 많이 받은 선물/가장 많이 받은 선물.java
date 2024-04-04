import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] historyArr = new int[friends.length][friends.length];   // 선물 주고 받은 내역
        int[] presentNums = new int[friends.length];                    // 선물지수

        // 매칭을 위해 이름과 순서를 해시맵으로 저장
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<friends.length; i++) {
            map.put(friends[i], i);
        }

        // 주고 받은 것을 기록
        for (int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            int giverIndex = map.get(gift[0]);
            int receiverIndex = map.get(gift[1]);

            // 주고 받은 선물의 갯수
            historyArr[giverIndex][receiverIndex]++;
            
            // 선물지수
            presentNums[giverIndex]++;
            presentNums[receiverIndex]--;
        }

        // 다음달 받을 선물 개수 계산
        for(int i=0; i<historyArr.length; i++) {
            int presentCnt = 0;
            for(int j=0; j<historyArr[i].length; j++) {

                // 자기 자신은 패스
                if(i == j) continue;

                // i가 더 많은 선물을 주었거나,
                // 동일하게 주고 받았어도 i의 선물지수가 높은 경우 i가 받은 선물을 +1 해준다
                if(historyArr[i][j] > historyArr[j][i] 
                    || (historyArr[i][j] == historyArr[j][i] && presentNums[i] > presentNums[j]))
                    presentCnt++;
            }
            // 0이 아니고, 최댓값보다 크다면 정답 갱신
            if(presentCnt > 0 && answer < presentCnt) {
                answer = presentCnt;
            }
        }

        return answer;
    }
}