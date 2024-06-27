import java.util.*;

class Solution {
    HashSet<Integer> set;
    public int solution(String numbers) {
        set = new HashSet<>();  // 소수

        // numbers 배열화
        String[] arr = numbers.split("");
        // 방문경로 초기화
        boolean[] visited = new boolean[arr.length];

        dfs(arr, visited, 0, "");

        return set.size();
    }

    public void dfs(String[] arr, boolean[] visited, int depth, String str) {

        if(!str.equals("") && isPrime(Integer.parseInt(str))) {
            set.add(Integer.parseInt(str));
            System.out.println(str);
        }

        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(arr, visited, depth+1, str + arr[i]);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int num) {
        // 소수는 1과 자신으로 나눠져야 한다. 고로 2보다 작으면 false
        if(num < 2) {
            return false;
        }

        // 2부터 제곱근 전까지 나눠지는지 확인, 나눠지면 false
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }

        return true;
    }
}