import java.io.*;

public class Main {
    public static int answer = 0;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n , 1, 2, 3);

        System.out.println(answer);
        System.out.print(sb.toString());
    }

    public static void hanoi(int depth, int start, int mid, int target) {

        if(depth == 1) {
            sb.append(start + " " + target + "\n");
            answer++;
            return;
        }

        // 마지막 원반을 제외하고 임시기둥으로 이동시킨다.
        hanoi(depth - 1, start, target, mid);

        // 마지막 원반을 목표 기둥으로 옮긴다.
        sb.append(start + " " + target + "\n");
        answer++;

        // 임시 기둥에 있는 원반을 목표 기둥으로 옮긴다.
        hanoi(depth - 1, mid, start, target);
    }
}