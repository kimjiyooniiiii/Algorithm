import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        List<Integer> list = new ArrayList<>();

        Queue q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            q.add(i+1);
        }

        int count = 1;
        while(!q.isEmpty()) {
            if(count % k !=0){
                q.add(q.poll());
            }else{
                list.add((Integer)q.poll());
            }
            count++;
        }

        bw.write("<");
        bw.flush();
        for(int i=0; i<list.size(); i++) {
            bw.write(String.valueOf(list.get(i)));
            bw.flush();
            if(i != list.size()-1){
                bw.write(", ");
                bw.flush();
            }
        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
