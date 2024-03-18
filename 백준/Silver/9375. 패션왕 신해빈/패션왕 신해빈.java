import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int cloth = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for(int j=0; j<cloth; j++){
                String[] input = br.readLine().split(" ");
                String key = input[1];

                if(map.containsKey(key)){
                    int value = map.get(key);
                    map.put(key,++value);
                }else{
                    map.put(key,1);
                }
            }

            int result = 1;
            Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
            while(it.hasNext()){
                String key = it.next().getKey();
                result *= (map.get(key) + 1);
            }
            System.out.println(--result);
        }
    }
}
