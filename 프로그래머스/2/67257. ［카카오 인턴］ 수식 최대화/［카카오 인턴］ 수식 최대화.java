import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;

        // 숫자와 연산자를 분리하여 저장
        List<Long> NumList = new ArrayList<>();
        List<Character> CharList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : expression.toCharArray()) {
            if(Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                NumList.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                CharList.add(ch);
            }
        }
        NumList.add(Long.parseLong(sb.toString())); // 마지막에 담아둔 숫자도 저장

        // 3가지 연산자로 만들수 있는 3! = 6가지 경우의 수
        char[][] operators = {
          {'+', '-', '*'}
          , {'+', '*', '-'}
          , {'-', '+', '*'}
          , {'-', '*', '+'}
          , {'*', '+', '-'}
          , {'*', '-', '+'}
        };

        // 경우의 수를 모두 돌려 절대값이 가장 큰 값이 정답이 된다
        for(char[] arr : operators) {
            long result = customCal(NumList, CharList, arr);
            answer = Math.max(Math.abs(result), answer);
        }

        return answer;
    }

    // 연산자 우선순위에 따른 계산
    public long customCal(List<Long> NumList, List<Character> CharList, char[] arr) {

        List<Long> tmpNumList = new ArrayList<>(NumList);
        List<Character> tmpCharList = new ArrayList<>(CharList);

        // 연산자 우선순위대로 반복문 실행
        for(int i=0; i<arr.length; i++) {
            // 쪼갠 연산자 갯수만큼 요소 접근
            for(int j=0; j<tmpCharList.size(); j++) {
                // 현재 연산자 우선순위와 일치시
                if(tmpCharList.get(j) == arr[i]) {
                    long result = calculate(tmpNumList.get(j), tmpNumList.get(j+1), arr[i]);
                    tmpNumList.set(j, result);  // 계산 값을 기존 위치에 업데이트
                    tmpNumList.remove(j+1);     // 더한 값은 지워준다
                    tmpCharList.remove(j);      // 사용한 연산자도 지워준다.
                    j--;                        // 연산자가 하나 지워졌으므로 인덱스도 뒤로 이동시켜준다.
                }
            }
        }
        return tmpNumList.get(0);
    }

    // 일반적인 계산 함수
    public long calculate(long x, long y, char op) {
        long sum = 0;

        switch (op) {
            case '+':
                sum = x + y;
                break;
            case '-':
                sum = x - y;
                break;
            case '*':
                sum = x * y;
                break;
        }
        return sum;
    }
}