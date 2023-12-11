import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // !! 시간초과가 나지 않으려면 쌓아서 출력해야한다. !!

        int n = Integer.parseInt(br.readLine());

        // 계수정렬을 이용
        // 절대값이 1,000,000 보다 작거나 같은 정수이므로 0을 포함하여 200001 범위의 배열 생성
        // !! 값이 중복되지 않으므로 int[]로 할 필요 없이 boolean을 선택하면 된다 !!
        boolean[] arr = new boolean[2000001];

        // 배열은 음수가 없으므로 음수범위만큼 더해서 저장
        for(int i=0; i<n; i++) {
            arr[Integer.parseInt(br.readLine())+1000000] = true;
        }

        // 출력시 음수범위만큼 빼고 출력
        for(int i=0; i<arr.length; i++) {
            if(arr[i]) 
                sb.append(i-1000000).append('\n');
        }
        System.out.print(sb);
    }
}
