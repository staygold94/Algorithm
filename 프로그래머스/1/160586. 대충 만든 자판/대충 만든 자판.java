class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];     // target 길이의 결과 배열
        int[] alphabet = new int[26];               // 알파벳 입력 최솟값 배열

        for(int i=0; i < keymap.length; i++) {
            
            char[] arr = keymap[i].toCharArray();
            
            // 키맵 반복문 돌며 각 알파벳을 입력하기 위한 최솟값을 배열에 담는다
            for(int j=0; j<arr.length; j++) {
                // 초기값이거나 더 적은 횟수로 눌러도 되는 경우
                if(alphabet[arr[j] - 65] == 0 || alphabet[arr[j] - 65] > j+1)
                alphabet[arr[j] - 65] = j+1;
            }
        }

        for(int i=0; i<targets.length; i++) {

            char[] arr = targets[i].toCharArray();
            int sum = 0;

            for(int j=0; j<arr.length; j++) {
                
                if(alphabet[arr[j]-65] != 0) {
                    sum += alphabet[arr[j]-65];
                } else {
                    sum = -1;
                    break;
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}