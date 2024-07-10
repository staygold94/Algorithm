import java.io.*;
import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Meeting> list = new ArrayList<>();

        // 회의 시간 저장
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }

        // 회의 빨리 끝나는 순대로 정렬
        // 끝나는 시간이 같다면 더 빨리 시작하는 거 먼저 정렬
        // => 이유 : 끝나는 시간이 같아도 늦게 시작하면 그 사이에 텀이 생겨서 다른 회의를 배치할 수 있는 기회가 사라짐
        list.sort((m1, m2) -> {
            if(m1.end != m2.end) {
                return m1.end - m2.end;
            } else {
                return m1.start - m2.start;
            }
        });

        int answer = 0;
        int time = 0;

        for(int i=0; i<list.size(); i++) {
            if(list.get(i).start >= time) {
                time = list.get(i).end;
                answer++;
            }
        }
        System.out.println(answer);
    }
}