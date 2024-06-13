class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        // 내가 구현할 키패드
        // 0 1 2    -> 몫 0
        // 3 4 5    -> 몫 1
        // 6 7 8    -> 몫 2
        // 9 10 11  -> 몫 3
          
        // 0 1 2 (각 열의 나머지)

        int leftIdx = 9;
        int rightIdx = 11;
        for(int i=0 ;i<numbers.length; i++) {
            int num = numbers[i] == 0 ? 10 : numbers[i] - 1;
            // 왼쪽
            if(num % 3 == 0) {
                leftIdx = num;
                sb.append("L");
            // 오른쪽
            } else if(num % 3 == 2) {
                rightIdx = num;
                sb.append("R");
            // 중간
            } else {
                // 세로(출발지 몫 - 도착지 몫) + 가로(같은 열이 아닌 경우 1 더함)
                int lNum = Math.abs(leftIdx/3 - num/3) + (leftIdx % 3 != num % 3 ? 1 : 0);
                int rNum = Math.abs(rightIdx/3 - num/3) + (rightIdx % 3 != num % 3 ? 1 : 0);
                if(lNum < rNum) {
                    leftIdx = num;
                    sb.append("L");
                } else if(lNum > rNum) {
                    rightIdx = num;
                    sb.append("R");
                } else {
                    if(hand.equals("left")) {
                        leftIdx = num;
                        sb.append("L");
                    } else {
                        rightIdx = num;
                        sb.append("R");
                    }
                }
            }
        }

        return sb.toString();
    }
}