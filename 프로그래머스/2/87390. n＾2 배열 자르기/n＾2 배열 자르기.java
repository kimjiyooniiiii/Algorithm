
class Solution {
    public int[] solution(int n, long left, long right) {
        int resultSize = (int)(right-left)+1;
        int[] answer = new int[resultSize];
        
        for(long i=left; i<=right; i++){
            int row = (int)(i/n);
            int column = (int)(i%n);
            
            //System.out.println((i/n) + " " + (i%n));
            
            int max = Math.max(row,column);
            answer[(int)(i-left)] = max+1;
    
        }
        
        return answer;
    }
}


// 1천만 * 1천만 
// 배열 자르기?
// 자른 배열 최대크기 10만