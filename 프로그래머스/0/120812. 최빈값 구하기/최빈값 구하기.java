class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max = 0;
        int[] alpha = new int[1000]; // 0부터 999를 저장

        // 들어온 배열만큼 count 더함
        for(int i=0; i<array.length; i++) {
            alpha[array[i]]++;
            if(max < alpha[array[i]]) { 
                max = alpha[array[i]];
                answer = array[i];
            }
        }

        int tmp = 0;    // 최빈값이 몇개인지
        for(int i=0; i<alpha.length; i++) {

            if(max == alpha[i]) tmp++;
            if(tmp > 1) answer = -1;
        }
        return answer;
    }
}