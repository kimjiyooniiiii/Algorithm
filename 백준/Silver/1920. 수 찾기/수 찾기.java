import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //  String[] input = br.readLine().split(" ");

        Solution s = new Solution();

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        String[] nInput = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            set.add(Integer.parseInt(nInput[i]));
        }

        int m = Integer.parseInt(br.readLine());
        String[] mInput = br.readLine().split(" ");
        for(int i=0; i<m; i++) {
            int num = Integer.parseInt(mInput[i]);
            if(set.contains(num)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }


    static class Solution {

    }
}