import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int len = line.length()/10;
        int idx = 0;    // 인덱스 이동하면서 원하는 구간 자르기

        for(int i=0; i<len; i++) {
            System.out.println(line.substring(idx, idx+10));    // 처음과 끝을 지정하는 substring
            idx += 10;
        }
        System.out.println(line.substring(idx));    // 시작점만 지정하는 substring
    }
}
