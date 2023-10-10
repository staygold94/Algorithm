import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
		public static void main(String[] args) throws IOException {

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st;
				int A, B;

				while ( 1 == 1) {
						st = new StringTokenizer(br.readLine(), " ");
						A = Integer.parseInt(st.nextToken());
						B = Integer.parseInt(st.nextToken());
						if ( A == 0 && B == 0) {
								break;
						} else {
								System.out.println(A+B);
						}
				}	
		}
}