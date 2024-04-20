class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")) {
            int len = s.length();
            s = s.replaceAll("0", "");
            answer[0]++;
            answer[1] += len - s.length();  // 기존 길이 - 바뀐 길이 = 바꾼 갯수
            s = Integer.toBinaryString(s.length());
        }

        return answer;
    }
}