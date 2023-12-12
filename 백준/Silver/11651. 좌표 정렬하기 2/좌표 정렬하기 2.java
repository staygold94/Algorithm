import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); 
        int[][] arr = new int[n][2];
        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // !! Arrays.sort는 비교되는 반환값이 음수면 자리를 바꾼다. !!
        // !! 또한 comp와 같이 넘겨주는 파라미터 기준으로 비교 및 정렬을 할 수 있다. !!
        Arrays.sort(arr, comp);

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Compartor를 이용한 익명 객체
    static Comparator<int[]> comp = new Comparator<int[]>() {

        @Override
        public int compare(int[] o1, int[] o2) {

            // 만일 x 좌표가 같으면 y 좌표를 비교한다.
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }

    };

}

/*
 * 참고한 사이트
 * https://st-lab.tistory.com/243 (자바의 Comparable과 Comparator 이해)
 */