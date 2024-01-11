import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);

        // 들어온 배열을 stream에 넣는다
        int[][] answer = Arrays.stream(data)
        // ext를 기준으로 val_ext 보다 작은 값을 필터링 한다
        .filter(subArray -> subArray[map.get(ext)] < val_ext)
        // sort_by 기준으로 정렬한다.
        .sorted(Comparator.comparingInt(subArray -> subArray[map.get(sort_by)]))
        // 새로운 배열로 내보낸다.
        .toArray(int[][]::new);

        return answer;
    }
}