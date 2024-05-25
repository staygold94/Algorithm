import java.util.*;

class Solution {
    public int solution(String before, String after) {

        char[] beforeArr = before.toCharArray();
        char[] afterArr = after.toCharArray();

        Arrays.sort(beforeArr);
        Arrays.sort(afterArr);

        return new String(beforeArr).equals(new String(afterArr)) ? 1 : 0;
    }
}