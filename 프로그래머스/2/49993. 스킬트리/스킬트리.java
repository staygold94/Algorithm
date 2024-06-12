class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        int len = skill.length();

        for(int i=0; i<skill_trees.length; i++) {
            // 문자별 인덱스 저장
            int[] cnt = new int[len];
            for(int j=0; j<len; j++) {
                cnt[j] = skill_trees[i].indexOf(skill.charAt(j));
            }
            
            for(int j=0; j<len - 1; j++) {
                // 앞선 스킬이 없는데 이후 스킬이 있거나
                // 앞선 스킬이 이후 스킬보다 인덱스가 높은 경우
                if((cnt[j] == -1 && cnt[j+1] > -1)
                    || (cnt[j] > cnt[j+1] && cnt[j+1] > -1)) {
                        answer--;
                        break;
                }
            }
        }
        return answer;
    }
}