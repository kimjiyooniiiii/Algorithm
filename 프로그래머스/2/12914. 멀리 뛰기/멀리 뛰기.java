class Solution {
    public long solution(int n) {
        long answer = 0;
        
        long[] count = new long[2001];
        count[1] = 1;
        count[2] = 2;
        
        for(int i=3; i<count.length; i++) {
            count[i] = (count[i-1] + count[i-2]) % 1234567;
        }
        
        answer = count[n];
        return answer;
    }
}