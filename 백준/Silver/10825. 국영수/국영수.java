import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); 
        Student[] arr = new Student[n];
        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int mat = Integer.parseInt(st.nextToken());
            arr[i] = new Student(name, kor, eng, mat);
        }

        // !! Arrays.sort는 비교되는 반환값이 음수면 자리를 바꾼다. !!
        // !! 람다식으로 비교 및 정렬 기준의 파라미터를 넘길 수 있다. !!
        Arrays.sort(arr, new Comparator<Student> () {

            @Override
            public int compare(Student o1, Student o2) {

                if (o1.kor == o2.kor) {
                    if (o1.eng == o2.eng) {
                        if (o1.mat == o2.mat) {
                            // !! String 비교는 compareTo 메서드로 가능하다 !!
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.mat - o1.mat;
                    }
                    return o1.eng - o2.eng;
                }
                return o2.kor - o1.kor;
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            sb.append(arr[i].name + "\n");
        }

        System.out.println(sb);
    }

    // 클래스 객체를 만듬
    public static class Student {
        String name;
        int kor;
        int eng;
        int mat;

        public Student(String name, int kor, int eng, int mat) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.mat = mat;
        }
    }
}
