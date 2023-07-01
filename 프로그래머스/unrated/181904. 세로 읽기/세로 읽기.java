class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        
        int row = my_string.length() / m;
        String[] array = new String[row];
        int count = m;
        
        for(int i=0; i < my_string.length(); i+=m) {
            array[i/m] = my_string.substring(i,i+m);
        }
        
        for(int j=0; j<row; j++) {
            answer += array[j].charAt(c-1);
        }
        
        return answer;
    }
}