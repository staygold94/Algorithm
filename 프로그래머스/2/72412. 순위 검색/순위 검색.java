import java.util.*;

class Solution {
    public HashMap<String, List<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        // 지원자 정보 - 경우의 수 저장
        for(int i=0; i<info.length; i++) {
            String[] parts = info[i].split(" ");
            String[] conditions = {parts[0], parts[1], parts[2], parts[3]};
            int score = Integer.parseInt(parts[4]);
            makeInfo(conditions, score, 0, "");
        }
        
        // 모든 리스트 정렬 (한 번만 수행)
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        // 요구사항과 일치하는 지원자 정보 저장
        for(int i=0; i<query.length; i++) {
            String[] parts = query[i].replaceAll(" and ", "").split(" ");
            String request = parts[0];                // 요구사항
            int score = Integer.parseInt(parts[1]);   // 요구점수
            int cnt = 0;    // 후보자수
            
            // 지원자 맵에 요청사항과 일치하는 key가 있는 경우
            if(map.containsKey(request)) {
                cnt = countInfo(request, score);    // 후보자 수를 리턴
            }
            answer[i] = cnt;
        }

        return answer;
    }

    // 지원자 정보를 경우의 수대로 저장
    public void makeInfo(String[] conditions, int score, int depth, String str) {
        if(depth == 4) {
            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>());    // map에 key 등록
            }
            map.get(str).add(score);                // list에 점수 추가
            return;
        }
        makeInfo(conditions, score, depth+1, str+conditions[depth]);
        makeInfo(conditions, score, depth+1, str+"-");
    }

    public int countInfo(String request, int score) {

        List<Integer> list = map.get(request);
        // Collections.sort(list);

        int left = 0;
        int right = list.size();

        while(left<right) {
            int mid = (left + right) / 2;
            int midScore = list.get(mid);
            if(score <= midScore) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return list.size() - left;
    }
}