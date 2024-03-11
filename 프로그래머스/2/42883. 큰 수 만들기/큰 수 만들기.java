class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        // 10개의 문자중 4개를 제거한다면 6개의 문자가 나올 것이다.
        // numbers.length() - k == 6만큼 반복문 돌려서
        // 각 조각들중 가장 큰 값만 뽑아낸다.
        for(int i=0; i<number.length() - k; i++) {
            char max = '0';
            // 이미 이전 i에서 큰값으로 뽑아낸 경우 제외되어야 하므로
            // j는 idx 값부터 보기 시작한다.
            // j값의 범위가 i+k까지인 이유는 4개를 제거한다면, 5개중에서 큰 값 1개를 보기 위함
            for(int j=idx; j <= i + k; j++) {
                if(number.charAt(j) == '9') {
                    max = number.charAt(j);
                    idx = j+1;  // 현재 i 조각에서 가장 큰 값 다음 인덱스 저장
                    break;
                }
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j+1;  // 현재 i 조각에서 가장 큰 값 다음 인덱스 저장
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}