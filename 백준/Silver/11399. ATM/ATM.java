import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<2; i++) {
            line = br.readLine();
            sb.append(line).append("\n");
        }

        String input = sb.toString();
        br.close();
        String[] lines = input.split("\n");
        int people = Integer.valueOf(lines[0]);

        String[] person = lines[1].split(" ");

        int[] number = Arrays.stream(person).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(number);
        int answer = 0;
        int sum = 0;
        for(int i=0; i<people; i++) {
            sum += number[i];
            answer += sum;
        }
        System.out.println(answer);
    }
}
