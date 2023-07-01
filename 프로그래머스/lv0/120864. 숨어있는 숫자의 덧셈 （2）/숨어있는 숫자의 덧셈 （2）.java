class Solution {
    public int solution(String my_string) {
        int answer = 0;
        StringBuffer sb = new StringBuffer(my_string);
        
        for(int i=0; i<my_string.length(); i++) {
            if(Character.isLetter(my_string.charAt(i))){
                sb.replace(i,i+1," ");
            }
        }
        String s = sb.toString();
        s = s.trim();
        
        if(s.equals("")){
            return answer;
        }else{
            
             String[] array = s.split("\\s+");
        
             for(String a : array){
                answer += Integer.valueOf(a);
            }
            return answer;
        }
        
    }
}