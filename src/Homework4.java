//Реализовать консольное приложение, которое:
//
//        Принимает от пользователя строку вида text~num
//
//        Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
//
//        Если введено print~num, выводит строку из позиции num в связном списке.
//
//        Если введено exit, завершаем программу
//
//        Пример:
//        string~4
//        num~3
//        print~3
//
//        num
//        print~4
//        string
//        my_value~1
//        print~1
//        my_value

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Homework4 {

    static String input() {
        String s = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print( "Введите строку вида, например string~1 : " );
            s = br.readLine().strip();
        } catch (IOException e) { System.out.println(e.getMessage()); }
        return s;
    }
    static boolean validation(String inputString) {
        String[] str = inputString.split( "~" );
        return (str.length == 2 && isDigit( str[1] )) || inputString.equals( "exit" );
    }
    static boolean isDigit(String s) {
        try {
            Integer.parseInt( s );
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        String s = input();
        while(!validation( s )) {
            System.out.println("Не правильный формат. Повторите.");
            s = input();
        }

        ArrayList<String> list = new ArrayList<>();

        while(!s.equals( "exit" )) {
            String[] str = s.split( "~" );
            int i = Integer.parseInt( str[1] );
            int defI = i - list.size();
            if (defI >= 0) {
                while (defI != 0) {
                    list.add( null );
                    defI--;
                }
            }
            if (str[0].equals( "print" )) {
                System.out.println("\n" + list.get( Integer.parseInt( str[1] ) - 1  ));
            } else { list.set(i-1, str[0]); }

            System.out.println("\nЕсли хотите выйти из программы введите -> exit");
            System.out.println("Если хотите вывести элемент массива ввидите строку фомата -> print~1 ");
            s = input();
        }

    }
}