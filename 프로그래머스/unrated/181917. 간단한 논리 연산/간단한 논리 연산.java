class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = end(or(x1,x2), or(x3,x4));
        
        return answer;
    }
    
    public boolean or(boolean a, boolean b) {
        if(a != b) {
            return true;
        }
        else {
            return a;
        }
    }
    
    public boolean end(boolean a, boolean b) {
        if(a != b) {
            return false;
        }
        else {
            return a;
        }
    }
    
}