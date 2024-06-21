class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        // 길이 만큼 sb에 append
        for(int i=0; i<number.length(); i++) {

            // 제거할 숫자가 남아있고,
            // sb가 비어있지 않고,
            // 들어올 숫자가 더 큰 경우
            while(cnt < k
                    && sb.length() > 0
                    && sb.charAt(sb.length() - 1) < number.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
                cnt++;
            }
            sb.append(number.charAt(i));
        }

        // 제거할 문자가 남아있는 경우
        while(cnt < k) {
            sb.deleteCharAt(sb.length() - 1);
            cnt++;
        }

        return sb.toString();
    }
}