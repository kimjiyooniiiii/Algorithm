class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int i=0; i<=d; i+=k){
            // long count = (long)Math.sqrt(d*d - i*i) / k + 1;
            // answer += count;
            
            long count = (long)Math.sqrt((long)d*d - (long)i*i);
            answer += count / k + 1;
        }
        
        return answer;
    }
}
