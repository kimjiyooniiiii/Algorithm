import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            list.add(br.readLine());
        }

        //뒤집기
        for(int i=0; i<list.size(); i++) {
            String s = list.get(i);
            String result = "";

            String[] sp = s.split(" ");

            for(int j=0; j<sp.length; j++) {
                StringBuffer sb = new StringBuffer(sp[j]);
                sp[j] = sb.reverse().toString();
                result += sp[j];
                result += " ";
            }

            list.set(i, result.trim());
        }

        for(String r : list) {
            System.out.println(r);
        }
    }
}
