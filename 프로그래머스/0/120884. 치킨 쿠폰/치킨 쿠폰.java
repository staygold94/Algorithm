class Solution {
    public int solution(int chicken) {
        int coupon = chicken;   // 초기값
        int answer = 0;

        // 쿠폰이 10장 이상이면 보너스 치킨을 주문할 수 있다
        while(coupon >= 10) {
            // 보너스 치킨수
            int freeChicken = coupon / 10;
            answer += freeChicken;
            coupon = coupon % 10 + freeChicken; // 남은 쿠폰 + 새롭게 받은 쿠폰
        }
        return answer;
    }
}