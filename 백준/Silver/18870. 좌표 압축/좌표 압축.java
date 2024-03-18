import java.io.*;
import java.util.*;

public class Main {

    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        String[] numLine = br.readLine().split(" ");
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        for(int i=0; i<size; i++){
            set.add(Integer.parseInt(numLine[i]));
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int count = set.size()-1;
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            int num = it.next();
            map.put(num,count);
           //System.out.println(num + " " + count);
            count--;
        }

        for(int i=0; i<size; i++) {
            bw.write(map.get(Integer.parseInt(numLine[i])) + " ");
        }
        bw.flush();
        bw.close();
    }
}
