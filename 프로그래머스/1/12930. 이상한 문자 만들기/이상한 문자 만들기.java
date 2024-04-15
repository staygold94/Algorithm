class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean Upper = true;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                sb.append(ch);
                Upper = true;
            } else {
                if(Upper) {
                    sb.append(String.valueOf(ch).toUpperCase());
                } else {
                    sb.append(String.valueOf(ch).toLowerCase());
                }
                Upper = !Upper;
            }
        }
        return sb.toString();
    }
}