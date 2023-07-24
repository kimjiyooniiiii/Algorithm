class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if((s.length() == 4)||(s.length() == 6)){
            try{
                Integer.parseInt(s);
                answer = true;
            }
            catch(Exception e){
                answer = false;
            }
            
        }else{
            answer = false;
        }
            
        
        return answer;
    }
}