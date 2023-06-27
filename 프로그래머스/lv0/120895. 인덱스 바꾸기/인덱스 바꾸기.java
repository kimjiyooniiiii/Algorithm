class Solution {
    public String solution(String my_string, int num1, int num2) {

        char cNum1 = ' ';
        char cNum2 = ' ';
        StringBuffer bf = new StringBuffer(my_string);
        
        for(int i=0; i<my_string.length(); i++ ) {
            if(i == num1) {
                cNum1 = my_string.charAt(i);
            }
            else if(i == num2) {
                cNum2 = my_string.charAt(i);
            }
        }
        bf.replace(num1, num1+1, String.valueOf(cNum2));
        bf.replace(num2, num2+1, String.valueOf(cNum1));
        
        String answer = bf.toString();
        
        return answer;
    }
}