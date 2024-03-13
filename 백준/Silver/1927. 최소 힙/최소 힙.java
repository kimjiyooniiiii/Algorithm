import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //  String[] input = br.readLine().split(" ");

        Solution s = new Solution();

        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<t; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input != 0){
                q.offer(input);
            }else{
                if(q.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(q.poll());
                }
            }
        }
    }


    static class Solution {

    }
}