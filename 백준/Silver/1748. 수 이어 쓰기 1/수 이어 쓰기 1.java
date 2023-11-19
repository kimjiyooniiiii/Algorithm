import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String xStr = br.readLine();
        int xSize = xStr.length();
        int x = Integer.parseInt(xStr);
        int size = 1;
        int result = 0;

        while(size != xSize){
            double count = 9*(Math.pow(10,size-1));
            result += (int)count * size;
            size++;
        }
        int start = (int)Math.pow(10,size-1);
        for(int i=start; i<=x; i++){
            result += size;
        }

        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}