import java.util.*;

class Solution {
    public Map<String, Integer> combiMap; // 조합 가능한 콤비
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for(int i=0; i<course.length; i++) {

            // 모든 문자로 만들 수 있는 조합 구하기
            combiMap = new HashMap<>();
            for(String order : orders) {
                generateCombi(new StringBuilder(), course[i], 0, order);
            }

            // 가능한 조합 중 가장 높은 빈도수 구하기
            int max = 2;
            for(Map.Entry<String, Integer> map : combiMap.entrySet()) {
                if(map.getValue() > max) {
                    max = map.getValue();
                }
            }

            // 가장 높은 빈도수에 해당 하는 경우 answer에 넣기
            for(Map.Entry<String, Integer> map : combiMap.entrySet()) {
                if(map.getValue() == max) {
                    answer.add(map.getKey());
                }
            }
        }

        // 사전순으로 오름차순 정렬
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    public void generateCombi(StringBuilder sb, int count, int index, String order) {

        // 재귀 탈출 조건
        // count만큼 조합이 만들어진 경우 조합을 저장하는 Map에 넣고 반환
        if(count == sb.length()) {
            // 조합 오름차순 정렬
            char[] arr = sb.toString().toCharArray();
            Arrays.sort(arr);
            String combi = new String(arr);

            // 조합 존재시 빈도 증가, 아닐시 1로 초기화
            combiMap.put(combi, combiMap.getOrDefault(combi, 0) + 1);
            return;
        }

        // 만들 수 있는 조합 재귀로 호출
        for(int i=index; i<order.length(); i++) {
            sb.append(order.charAt(i));
            generateCombi(sb, count, i + 1, order);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}