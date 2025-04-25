import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
        A+: 4.3, A0: 4.0, A-: 3.7

        B+: 3.3, B0: 3.0, B-: 2.7

        C+: 2.3, C0: 2.0, C-: 1.7

        D+: 1.3, D0: 1.0, D-: 0.7

        F: 0.0

 */
        Map<String, Float> dict = new HashMap<>();
        dict.put("A+", 4.3f);
        dict.put("A0", 4.0f);
        dict.put("A-", 3.7f);
        dict.put("B+", 3.3f);
        dict.put("B0", 3.0f);
        dict.put("B-", 2.7f);
        dict.put("C+", 2.3f);
        dict.put("C0", 2.0f);
        dict.put("C-", 1.7f);
        dict.put("D+", 1.3f);
        dict.put("D0", 1.0f);
        dict.put("D-", 0.7f);
        dict.put("F", 0.0f);
        
        Scanner sc = new Scanner(System.in);
        System.out.println(dict.get(sc.nextLine()));


    }

}
