class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isLowerCase(ch)) {
                ch = (char)(((ch - 'a' + n) % 26) + 'a');   // (현재 이동되어 있는 수 + n) % 알파벳수 == 움직이게 될 수
            } else if(Character.isUpperCase(ch)) {
                ch = (char)(((ch - 'A' + n) % 26) + 'A');
            } 

            sb.append(ch);
        }

        return sb.toString();
    }
}