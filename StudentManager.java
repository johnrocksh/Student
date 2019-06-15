package student;

import java.util.Scanner;//подключаем для ввода данных с консоли
import java.io.IOException;//для очистки экрана

/**
 * Класс Student это демонстрация работы с массивами строк в java класс
 * осуществляет удаление добавление редактирование и поиск студентов в массив
 * можно добавить нового студента можно его удалить или просто просмотреть
 * список всех студентов... *
 */
public class StudentManager {

    final int lengthStudentList = 20;
    public  int studentCounter = 0;
    Student[] StudentList = new Student[lengthStudentList];

    public StudentManager() {
    }

    void EditStudent() {

        Menu menu = new Menu();

        System.out.println("\n---------------Edit Student....----------------------");
        System.out.println("Now count of student list is:" + studentCounter);
        ShowStudentList();
        System.out.println("\nPlease enter Students index  to Edit:");
        System.out.println("Or press 'm' back to menu...");

        Scanner in = new Scanner(System.in);
        char PressedKey = in.next().charAt(0);
        int studentNumber = menu.pressedKeyIsNumber(PressedKey);

        if (PressedKey == 'm') {//если ввели m то выходим в меню
            menu.ShowMenu();
        }

        if (studentNumber != -1) {

            if ((studentNumber >= 0) && (studentNumber <= studentCounter)) {

                EditStudentDirectly(studentNumber);//Редактируем студента и выводим новый список

            } else {
                System.out.println("Enter correct student Number from 0 to " + studentCounter + "\n Enter  'm'  to  menu...:");

            }
        } else {
            //если  PressedKey =-1 значит это не число и нужно попробовать еще раз или выйти в меню
            System.out.println("Error! You entered symbol but not digit. Please enter integer from 0 to " + studentCounter + " or 'm' to exit to main menu...:");

        }

    }

    void EditStudentDirectly(int studentNumber) {
        String newName;
        String newCity;
        String newAge;
        String defiz = "-";

        Scanner scName = new Scanner(System.in);
        Scanner scCity = new Scanner(System.in);
        Scanner scAge = new Scanner(System.in);

        System.out.println("\nname:" + StudentList[studentNumber].name + " \nCity: " + StudentList[studentNumber].city + "\nAge:" + StudentList[studentNumber].age);

        System.out.println("Enter NEW NAME or '-' to skip:");
        newName = scName.nextLine();

        System.out.println("Enter NEW CITY or '-' to skip:");
        newCity = scCity.nextLine();

        System.out.println("Enter NEW AGE or '-' to skip:");
        newAge = scAge.nextLine();

        if (!newName.equals("-")) {

            StudentList[studentNumber].name = newName;
        } else {
            System.out.println("newName=='-'");

        }

        if (!newCity.equals("-")) {
            StudentList[studentNumber].city = newCity;
        }

        if (!newAge.equals("-")) {
            try {

                StudentList[studentNumber].age = Integer.parseInt(newAge);
            } catch (Exception e) {
                System.out.println("Error! Enter correct digit StudentAge!");

            }
        }

        ShowStudentList();

    }

    /////////////////delete directly
    void DeleteStudentDirectly(int deletedStudentNumber) {
        Student[] newStudentList = new Student[lengthStudentList];//выделяем память для массива в котором будем сохронять новый список студентов

        System.out.println("Executed DeleteStudentDirectly");
        System.out.println("deletedStudentNumber:" + deletedStudentNumber);

        //создали новый массив 
        System.out.println("Creation  newStudentList... ");
        System.out.println("---------------------------");
        for (int i = 0; i < lengthStudentList; i++) {
            newStudentList[i] = new Student("_", "_", 0);
            //System.out.println("newStudentList["+i+"].name="+newStudentList[i].name+"  newStudentList["+i+"].city="+newStudentList[i].city+"  newStudentList["+i+"].age="+newStudentList[i].age);
        }
        System.out.println("---------------------------");

        for (int i = 0, j = 0; i < studentCounter; i++) {
            if (i == deletedStudentNumber) {
                continue;
            } else {
                newStudentList[j] = StudentList[i];
                j++;
            }
        }

        System.out.println("");
        System.out.println("---------------------------");

        studentCounter--;
        StudentList = newStudentList;

    }// end deleteStudentDirectly

    //////////////////DeleteStudent() ---- 
    /*
	вводим символ с клавиатуры и проверяем его если это чилос в нужном диапозоне 
	если да то удаляем студента если нет то идем покругу... 
     */
    public void DeleteStudent() {
        Menu menu = new Menu();
        int studentNumber;
        Scanner scanStudentNumber = new Scanner(System.in);

        System.out.println(" ---------------- Delete  Student ----------------- ");
        ShowStudentList();

        //---------------- проверяем если было введено число и если оно в правильном диапозоне
        while (true) {
            System.out.print("\n Please select the student number you want to delete....:");
            System.out.println("\n Or press 'm' back to menu...");
            Scanner in = new Scanner(System.in);//cчитываем пункт меню в char проверяем если это число и если оно меньше длины нашего массмва
            char PressedKey = in.next().charAt(0);
            studentNumber = menu.pressedKeyIsNumber(PressedKey);

            if (PressedKey == 'm') {//если ввели m то выходим в меню
                menu.ShowMenu();
            }

            if (studentNumber != -1) {

                if ((studentNumber >= 0) && (studentNumber <= studentCounter)) {

                    DeleteStudentDirectly(studentNumber);//удаляем студента и выводим новый список

                    for (int i = 0; i < studentCounter; i++) {
                        System.out.println(i + ":" + StudentList[i].name + "|" + StudentList[i].city + "|" + StudentList[i].age + "|");

                    }
                } else {
                    System.out.println("Enter correct student Number from 0 to" + studentCounter + " or 'm' for exit too main menu...:");
                    continue;
                }
            } else {
                //если  PressedKey =-1 значит это не число и нужно попробовать еще раз или выйти в меню
                System.out.println("Error! You entered symbol but not digit. Please enter integer from 0 to " + studentCounter + " or 'm' to exit to main menu...:");
                continue;
            }

        }
    }

    //////////////// 
    public void AddNewStudent() {

        Scanner scanName = new Scanner(System.in);
        Scanner scanCyti = new Scanner(System.in);
        Scanner scanAge = new Scanner(System.in);
        int age;
        String name;
        String city;

        System.out.println(" ---------------- Add new Student ----------------- ");
        System.out.println("Now count of student list is:" + studentCounter);

        if (studentCounter < StudentList.length) {//если мы не достигли предела нашего списка то добавляем нового студента

            System.out.print("Enter  student name:");
            name = scanName.next();

            System.out.print("Enter city:");
            city = scanCyti.next();

            System.out.print("Enter age:");
            try {
                age = scanAge.nextInt();
            } catch (Exception e) {
                System.out.println("Error! Incorrect age... Please enter correct age data////");
                // AddNewStudent();//вызываю рекурсивно функцию для повторного ввода 
                return;
            }

            StudentList[studentCounter] = new Student(name, city, age);
            System.out.println("# Student was added successfully!");

            studentCounter++;//увеличиваем счетчик
        } else {
            System.out.println("Sorry :(   StudentList is Full!");
        }

    }

    ////////////// Show StudentList
    public void ShowStudentList() {

        System.out.println("------------Begin of StudentList---------------");

        for (int i = 0; i < studentCounter; i++) {
            System.out.println(i + ":" + StudentList[i].name + "|" + StudentList[i].city + "|" + StudentList[i].age + "|");

        }
        System.out.println("------------ End of StudentList---------------");

    }

////////////////////
   
}
