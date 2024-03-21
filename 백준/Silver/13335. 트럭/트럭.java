import java.io.*;
import java.util.*;

public class Main {


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] option = br.readLine().split(" ");
        int n = Integer.parseInt(option[0]);
        int w = Integer.parseInt(option[1]);
        int l = Integer.parseInt(option[2]);

        // 입력
        int[] car = new int[n];
        String[] carInput = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            car[i] = Integer.parseInt(carInput[i]);
        }
        int time = 0;
        int index = 0;
        Queue<Integer> q = new LinkedList<>();
        int spareWeight = l;

        while(index < n){

            if(q.size() == w){
                int poll = q.poll();
                spareWeight += poll;
          //      System.out.println("poll : " + poll + " spareWeight : " + spareWeight);
            }
            if(spareWeight >= car[index]){
                q.add(car[index]);
                spareWeight -= car[index];
          //      System.out.println("add : " + car[index]+ " time : " + time + " spareWeight : " + spareWeight);
                index++;
            }else{
                q.add(0);
          //      System.out.println("add 0" + " time : " + time);
            }
            time++;
        }
        System.out.println((time+(w)));
    }
}
