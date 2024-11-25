import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String regex = "[0-9]+|-|\\+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        int sum = 0;
        boolean isPlus = true;

        while(matcher.find()) {
            String s = matcher.group();

            // 마이너스라면
            if(s.equals("-")) {
                isPlus = false;
            // 플러스라면
            } else if(s.equals("+")){
                isPlus = isPlus == false ? false : true;
            // 숫자라면
            } else {
                int num = Integer.parseInt(s);
                sum += (isPlus ? num : -1 * num);
            }
        }
        System.out.println(sum);
    }
}