import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");
        List<String> list = Arrays.asList(array);

        if(n == 1) {
            int a = Integer.parseInt(list.get(0));
            int result = (int)(Math.pow(a,2));
            bw.write(result+"\n");
            bw.flush();
            bw.close();
        }else{
            int min = 1000000;
            int max = 0;
            for(int i=0; i<list.size(); i++){
                int a = Integer.parseInt(list.get(i));
                min = Math.min(min, a);
                max = Math.max(max, a);
            }
            bw.write(max*min + "\n");
            bw.flush();
            bw.close();
        }
    }


}