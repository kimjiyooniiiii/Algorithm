class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int x=1; x<=r2; x++){
            double a = Math.sqrt((long)r2*r2 - (long)x*x);
            //System.out.print(Math.floor(a) + " ");
            double b = 0;
            
            if(r1 >= x){
                b = Math.sqrt((long)r1*r1 - (long)x*x);
            }
            //System.out.println(Math.ceil(b) + " " + (long)(Math.floor(a) - Math.ceil(b) + 1));
            
            answer += (long)(Math.floor(a) - Math.ceil(b) + 1);
        }
        answer *= 4;
        
        return answer;
    }
}