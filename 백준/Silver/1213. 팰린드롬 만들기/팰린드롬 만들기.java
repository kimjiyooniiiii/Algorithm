import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alphabet = new int[26];
        List<Character> doubleChar = new ArrayList<>();

        String input = br.readLine();

        //처음 등장하는 단어는 alphabet배열의 값을 1증가
        //두번째 등장하는 단어는 doubleChar리스트에 추가
        for(int i=0; i<input.length(); i++){
            int index = input.charAt(i) % 65;
            if(alphabet[index] == 1){
                alphabet[index] = 0;
                doubleChar.add(input.charAt(i));
            }else{
                alphabet[index] = 1;
            }
        }

        //출력
        int count = 0;
        String centerChar = "";
        for(int i=0; i<alphabet.length; i++){
            if(alphabet[i] == 1){
                count++;
                centerChar = String.valueOf((char)(i+65));
            }
        }

        if(count > 1){
            bw.write("I'm Sorry Hansoo");
            bw.flush();
        }else{
            doubleChar.sort(Comparator.naturalOrder());
            for(char c : doubleChar){
                bw.write(c);
                bw.flush();
            }
            bw.write(centerChar);
            bw.flush();

            doubleChar.sort(Comparator.reverseOrder());
            for(char c : doubleChar){
                bw.write(c);
                bw.flush();
            }
        }

        bw.close();
    }

}