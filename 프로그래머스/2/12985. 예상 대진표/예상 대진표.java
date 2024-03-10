class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(!isMatch(a,b)) {
            a = evenOdd(a);
            b = evenOdd(b);
            answer++;
            
            //System.out.println(a + " " + b + " " + answer);
        }

        return answer+1;
    }
    
    public int evenOdd(int num) {
        if(num % 2 == 0) {
            return num/2;
        }else{
            return num/2+1;
        }
    }
    
    public boolean isMatch(int a, int b) {
        if(evenOdd(a) == evenOdd(b)){
            return true;
        }
        return false;
    }
}