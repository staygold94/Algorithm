class Solution {
    public int solution(int[][] dots) {

        if(getSlope(dots[0], dots[1]) == getSlope(dots[2], dots[3])
        || getSlope(dots[0], dots[2]) == getSlope(dots[1], dots[3])
        || getSlope(dots[0], dots[3]) == getSlope(dots[1], dots[2])) return 1;

        return 0;
    }

    public double getSlope(int[] dots1, int[] dots2) {
        return (double)(dots1[1] - dots2[1]) / (double)(dots1[0] - dots2[0]);
    }
}