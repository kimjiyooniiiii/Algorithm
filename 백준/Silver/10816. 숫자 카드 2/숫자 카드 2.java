import java.io.*;
import java.util.HashMap;

public class Main {

    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //  String[] input = br.readLine().split(" ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Solution s = new Solution();

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        String[] nInput = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            int key = Integer.parseInt(nInput[i]);
            if(map.containsKey(key)){
                int value = map.get(key);
                map.replace(key, ++value);
            }else{
                map.put(key,1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        String[] mInput = br.readLine().split(" ");
        for(int i=0; i<m; i++) {
            int key = Integer.parseInt(mInput[i]);
            if(map.containsKey(key)){
                bw.write(map.get(key) + " ");
            }else{
                bw.write(0 + " ");
            }
        }
        bw.flush();
        bw.close();
    }


    static class Solution {

    }
}