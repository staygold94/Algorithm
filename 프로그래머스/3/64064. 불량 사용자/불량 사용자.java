import java.util.*;

class Solution {
    public String[] userId; // user_id 배열
    public String[] bannedId; // banned_id 배열
    public Set<Set<String>> result; // 결과를 저장할 Set
    public int solution(String[] user_id, String[] banned_id) {
        
        userId = user_id; // user_id 배열 초기화
        bannedId = banned_id; // banned_id 배열 초기화
        result = new HashSet<>(); // 결과를 저장할 Set 초기화

        // 백트래킹 함수 호출
        BT(new HashSet<>(1), 0);

        // 결과 Set의 크기를 반환
        return result.size();
    }

    public void BT(HashSet<String> set, int depth) {

        // set에 불량사용자 목록이 모두 담겼을 때
        if(set.size() == bannedId.length) {
            result.add(new HashSet<>(set)); // 결과 Set에 추가
            return; // 종료
        }

        // user_id 배열을 순회하며 백트래킹 수행
        for(int i=0; i<userId.length; i++) {
            if(set.contains(userId[i])) continue;   // 이미 set에 담긴 경우 건너뜀
            if(isBan(userId[i], bannedId[depth])) { // 위반자인 경우
                set.add(userId[i]); // set에 추가
                BT(set, depth + 1); // 다음 불량 사용자로 재귀 호출
                set.remove(userId[i]); // 백트래킹 수행 후 set에서 제거
            }
        }
    }

    public boolean isBan(String user, String ban) {

        if(user.length() != ban.length()) return false; // 길이가 다르면 false 반환

        // 정규식을 사용하여 패턴이 일치하는지 확인
        if(user.matches(ban.replaceAll("\\*", "."))) {
            return true;
        }
        return false;
    }
}
