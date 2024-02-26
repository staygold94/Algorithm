import java.util.*;

class Solution {
    public static HashSet<Integer> set = new HashSet<>();   // 경우의 수를 담아둘 set (중복은 알아서 허용x)

    public int solution(String numbers) {
        int answer = 0;

        // 재귀호출을 통해 경우의 수를 set에 add
        recursive("", numbers);

        // set에 있는 수 중 소수인 경우 answer에 값을 더함
        for(int i:set) {
            if(isPrime(i)) answer++;
        }
        return answer;
    }

    public static void recursive(String comb, String others) {
        // 빈값이 아닌 경우 comb에 있는 값을 set에 넣어준다. 
        if(!comb.equals(""))
            set.add(Integer.parseInt(comb));

        // 숫자 하나에 하나씩 붙여가며 재귀호출하여 set에 add 해줌
        // ex) 1 
        for(int i=0; i<others.length(); i++) {
            recursive(String.valueOf(comb + others.charAt(i)), others.substring(0, i) + others.substring(i+1));
        }
    }

    public static boolean isPrime(int num) {
        // 2보다 작은 경우 소수가 아니므로 false 리턴
        if(num < 2)
            return false;

        // 2부터 제곱근까지 나눠지는 수가 있으면 false 리턴
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        // 위의 경우 해당하지 않는 경우 소수로 true 리턴
        return true;
    }
}