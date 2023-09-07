class Solution {
    public long solution(long n) {
        long answer = 0;
        
        // 제곱근이 int 캐스팅한 값과 동일하다면
        if(Math.sqrt(n) == (int)Math.sqrt(n))
            answer = (long)Math.pow(Math.sqrt(n)+1, 2.0);   // 제곱근+1를 제곱해준다.
        else
            answer = -1;
        
        return answer;
        
        // 해당 문제는 Math의 메서드 활용이 관건
        // Math.sqrt(n) : 제곱근 구하기, double 리턴
        // Math.pow(double, double) : 첫번째 변수를 몇배 제곱할지 두번째 변수에 넣는다. double 리턴
    }
}