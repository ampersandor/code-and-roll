import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (Character c : word.toCharArray()){
            if(Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));
            }
            else{
                sb.append(Character.toUpperCase(c));
            }
        }
        System.out.println(sb.toString());
    }

}
