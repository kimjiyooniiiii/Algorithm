import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> d = new LinkedList<>();

        for(int i=0; i<n; i++) {
            String[] order = br.readLine().split(" ");

            switch(order[0]) {
                case "push_back" :
                    d.add(Integer.parseInt(order[1]));
                    break;
                case "push_front" :
                    d.push(Integer.parseInt(order[1]));
                    break;
                case "pop_front" :
                    if(!d.isEmpty()){
                        bw.write(String.valueOf(d.pop())+"\n");
                        bw.flush();
                    }else{
                        bw.write("-1"+"\n");
                        bw.flush();
                    }
                    break;
                case "pop_back" :
                    if(!d.isEmpty()){
                        bw.write(String.valueOf(d.removeLast())+"\n");
                        bw.flush();
                    }else{
                        bw.write("-1"+"\n");
                        bw.flush();
                    }
                    break;
                case "size":
                    bw.write(String.valueOf(d.size())+"\n");
                    bw.flush();
                    break;
                case "empty" :
                    if(!d.isEmpty()){
                        bw.write("0"+"\n");
                        bw.flush();
                    }else{
                        bw.write("1"+"\n");
                        bw.flush();
                    }
                    break;
                case "front" :
                    if(!d.isEmpty()){
                        bw.write(String.valueOf(d.peek())+"\n");
                        bw.flush();
                    }else{
                        bw.write("-1"+"\n");
                        bw.flush();
                    }
                    break;
                case "back":
                    if(!d.isEmpty()){
                        bw.write(String.valueOf(d.peekLast())+"\n");
                        bw.flush();
                    }else{
                        bw.write("-1"+"\n");
                        bw.flush();
                    }
                    break;
            }
        }
        bw.close();
    }
}
