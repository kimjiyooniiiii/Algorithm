import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int head = 0;
        //int back = list.get(list.size()-1);

        for(int i=0; i<n; i++) {
            String[] array = br.readLine().split(" ");

            if(array[0].equals("push")){
                int a = Integer.parseInt(array[1]);
                list.add(a);
            }
            else if(array[0].equals("front")){
                if(!list.isEmpty()){
                    System.out.println(list.get(head));
                }else{
                    System.out.println(-1);
                }
            }
            else if(array[0].equals("back")){
                if(!list.isEmpty()){
                    System.out.println(list.get(list.size()-1));
                }else{
                    System.out.println(-1);
                }
            }
            else if(array[0].equals("empty")){
                if(!list.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }
            }
            else if(array[0].equals("size")){
                System.out.println(list.size());
            }
            else if(array[0].equals("pop")){
                if(!list.isEmpty()){
                    int a = list.get(0);
                    list.remove(list.get(0));
                    System.out.println(a);
                }else{
                    System.out.println(-1);
                }
            }
        }

    }
}
