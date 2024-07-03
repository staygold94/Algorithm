import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] cards = {"P", "K", "H", "T"};
        HashMap<String, int[]> map = new HashMap<>();
        for(int i=0; i<cards.length; i++) {
            map.put(cards[i], new int[13]);
        }

        for(int i=0; i<s.length(); i+=3) {
            String key = s.substring(i, i+1);
            int idx = Integer.parseInt(s.substring(i+1, i+3)) - 1;
            int[] arr = map.get(key);

            // 이미 카드가 있다면
            if(arr[idx] == 1) {
                sb.append("GRESKA");
                break;
            } else {
                arr[idx] += 1;
            }
        }

        // 이미 카드가 있는 경우를 제외하고
        // 찾지 못한 카드 카운팅
        if(!sb.toString().equals("GRESKA")) {
            for(String card : cards) {
                int[] arr = map.get(card);
                int cnt = 0;
                for(int i=0; i<arr.length; i++) {
                    if(arr[i] == 0) cnt++;
                }
                sb.append(cnt + " ");
            }
        }

        System.out.println(sb.toString());
    }
}
