import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List <ArrayList<String>> circularList = new List<>();
        Scanner sc = new Scanner(System.in);
        int size = 0;

        System.out.println("Enter test cant");
        size = sc.nextInt();

        List <String> numList = new List<>();

        for (int i = 0; i < size; i++) {
            System.out.println("Enter the number " + (i+1));
            String num = sc.next();
        }

        for (int i = 0; i < size; i++) {
            numList.add(num);
            circularList.addNodeLast(numList);
        }

        System.out.println(circularList.getList());
        System.out.println(circularList.jumping());
    }
}