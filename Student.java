package student;

import java.util.Scanner;//подключаем для ввода данных с консоли
import java.io.IOException;//для очистки экрана

/**
 * Класс Student это демонстрация работы с массивами строк в java класс
 * осуществляет удаление добавление редактирование и поиск студентов в массив
 * можно добавить нового студента можно его удалить или просто просмотреть
 * список всех студентов... *
 */
public class Student {

    public String name;
    public String city;
    public int age;

    public static int lengthStudentList = 20;
    static byte studentCounter = 0;
    Student[] StudentList = new Student[lengthStudentList];

    public Student() {
    }

    public Student(String name, String city, int age) {

        this.name = name;
        this.city = city;
        this.age = age;
    }

    //////////////////PressedKeyIsNumber //возвращает StudentNumber или -1 если это не число
}
