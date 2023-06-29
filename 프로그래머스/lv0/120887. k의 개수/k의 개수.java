class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        String s = "";
        char c = Character.forDigit(k,10);
        
        for(int a = i; a < j+1; a++){
            s += String.valueOf(a);
        }
        
        for(int a = 0; a < s.length(); a++) {
            if(s.charAt(a) == c){
                answer++;
            }
        }
        
        return answer;
    }
}