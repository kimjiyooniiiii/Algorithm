import java.util.Arrays;

class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuffer sb = new StringBuffer(my_string);
        int count = 0;
        
        Arrays.sort(indices);
        
        for(int i=0; i<my_string.length(); i++){
            for(int j=0; j<indices.length; j++){
                if(i == indices[j]){
                    sb.delete(i-count, i+1-count);
                    count++;
                    break;
                }
            }
        }
        return sb.toString();
    }
}