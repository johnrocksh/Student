/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Menu {

    static StudentManager studentManager;

    //////////////PressEnyKey  -- ожидаем нажатие любой клавиши от пользователя
    public void pressEnyKey() {

        Scanner in = new Scanner(System.in);
        char c = in.next().charAt(0);

    }

    ////////////// Menu  -   
    public void Menu() {

        // StudentManager studentManager = new StudentManager();
        System.out.println("\n\n---------------------STUDENT LIST MENU--------------------");

        System.out.println(" 1 : | ADD STUDENT    |");
        System.out.println(" 2 : | DELETE STUDENT |");
        System.out.println(" 3 : | SHOW STUDENTS  |");
        System.out.println(" 4 : | EDIT STUDENT   |");
        System.out.println(" 6 : | SAVE TO FILE   |");
        System.out.println(" 7 : | EXIT           |");
        System.out.println("\nMaximum number of students:" + studentManager.lengthStudentList);
        System.out.println("Now count of student list is:" + studentManager.studentCounter);

    }

    //////////////////PressedKeyIsNumber //возвращает StudentNumber или -1 если это не число
    int pressedKeyIsNumber(char PressedKey) {

        int StudentNumber;

        if (Character.isDigit(PressedKey)) {

            return StudentNumber = Character.getNumericValue(PressedKey); //берем числовое значение от Char 
        } else {
            return -1;
        }

    }

/////////////// ExitMenu- выход из программы
    public void exitMenu() {
        System.exit(0);
    }

    /////////////// SwitchMenu - 
    public int switchMenu(int menuNumber) {

        FileIO fileStudentList = new FileIO();

        switch (menuNumber) {
            case 1: {

                studentManager.addNewStudent();
                break;

            }
            case 2: {
                studentManager.deleteStudent();
                break;

            }
            case 3: {
                studentManager.showStudentList();
                break;

            }

            case 4: {
                studentManager.editStudent();
                break;

            }
            case 5: {
                System.out.println(" Find Student");
                break;

            }

            case 6: {
                fileStudentList.saveToFile(studentManager);
                break;

            }
            case 7: {
                System.out.println(" -------Exit program--------  ");
                System.out.println("SAVE TO FILE?");
                System.out.println("1. SAVE AND EXIT");
                System.out.println("2. EXIT WITHOUT SAVE");
                Scanner sc = new Scanner(System.in);

                switch (sc.nextInt()) {
                    case 1: {
                        fileStudentList.saveToFile(studentManager);
                        System.out.println("studentList was Saved to File!");
                        exitMenu();
                    }
                    case 2: {
                        exitMenu();
                    }
                }

                break;
            }
        }
        return menuNumber;
    }

    ///////////////// ShowMenu -  
    public void showMenu() {
       // StudentManager studentManager = new StudentManager();
        int menuNumber;
        boolean RunMenu = true;

        while (RunMenu) {

            Menu();//выводим менюшку
            System.out.println("");
            System.out.print("Please make you choice: ");

            //ввод с консоли пункта меню
            Scanner in = new Scanner(System.in);//cчитываем пункт меню в char проверяем если это число и если оно меньше длины нашего массмва
            char c = in.next().charAt(0);
            if (Character.isDigit(c)) {

                menuNumber = Character.getNumericValue(c); //берем числовое значение от Char 

                if (menuNumber <= 7) {
                    switchMenu(menuNumber);
                    System.out.println("PressEnyKey...");//ожидаем нажатия клавиши  
                    pressEnyKey();
                }
            }

        }
    }

    public static void main(String[] args) {
        studentManager = new StudentManager();
        Menu menu = new Menu();
        FileIO fileStudentList = new FileIO();
        fileStudentList.getStudentListFromFile(studentManager);
      
        studentManager= fileStudentList.parsingStudentLine(studentManager);
        menu.showMenu();
    }

}
