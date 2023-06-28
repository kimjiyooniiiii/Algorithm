class Solution {
    public int solution(int a, int b) {
        
        String pm = String.valueOf(a) + String.valueOf(b);
        int pmInt = Integer.valueOf(pm);
        int compare = 2 * a * b;
        
        if(pmInt >= compare) {
            return pmInt;
        }
        else{
            return compare;
        }
    }
}