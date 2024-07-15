import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line;

        while(sc.hasNextLine()) {
            line = sc.nextLine();

            int small = 0;
            int big = 0;
            int number = 0;
            int space = 0;

            for(int i=0; i<line.length(); i++) {
                char ch = line.charAt(i);
                
                if(ch >= 97 && ch <= 122) {
                    small++;
                } else if(ch >= 65 && ch <= 90) {
                    big++;
                } else if(ch >= 48 && ch <= 57) {
                    number++;
                } else {
                    space++;
                }
            }
            System.out.print(small + " ");
            System.out.print(big + " ");
            System.out.print(number + " ");
            System.out.println(space);
        }
        sc.close();
    }
}