class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        String cut = my_string.substring(s,e+1);
        
        StringBuffer sb = new StringBuffer(cut);
        sb.reverse();
        cut = sb.toString();
        
        answer = my_string.substring(0,s) + cut
            + my_string.substring(e+1, my_string.length());
        return answer;
    }

}