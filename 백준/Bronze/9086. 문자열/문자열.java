import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input;
        for (int i = 0; i < n; i ++){
            input = br.readLine();
            System.out.println("" + input.charAt(0) + input.charAt(input.length()-1));
        }
    }
}