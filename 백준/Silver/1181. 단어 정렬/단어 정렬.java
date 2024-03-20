import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length() != b.length()){
                    return a.length() - b.length();
                }else{
                    return a.compareTo(b);
                }
            }
        });
        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }

        for(String s : set){
            System.out.println(s);
        }
    }
}
