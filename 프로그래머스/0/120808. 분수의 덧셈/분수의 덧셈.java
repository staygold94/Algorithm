class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // 분모와 분자를 담을 배열 선언
        int[] answer = new int[2];
        int GCD = findGCD(denom1 > denom2 ? denom1 : denom2, denom1 < denom2 ? denom1 : denom2 );   // 최대공약수
        int LCM = denom1 * denom2 / GCD;                                                            // 최소공배수

        answer[0] = (LCM / denom1) * numer1 + (LCM / denom2) * numer2;
        answer[1] = LCM;

        // 결과값이 약분 가능한지 최대공약수 조회 (1이 아니면 약분 가능)
        int answerGCD = findGCD(answer[0] > answer[1] ? answer[0] : answer[1], answer[0] < answer[1] ? answer[0] : answer[1]);

        if(answerGCD != 1) {
            answer[0] = answer[0] / answerGCD;
            answer[1] = answer[1] / answerGCD;
        }
        
        return answer;
    }

    // 유클리드 호제법에 의한 최대공약수 찾는 메서드
    public static int findGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    /*
    # 유클리드 호제법
    12와 18이 있다면 큰수에서 작은수를 나누어 최대공약수를 구한다. (논밭을 정사각형으로 자른다고 생각하기)
    아래 예시를 보면 재귀방식 전개를 더 잘 이해할 수 있다.

    A    B   A%B
    18 % 12 = 6

    B   A%B
    12 % 6 = 0

    6 % 0 -> 이때 A 값을 리턴
     */
}