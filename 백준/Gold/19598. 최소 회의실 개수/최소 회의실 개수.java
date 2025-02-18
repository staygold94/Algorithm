import java.util.*;
import java.io.*;

public class Main {
    static class Lec implements Comparable<Lec> {
        int start, end;

        public Lec(String[] tmp) {
            this.start = toInt(tmp[0]);
            this.end = toInt(tmp[1]);
        }

        public int compareTo(Lec o) {
            if(this.start == o.start) return this.end - o.end;
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Lec[] arr = new Lec[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = new Lec(br.readLine().split(" "));
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            if(queue.isEmpty()) {
                queue.offer(arr[i].end);
            } else if(arr[i].start < queue.peek()) {
                queue.offer(arr[i].end);
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