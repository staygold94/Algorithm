import java.io.*;
import java.util.*;

public class Main {
    public static class person {
        int kor, math, eng;
        String name;

        public person(String name, int kor, int math, int eng) {
            this.name = name;
            this.kor = kor;
            this.math = math;
            this.eng = eng;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        person[] arr = new person[n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            person p = new person(name, kor, math, eng);
            arr[i] = p;
        }

        Arrays.sort(arr, new Comparator<person>() {

            @Override
            public int compare(person p1, person p2) {
                if(p1.kor == p2.kor) {
                    if(p1.eng == p2.eng) {
                        if(p1.math == p2.math) {
                            return p1.name.compareTo(p2.name);
                        } else{
                            return p2.math - p1.math;
                        }
                    } else {
                        return p1.eng - p2.eng;
                    }
                } else {
                    return p2.kor - p1.kor;
                }
            }

            }
        );

        StringBuilder sb = new StringBuilder();
        for(person p : arr) {
            sb.append(p.name + "\n");
        }
        System.out.print(sb.toString());
    }
}