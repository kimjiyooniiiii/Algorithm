import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = br.readLine();
        Set<String> set = new HashSet<>();
        StringBuilder sb;

        for(int i=0; i<sentence.length(); i++){
            sb = new StringBuilder();
            for(int j=i; j<sentence.length(); j++){
                sb.append(sentence.charAt(j));
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
    }
}
