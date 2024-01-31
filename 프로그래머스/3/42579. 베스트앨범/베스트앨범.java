import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        // 장르별로 누적 재생횟수 저장
        for(int i=0; i<genres.length; i++) {
            map.put(genres[i],
                    (map.containsKey(genres[i]) ? map.get(genres[i]) + plays[i] : plays[i]));
        }

        // 내림차순 장르 정렬한 list 생성
        ArrayList<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (o1, o2) -> map.get(o2) - map.get(o1));

        // 장르별로 상위 2개 추출
        for(String s:keySet) {
            HashMap<Integer, Integer> tmp = new HashMap<>();
            for(int i=0; i<genres.length; i++) {
                if(genres[i].equals(s)) {
                    tmp.put(i, plays[i]); // 고유 번호와 재생횟수 저장
                }
            }
            // 내림차순 재생횟수 정렬한 list 생성
            ArrayList<Integer> tmpList = new ArrayList<>(tmp.keySet());
            Collections.sort(tmpList, (o1, o2) -> tmp.get(o2) - tmp.get(o1));

            // 1개 초과시 2개를 넣어준다.
            answer.add(tmpList.get(0));
            if(tmpList.size() > 1) answer.add(tmpList.get(1));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}