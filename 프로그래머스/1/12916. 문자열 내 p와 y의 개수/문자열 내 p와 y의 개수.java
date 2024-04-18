class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;

        s = s.toUpperCase();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'P') pCnt++;
            else if(s.charAt(i) == 'Y') yCnt++;
        }

        return pCnt == yCnt ? true : false;
    }
}