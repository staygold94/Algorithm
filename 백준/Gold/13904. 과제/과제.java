import java.util.*;
import java.io.*;

public class Main {
    static class Work {
        int day, score;

        Work(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = toi(br.readLine());
        List<Work> list = new ArrayList<>();
        int maxDay = -1;

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = toi(st.nextToken());
            int s = toi(st.nextToken());
            list.add(new Work(d, s));
            maxDay = Math.max(maxDay, d);
        }

        int totalScore = 0;
        for(int i=maxDay; i>=1; i--) {

            // 가장 높은 점수와 인덱스
            int idx = -1;
            int maxScore = -1;

            // 리스트 돌면서 수행 가능한 최대 점수 찾기
            for(int j=0; j<list.size(); j++) {
                
                Work w = list.get(j);

                // 수행 가능한 날짜이며, 가장 높은 점수인 경우
                if(i <= w.day && maxScore < w.score) {
                    idx = j;
                    maxScore = w.score;
                }
            }

            // 수행 가능한 게 없는 경우
            if(idx == -1) continue;

            totalScore += maxScore;     // 점수 업데이트
            list.remove(idx);           // 해당 인덱스 삭제 (이미 수행했으므로)
        }
        System.out.println(totalScore);
    }

    public static int toi(String s) {
        return Integer.parseInt(s);
    }
}