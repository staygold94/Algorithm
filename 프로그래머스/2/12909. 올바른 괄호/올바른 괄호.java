class Solution {
    boolean solution(String s) {

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                sb.append(ch);
            } else {
                if(sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
                else return false;
            }
        }

        return sb.length() == 0 ? true : false;
    }
}