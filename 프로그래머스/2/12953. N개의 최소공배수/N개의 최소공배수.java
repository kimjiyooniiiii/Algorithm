// (고민 과정)
// 처음에는 어렵게 접근을 했다.
// '어떻게하면 전체의 최소공배수를 한번에 구할 수 있을까'라고 고민했다.

// 하지만 예외 케이스를 보면서 차근히 생각해보니,
// 배열의 앞에서부터 차례대로 최소공배수를 구해나가면 마지막에 계산되어 나오는 값이 전체의 최소공배수가 된다는 것을 발견했다.

import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length-1; i++){
            arr[i+1] = lcm(arr[i], arr[i+1]);
        }
        
        return arr[arr.length-1];
    }

    public int gcd(int small, int big){
        if(small == 0) return big;
        return gcd(big % small, small);
    }
    
    public int lcm(int small, int big){
        int gcdNum = gcd(small, big);
        
        return small * big / gcdNum;
    }
}


