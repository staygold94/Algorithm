class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(int i=0; i<query.length; i++) {
            // 요청사항
            int cnt = 0;
            // 지원자에 대한 반복문
            for(int j=0; j<info.length; j++) {
                String request = query[i];  // 요구사항
                String person = info[j];    // 지원자
                boolean result = true;      // 합격여부
                // 조건 순회
                while(!request.equals("")) {
                    // 조건별 문자열
                    String rStr = request.indexOf(" ") > 0  ? request.substring(0, request.indexOf(" ")) : request;
                    String pStr = person.indexOf(" ") > 0  ? person.substring(0, person.indexOf(" ")) : person;

                    // 점수인 경우
                    if(rStr.matches("\\d+")) {
                        if(Integer.parseInt(rStr) > Integer.parseInt(pStr)) {
                            result = false;
                            request = "";
                            break;    
                        }
                        break;
                    // 문자열이면서 "-"가 아닌 경우
                    } else if(!rStr.equals(pStr) && !rStr.equals("-")) {
                        result = false;
                        request = "";
                        break;
                    }

                    // 이미 확인 조건은 자른다
                    request = request.indexOf(" and ") > 0 ? request.substring(request.indexOf(" and ") + 5) : request.substring(request.indexOf(" ") + 1);
                    person = person.substring(person.indexOf(" ") + 1);
                }
                // 조건에 만족하는 경우 합격자 수 증가
                if(result == true) {
                    cnt++;
                } 
            }
            answer[i] = cnt;
        }
        return answer;
    }
}