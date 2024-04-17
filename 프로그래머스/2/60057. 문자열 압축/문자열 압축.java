class Solution {
    public int solution(String s) {
        int minLen = Integer.MAX_VALUE;

        // 문자열의 길이가 1인 경우 반복문 타지 않고 바로 1 리턴
        if(s.length() == 1) return 1;

        for(int i=1; i<=s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String preStr = ""; // 이전 문자열
            int cnt = 1;        // 반복된 개수
            for(int j=0; j<s.length(); j += i) {
                String str = s.substring(j, Math.min(j+i, s.length()));
                // 이전 문자열과 같은 경우
                if(preStr.equals(str)) {
                    cnt++;

                // 이전 문자열과 다른 경우
                } else {
                    // 이전 문자열이 비어있지 않은 경우 (처음 반복문 접근 제외)
                    if(!preStr.equals("")) {
                        sb.append(cnt == 1 ? preStr : cnt + preStr);
                    }
                    cnt = 1;
                    preStr = str;
                }
            }
            // 반복문이 종료된 후 마지막 남은 문자열까지 담아준다
            if(!preStr.equals("")) {
                sb.append(cnt == 1 ? preStr : cnt + preStr);
            }

            // 문자열의 길이가 가장 짧다면 정답 갱신
            if(sb.length() < minLen) {
                minLen = sb.length();
            }
        }
        return minLen;
    }
}