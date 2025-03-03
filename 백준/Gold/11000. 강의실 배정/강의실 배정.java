import java.util.*;
import java.io.*;

public class Main {
    static class Lec implements Comparable<Lec> {
        int start, end;

        public Lec(String[] tmp) {
            this.start = toi(tmp[0]);
            this.end = toi(tmp[1]);
        }

        public int compareTo(Lec o) {
            if(this.start == o.start) return this.end - o.end;
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = toi(br.readLine());
        Lec[] arr = new Lec[n];
        for(int i=0; i<n; i++) {
            arr[i] = new Lec(br.readLine().split(" "));
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            if(q.isEmpty()) {
                q.offer(arr[0].end);
            } else if(arr[i].start < q.peek()) {
                q.offer(arr[i].end);
            } else {
                q.poll();
                q.offer(arr[i].end);
            }
        }
        System.out.println(q.size());
    }

    public static int toi(String s) {
        return Integer.parseInt(s);
    }
}