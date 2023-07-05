class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int ball = 0;
        k = k-1;
        
        while(k != 0){
            ball += 2;
            if(ball >= numbers.length){
                ball -= numbers.length;
            }
            k--;
        }
        return ball+1;
    }
}