import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        // 커맨드 원소의 개수만큼 반환할 배열의 크기를 선언한다.
        int count = commands.length;
        int[] answer = new int[count];

        // 커맨드 원소의 개수만큼 반복문 돌면서 k번째 수를 찾고, 배열에 넣는다.
        for(int i=0; i<count; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            int result = quickSelect(arr, 0, arr.length-1, commands[i][2]-1);
            answer[i] = result;
        }

        return answer;
    }

    public static int quickSelect(int[] arr, int left, int right, int k) {

        if(left <= right) {
            int pivot = partition(arr, left, right);

            if(pivot == k) {
                return arr[pivot];
            } else if (pivot < k) {
                return quickSelect(arr, pivot + 1, right, k);
            } else {
                return quickSelect(arr, left, pivot - 1, k);
            }
        }
        return -1;
    }

    public static int partition(int[] arr, int left, int right) {

        int mid = arr[(left + right) / 2];

        while(left < right) {
            while(arr[left] < mid) {
                left++;
            }
            while(mid < arr[right]) {
                right--;
            }
            swap(arr, left, right);
                                                  
        }
        return left;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        Solution solve = new Solution();
        int[] answer = solve.solution(array, commands);

        for(int i : answer) {
            System.out.print(i + " ");
        }
    }
}


