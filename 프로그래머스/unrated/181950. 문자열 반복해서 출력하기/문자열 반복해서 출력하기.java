import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String answer = "";
        
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        
        while(n>0) {
            answer += str;
            n--;
        }
        System.out.println(answer);
    }
}