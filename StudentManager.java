package student;

import java.util.Arrays;
import java.util.Scanner;//подключаем для ввода данных с консоли

/**
 * Класс StudenMAnager - *
 */
public class StudentManager {

    final int lengthStudentList = 20;
    public int studentCounter = 0;
    public Student[] studentList = new Student[lengthStudentList];

    public StudentManager() {
        
    }

//    void sortByName(){
//    String name[]= new String[studentCounter];
//    Student[] temp =new Student[lengthStudentList];
//    //1 copy names from StudentList to name[] array
//     for(int i=0;i<studentCounter;i++){
//               name[i]=studentList[i].studentName;
//     }
//    //выведим на экран 
//    for(String str:name){
//        System.out.println(str);
//    }
//    //2 sort name[]
//     Arrays.sort(name);
//     System.out.println("sort");
//      for(String str:name){
//        System.out.println(str);
//    }
//    for(int i=0;i<studentCounter;i++){
//      for (int j=0;j<studentCounter;j++){
//      
//       if(name[i].equals(studentList[j].studentName)){
//      
//         //еслин нашли совпадение то закидываем в новый аррэй
//       temp[i]=studentList[j];
//       }
//       }
//    }
//    studentList=temp;
//   }
// 
    
    void editStudent() {

        Menu menu = new Menu();

        System.out.println("\n---------------Edit Student....----------------------");
        System.out.println("Now count of student list is:" + studentCounter);
        showStudentList();
        System.out.println("\nPlease enter Students index  to Edit:");
        System.out.println("Or press 'm' back to menu...");

        Scanner in = new Scanner(System.in);

        int studentNumber = in.nextInt();

        if (studentNumber == -1) {//если ввели m то выходим в меню
            menu.showMenu();
        }

        if (studentNumber != -1) {
            studentNumber -= 1;

            if ((studentNumber >= 0) && (studentNumber <= studentCounter)) {

                editStudentDirectly(studentNumber);//Редактируем студента и выводим новый список
                System.out.println("studentNumber=" + studentNumber);

            } else {
                System.out.println("Enter correct student Number from 0 to " + studentCounter + "\n Enter  'm'  to  menu...:");

            }
        } else {
            //если  PressedKey =-1 значит это не число и нужно попробовать еще раз или выйти в меню
            System.out.println("Error! You entered symbol but not digit. Please enter integer from 0 to " + studentCounter + " or 'm' to exit to main menu...:");

        }

    }

    void editStudentDirectly(int studentNumber) {
        String newName;
        String newCity;
        String newAge;
        String newTel;
        String newEmail;
        String newPaid;

        String defiz = "-";

        Scanner scName = new Scanner(System.in);
        Scanner scCity = new Scanner(System.in);
        Scanner scAge = new Scanner(System.in);
        Scanner scTel = new Scanner(System.in);
        Scanner scEmail = new Scanner(System.in);
        Scanner scPaid = new Scanner(System.in);

        System.out.println("\nname:" + studentList[studentNumber].studentName + " \nCity: " + studentList[studentNumber].studentAddress
                + "\nAge:" + studentList[studentNumber].studentAge + "\n Tel:" + studentList[studentNumber].studentTel
                + "\n Email:" + studentList[studentNumber].studentEmail + "\nPaid:" + studentList[studentNumber].studentPaidContract);

        System.out.println("Enter NEW NAME or '-' to skip:");
        newName = scName.nextLine();

        System.out.println("Enter NEW CITY or '-' to skip:");
        newCity = scCity.nextLine();

        System.out.println("Enter NEW AGE or '-' to skip:");
        newAge = scAge.nextLine();

        System.out.println("Enter NEW TEL or '-' to skip");
        newTel = scTel.nextLine();

        System.out.println("Enter NEW EMAIL or '-' to skip");
        newEmail = scEmail.nextLine();

        System.out.println("Enter TRUE/ELSE student paid Contract:");
        newPaid = scPaid.nextLine();

        if (!newName.equals("-")) {

            studentList[studentNumber].studentName = newName;
        } else {
            System.out.println("newName=='-'");

        }

        if (!newCity.equals("-")) {
            studentList[studentNumber].studentAddress = newCity;
        }

        if (!newAge.equals("-")) {
            try {

                studentList[studentNumber].studentAge = Integer.parseInt(newAge);
            } catch (NumberFormatException e) {
                System.out.println("Error! Enter correct digit StudentAge!");

            }
        }

        if (!newTel.equals("-")) {
            studentList[studentNumber].studentTel = newTel;
        }
        if (!newEmail.equals("-")) {
            studentList[studentNumber].studentEmail = newEmail;
        }
        if (!newPaid.equals("-")) {
            studentList[studentNumber].studentPaidContract = Boolean.parseBoolean(newPaid);
        }

        showStudentList();

    }

    /////////////////delete directly
    void deleteStudentDirectly(int deletedStudentNumber) {
        Student[] newStudentList = new Student[lengthStudentList];//выделяем память для массива в котором будем сохронять новый список студентов

        //создали новый массив 
        System.out.println("---------------------------");
        for (int i = 0; i < lengthStudentList; i++) {
            newStudentList[i] = new Student("_", "_", 0, "_", "_", false);
            //System.out.println("newStudentList["+i+"].name="+newStudentList[i].name+"  newStudentList["+i+"].city="+newStudentList[i].city+"  newStudentList["+i+"].age="+newStudentList[i].age);
        }
        System.out.println("---------------------------");

        for (int i = 0, j = 0; i < studentCounter; i++) {
            if (i == deletedStudentNumber) {
            } else {
                newStudentList[j] = studentList[i];
                j++;
            }
        }

        studentCounter--;
        studentList = newStudentList;

    }// end deleteStudentDirectly

    //////////////////DeleteStudent() ---- 
    /*
	вводим символ с клавиатуры и проверяем его если это чилос в нужном диапозоне 
	если да то удаляем студента если нет то идем покругу... 
     */
    public void deleteStudent() {
        Menu menu = new Menu();
        int studentNumber;
        Scanner scanStudentNumber = new Scanner(System.in);

        System.out.println(" ---------------- Delete  Student ----------------- ");
        showStudentList();

        //---------------- проверяем если было введено число и если оно в правильном диапозоне
        while (true) {
            System.out.print("\n Please select the student number you want to delete....:");
            System.out.println("\n Or press '-1' back to menu...");
            Scanner in = new Scanner(System.in);//cчитываем пункт меню в char проверяем если это число и если оно меньше длины нашего массмва

            studentNumber = in.nextInt();

            if (studentNumber == -1) {//если ввели m то выходим в меню
                menu.showMenu();
            }

            if (studentNumber != -1) {
                studentNumber -= 1;
                if ((studentNumber >= 0) && (studentNumber <= studentCounter)) {

                    deleteStudentDirectly(studentNumber);//удаляем студента и выводим новый список

                    showStudentList();
                } else {
                    System.out.println("Enter correct student Number from 0 to" + studentCounter + " or 'm' for exit too main menu...:");
                }
            } else {
                //если  PressedKey =-1 значит это не число и нужно попробовать еще раз или выйти в меню
                System.out.println("Error! You entered symbol but not digit. Please enter integer from 0 to " + studentCounter + " or 'm' to exit to main menu...:");
            }

        }
    }

    //////////////// 
    public void addNewStudent() {

        Scanner scanName = new Scanner(System.in);
        Scanner scanCyti = new Scanner(System.in);
        Scanner scanAge = new Scanner(System.in);
        Scanner scanTel = new Scanner(System.in);
        Scanner scanEmail = new Scanner(System.in);
        Scanner scanPaidContract = new Scanner(System.in);

        int age;
        String name;
        String city;
        String tel;
        String email;
        Boolean paid;

        System.out.println(" ---------------- Add new Student ----------------- ");
        System.out.println("Now count of student list is:" + studentCounter);

        if (studentCounter < studentList.length) {//если мы не достигли предела нашего списка то добавляем нового студента

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

            System.out.print("Enter tel:");
            tel = scanTel.next();

            System.out.print("Enter email:");
            email = scanEmail.next();

            System.out.println("Enter true(false) if student paid(or not) contract:");
            paid = scanPaidContract.nextBoolean();

            studentList[studentCounter] = new Student(name, city, age, tel, email, paid);
            System.out.println("# Student was added successfully!");

            studentCounter++;//увеличиваем счетчик
        } else {
            System.out.println("Sorry :(   StudentList is Full!");
        }

    }

    ////////////// Show StudentList
    public void showStudentList() {

        System.out.println("------------------------------------BEGIN STUDENT LIST-----------------------------------------------");
        System.out.println();
        // System.out.println("ID            "+"NAME          "+"ADDRESS       "+"AGE           ");
        String name = "NAME", adress = "ADRESS", age = "AGE", id = "ID", tel = "TEL",
                email = "EMAIL", paid = "PAID CONTRACT";
        System.out.printf("%3s | %-15s | %-10s | %-10s | %-10s | %-20s | %-5s |\n\n",
                id, name, adress, age, tel, email, paid);
      //  System.out.println("studentList.length"+studentList.);
        for (int i = 0; i < studentCounter; i++) {
            // System.out.println(i+1+ "              " + StudentList[i].studentName +"              "+ StudentList[i].studentAddress +"              "+ StudentList[i].studentAge);
            System.out.printf("%3d | %-15s | %-10s | %-10d | %-10s | %-20s | %-13s |\n", i + 1, studentList[i].studentName,
                    studentList[i].studentAddress, studentList[i].studentAge, studentList[i].studentTel,
                    studentList[i].studentEmail, studentList[i].studentPaidContract);
        }
        System.out.println("");
        System.out.println("------------------------------------END STUDENT LIST---------------------------------------------");

    }

////////////////////
}
