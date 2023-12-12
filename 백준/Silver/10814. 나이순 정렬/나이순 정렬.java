import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); 
        Person[] arr = new Person[n];
        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr[i] = new Person(age, name);
        }

        // !! Arrays.sort는 비교되는 반환값이 음수면 자리를 바꾼다. !!
        // !! 람다식으로 비교 및 정렬 기준의 파라미터를 넘길 수 있다. !!
        Arrays.sort(arr, new Comparator<Person> () {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            // !! 객체배열의 객체를 출력하면 해당 인덱스의 객체의 toString()이 출력됨 !!
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }

    // 클래스 객체를 만듬
    public static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }
}

/*
 * 참고한 사이트
 * https://st-lab.tistory.com/243 (자바의 Comparable과 Comparator 이해)
 */

/* 단순하게 String[][]으로 푼 풀이

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()); 
    String[][] arr = new String[n][2];
    StringTokenizer st;

    for(int i=0; i<n; i++) {
        st = new StringTokenizer(br.readLine());
        arr[i][0] = st.nextToken();
        arr[i][1] = st.nextToken();
    }

    // !! Arrays.sort는 비교되는 반환값이 음수면 자리를 바꾼다. !!
    // !! 람다식으로 비교 및 정렬 기준의 파라미터를 넘길 수 있다. !!
    Arrays.sort(arr, new Comparator<String[]> () {

        @Override
        public int compare(String[] o1, String[] o2) {

            // 만일 나이가 같으면 이름을 비교한다. (이번 문제는 해당 x)
            if (o1[0] == o2[0]) {
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
            return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
        }
    });

    for(int i=0; i<arr.length; i++) {
        for(int j=0; j<arr[i].length; j++) {
            System.out.print(arr[i][j] + " ");
        }
        System.out.println();
    }

 */