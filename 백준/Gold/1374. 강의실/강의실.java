import java.util.*;
import java.io.*;

public class Main {

    static class Lecture implements Comparable<Lecture> {
        int no, start, end;

        public Lecture(String[] tmp) {
            this.no = toInt(tmp[0]);
            this.start = toInt(tmp[1]);
            this.end = toInt(tmp[2]);
        }

        public int compareTo(Lecture o) {
            if(this.start == o.start) return this.end - o.end;
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Lecture[] arr = new Lecture[n];

        for(int i=0; i<n; i++) {
            arr[i] = new Lecture(br.readLine().split(" "));
        }

        // 시작 빠른 순서대로 정렬
        Arrays.sort(arr);

        // 강의실 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            // 진행중인 강의가 없는 경우
            if(queue.isEmpty()) {
                queue.offer(arr[i].end);
            // 바톤터치할 강의실이 없는 경우
            } else if(arr[i].start < queue.peek()) {
                queue.offer(arr[i].end);
            // 들어갈 수 있는 강의실이 있는 경우 (기존 빼고 들어가기)
            } else {
                queue.poll();
                queue.offer(arr[i].end);
            }
        }
        System.out.println(queue.size());
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }
}