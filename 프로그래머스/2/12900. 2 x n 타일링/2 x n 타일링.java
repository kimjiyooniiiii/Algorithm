class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] cases = new int[n];
        cases[0] = 1;   cases[1] = 2;
        
        for(int i=2; i<n; i++){
            cases[i] = (cases[i-1] + cases[i-2]) % 1000000007;
        }
        
        answer = cases[n-1];
        return answer;
    }
}