import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] visited;
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i=0; i<n; i++) {
            visited = new boolean[26];
            String s = br.readLine();
            boolean isPossible = true;
            int prev = -1;
            for(int j=0; j<s.length(); j++) {
                int num = s.charAt(j) - 97;
                if(visited[num] && prev != num) {
                    isPossible = false;
                    break;
                }
                visited[num] = true;
                prev = num;
            }
            if(isPossible) answer++;
        }
        System.out.println(answer);
    }
}