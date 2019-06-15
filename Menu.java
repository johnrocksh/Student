/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Menu {
     
   static StudentManager studentManager;
    //////////////PressEnyKey  -- ожидаем нажатие любой клавиши от пользователя
    public void PressEnyKey() {

        Scanner in = new Scanner(System.in);
        char c = in.next().charAt(0);

    }
    

    ////////////// Menu  -   
    public void Menu() {

        StudentManager studentManager = new StudentManager();
        System.out.println("\n\n---------------------STUDENT LIST--------------------");

        System.out.println(" 1 : Add new Student ");
        System.out.println(" 2 : Delete Student");
        System.out.println(" 3 : Show all Students");
        System.out.println(" 4 : EditStudent");
        System.out.println(" 5 : Find Student");
        System.out.println(" 6 : Save to File");
        System.out.println(" 7: Exit");
        System.out.println("\n---maximum number of students:" + studentManager.lengthStudentList + " ---------------------------");
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
    public void ExitMenu() {
        System.exit(0);
    }

    
    
    /////////////// SwitchMenu - 
    public int SwitchMenu(int menuNumber) {
        
        FileStudentList fileStudentList =new FileStudentList();
      
        switch (menuNumber) {
            case 1: {

                studentManager.AddNewStudent();
                break;

            }
            case 2: {
                studentManager.DeleteStudent();
                break;

            }
            case 3: {
                studentManager.ShowStudentList();
                break;

            }

            case 4: {
                studentManager.EditStudent();
                break;

            }
            case 5: {
                System.out.println(" Find Student");
                break;

            }

            case 6: {
                fileStudentList.SaveToFile(studentManager);
                break;

            }
            case 7: {
                System.out.println(" Exit");
                ExitMenu();
                break;

            }

        }
        return menuNumber;
    }

    ///////////////// ShowMenu -  
    public void ShowMenu() {
        StudentManager studentManager = new StudentManager();
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

                if (menuNumber <= studentManager.StudentList.length) {
                    
                    SwitchMenu(menuNumber);
                    System.out.println("PressEnyKey...");//ожидаем нажатия клавиши  
                    PressEnyKey();
                }
            }

        }
    }
 public static void main(String[] args) {
        studentManager = new StudentManager();
        Menu menu = new Menu();
        FileStudentList fileStudentList=new FileStudentList();
       studentManager= fileStudentList.getStudentListFromFile(studentManager);
    //  System.out.println("ok "+studentManager.StudentList[0].name); 
        menu.ShowMenu();

    }

}
