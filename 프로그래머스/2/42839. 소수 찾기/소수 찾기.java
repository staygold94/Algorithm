import java.util.*;

class Solution {
    public String[] nums;
    public Set<Integer> primes;
    public int solution(String numbers) {

        nums = numbers.split("");
        primes = new HashSet<>();

        boolean[] visited = new boolean[nums.length];
        dfs(visited, "");
        
        return primes.size();
    }

    public void dfs(boolean[] visited, String num) {

        if(!num.equals("") && isPrime(Integer.parseInt(num))) {
            primes.add(Integer.parseInt(num));
        }

        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(visited, num + nums[i]);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}