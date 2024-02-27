class Solution {
    public int[] solution(int brown, int yellow) { // x, y
        int[] answer = new int[2];
        int sum = brown + yellow;   // i * j = x + y
        
        // yellow가 존재하려면 x의 값이 최소 3이상이어야 한다.
        for(int x=3; x <= sum/3; x++) {
            int y = sum / x;
            
            // 각 모서리를 더하는 것을 떠올려 다음 수식이 도출가능 -> x + y = (i + 4) / 2
            if(sum % x == 0 && x + y == (brown + 4)/2) {
                answer[0] = x;
                answer[1] = y;
            }
        }
        return answer;
    }
}