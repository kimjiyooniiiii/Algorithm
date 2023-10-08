import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String read = br.readLine();
            List<String> list = new LinkedList<>();
            ListIterator<String> it = list.listIterator();

            for(int j=0; j< read.length(); j++) {
                char s = read.charAt(j);
                if(s == '>'){
                    if(it.hasNext()){
                        it.next();
                    }
                }else if(s == '<') {
                    if(it.hasPrevious()){
                        it.previous();
                    }
                }else if(s == '-'){
                    if(it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                }else{
                    it.add(String.valueOf(s));
                }
            }

            for(String l : list) {
                bw.write(l);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
