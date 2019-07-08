package student;

/**
 * Класс Student это демонстрация работы с массивами строк в java класс
 * осуществляет удаление добавление редактирование и поиск студентов в массив
 * можно добавить нового студента можно его удалить или просто просмотреть
 * список всех студентов... *
 */
public class Student {

    public String  studentName;
    public String  studentAddress;
    public int     studentAge;
    
    public String  studentTel;
    public String  studentEmail;
    public Boolean studentPaidContract;
     
    

    public static int lengthStudentList = 20;
    public byte studentCounter = 0;
    Student[] StudentList = new Student[lengthStudentList];

    public Student() {
    }
    
    public Student(String name, String city, int age,String tel,String email,Boolean paid) {

        this.studentName = name;
        this.studentAddress = city;
        this.studentAge = age;
        this.studentTel =tel;
        this.studentEmail=email;
        this.studentPaidContract=paid;
    }

    //////////////////PressedKeyIsNumber //возвращает StudentNumber или -1 если это не число
}
