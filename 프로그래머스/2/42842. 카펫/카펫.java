class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x,y;

        for(int i=3; i<=(brown+yellow)/3; i++) {
            x = i;
            y = (brown+yellow)/i;
            if(x * y == brown + yellow && x + y == (brown+4) / 2) {
                answer[0] = Math.max(x, y);
                answer[1] = Math.min(x, y);
                break;
            }
        }
        return answer;
    }
}