import java.util.*;
import java.io.*;

public class Main {
    static class Person implements Comparable<Person> {
        String name;
        int year, month, day;

        public Person(String[] tmp) {
            this.name = tmp[0];
            this.day = toi(tmp[1]);
            this.month = toi(tmp[2]);
            this.year = toi(tmp[3]);
        }

        public int compareTo(Person o) {
            if(this.year == o.year) {
                if(this.month == o.month) {
                    return this.day - o.day;
                } else {
                    return this.month - o.month;
                }
            } else {
                return this.year - o.year;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] list = new Person[n];

        for(int i=0; i<n; i++) {
            String[] tmp = br.readLine().split(" ");
            list[i] = new Person(tmp);
        }

        Arrays.sort(list);

        System.out.println(list[n-1].name);
        System.out.println(list[0].name);
    }

    public static int toi(String s) {
        return Integer.parseInt(s);
    }
}