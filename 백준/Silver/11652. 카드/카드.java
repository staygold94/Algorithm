import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 숫자 카드의 범위가 -2e62~2e62 이므로 long 타입이 필요하고,
        // 배열의 경우 너무 많은 메모리가 필요하기 때문에 HashMap으로 풀어본다.
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();

        for(int i=0; i<n; i++) {
            long num = Long.parseLong(br.readLine());

            // 이미 저장된 카드값이라면
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else { // 처음 저장한다면
                map.put(num, 1);
            }
        }
        
        br.close();
        
        int max_cnt = 0;    // 가장 많이 가지고 있는 수
        long low_num = 0;   // 가장 많이 가지고 있는 수 중 가장 작은 수

        // 저장된 모든 키를 얻는 keySet() 메서드
        for(long key : map.keySet()) {
            if (map.get(key) == max_cnt) {
                if (key < low_num)
                low_num = key;
            } else if (map.get(key) > max_cnt) {
                max_cnt = map.get(key);
                low_num = key;
            }
        }
        System.out.println(low_num);
        
    }
}

/*
 * 참고하면 좋은 사이트
 * https://janeljs.github.io/algorithms/bj-11652-card/
 */