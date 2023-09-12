import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String s = br.readLine();

            while(s.contains("()")){
                s = s.replace("()","");
            }

            if(s.equals("")) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
