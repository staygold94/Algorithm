import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();     // 입력 값

        // 투포인터 문제
        int s_idx = 1;  // start index
        int e_idx = 1;  // end index
        int sum = 1;    // start index 부터 end index 까지의 구간 합
        int count = 1;  // num과 일치하는 횟수 (while문을 통해 end index가 num과 동일해지는 순간은 제외했으므로, 미리 해당 부분을 +1 해줌)

        while (e_idx != num) {
            // sum이 num보다 적으면 end index를 뒤로 보내 sum 값을 늘린다
            if(sum < num) {
                e_idx++;
                sum += e_idx;
            // sum이 num과 일치할 경우, 갯수(count) 더해주고, 다시 뒤로 이동
            } else if (sum == num) {
                count++;
                e_idx++;
                sum += e_idx;
            // sum이 num보다 크면, start index 값 빼주고, 한 칸 이동
            } else {
                sum -= s_idx;
                s_idx++;
            }
        }
        System.out.println(count);

        sc.close();
    }
}
