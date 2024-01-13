class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int max = health;   // 최대 체력
        int time = attacks[attacks.length-1][0];    // 마지막 공격시간
        int nowCnt = 0;     // 연속 성공 횟수 (초기값 0)
        int idx = 0;        // attacks 인덱스

        for(int i=1; i<=time; i++) {
            // 몬스터 공격 시간이라면
            if(i == attacks[idx][0]) {
                nowCnt = 0;
                health -= attacks[idx][1];
                idx++;
            // 몬스터가 공격하지 않는다면
            } else {
                // 최대 체력이 아닌 경우에
                if(health < max) {
                    health += bandage[1];
                    nowCnt++;

                    if(nowCnt == bandage[0]) {
                        health += bandage[2];
                        nowCnt = 0;
                    }

                    // 최대 체력을 초과하는 경우 최대 체력으로 변환
                    health = (health > max) ? max : health;
                }
            }
            // 체력이 0 이하로 떨어진 경우 반복문 탈출
            if(health <= 0) break;
        }

        // 체력이 0이하로 떨어진다면 -1 반환
        return (health <= 0 ? -1 : health);
    }
}