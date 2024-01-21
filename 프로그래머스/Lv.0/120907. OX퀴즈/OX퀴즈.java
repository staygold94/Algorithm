class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for(int i=0; i<quiz.length; i++) {
            
            String[] arr = quiz[i].split(" ");  // String 수식을 배열로 저장
            int num1 = Integer.parseInt(arr[0]);
            int num2 = Integer.parseInt(arr[2]);
            int sum = Integer.parseInt(arr[4]);

            // 연산자에 따라 수식 분기
            if(arr[1].equals("+")) {
                answer[i] = (num1 + num2 == sum ? "O" : "X");
            } else {
                answer[i] = (num1 - num2 == sum ? "O" : "X");
            }
        }
        return answer;
    }
}