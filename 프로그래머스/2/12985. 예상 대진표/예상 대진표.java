
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int[] array = new int[n+1];
        for(int i=1; i<n+1; i++){
            array[i] = i;
        }
        
        while(n >= 2){
            n /= 2;
            for(int i=1; i<=n; i++){
                int cur = i*2-1;
                if((array[cur] == a && array[cur+1] == b) 
                   ||(array[cur+1] == a && array[cur] == b)) {
                    
                   // System.out.println(cur + " " + (cur+1));
                   // System.out.println(array[cur] + " " + array[cur+1]);
                    return answer;
                }  
                
                if(array[cur+1] == a || array[cur] == a)   array[i] = a;
                else if(array[cur+1] == b || array[cur] == b) array[i] = b;
                else {
                    array[i] = array[cur];
                }
                
            }
            // for(int j=1; j<=n; j++){
            //     System.out.print(array[j] + " ");
            // }
            // System.out.println();
            answer++;
        }

        return answer;
    }
}
