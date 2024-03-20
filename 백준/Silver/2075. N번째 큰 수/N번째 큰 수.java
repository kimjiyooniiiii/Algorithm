import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int t=0; t<n; t++){
            String[] input = (br.readLine()).split(" ");
            for(int i=0; i<n; i++){
                q.add(Integer.parseInt(input[i]));
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            if(i==n-1){
                answer = q.poll();
            }else{
                q.poll();
            }
        }
        System.out.println(answer);
    }
}
