package view;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String opStr = "";
        int op = 0;


        while (op != 5){
            System.out.println(menu());
            opStr = sc.nextLine();
            op = intValidation(opStr);

            switch (op){
                case 1 -> add();
                case 2 -> search();
                case 3 -> delete();
                case 4 -> view();
            }
        }
    }

    public static void add(){
        String word = "", meaning = "";

        System.out.println("Enter the New Word");
        word = sc.nextLine();
        System.out.println("Enter the Meaning");
        meaning = sc.nextLine();


    }

    public static void search(){

    }

    public static void delete(){

    }

    public static void view(){

    }

    public static String menu(){
        return "_______ Diccionario _______" + "\n"
                + "1. Add Word" + "\n"
                + "2. Search Word" + "\n"
                + "3. Delete Word" + "\n"
                + "4. View Word List" + "\n"
                + "5. Exit";
    }

    public static int intValidation(String op){
        try {
            return Integer.parseInt(op);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}