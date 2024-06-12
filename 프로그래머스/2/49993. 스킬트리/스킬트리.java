class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0; i<skill_trees.length; i++) {
            String tmp = skill_trees[i];
            for(int j=0; j<skill_trees[i].length(); j++) {
                String s = skill_trees[i].substring(j, j+1);
                // 없는 경우 제거
                if(!skill.contains(s)) {
                    tmp = tmp.replace(s, "");
                }
            }
            // 남은 문자열이 skill에 포함되는지 확인
            if(skill.indexOf(tmp) == 0) answer++;
        }

        return answer;
    }
}