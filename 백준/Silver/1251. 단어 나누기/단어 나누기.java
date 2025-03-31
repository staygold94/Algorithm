import java.util.*;
import java.io.*;

public class Main {
    public static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        List<String> list = new ArrayList<>();
        
        for(int i=1; i<str.length(); i++) {
            for(int j=i+1; j<str.length(); j++) {
                list.add(getStr(i, j));
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));

    }

    public static String getStr(int i, int j) {
        StringBuilder sb = new StringBuilder();
        String a = sb.append(str.substring(0, i)).reverse().toString();
        sb = new StringBuilder();
        String b = sb.append(str.substring(i, j)).reverse().toString();
        sb = new StringBuilder();
        String c = sb.append(str.substring(j)).reverse().toString();
        return a+b+c;
    }
}

