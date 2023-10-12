import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
		public static void main(String[] args) throws IOException {

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				int num = Integer.parseInt(br.readLine());

				for (int i=1; i <= num; i++) {
						for (int j=1; j <= i; j++) {
								bw.write("*");
						}
						bw.write("\n");
				}
				bw.close();
		}
}