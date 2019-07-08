package student;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;//для очистки экрана
import java.util.ArrayList;

/*
/мнк нужно считать строку 
разобрать ее на 3 строки до ;  и записать в аррэй Student
Для этого я вызываю из студент метод  в который передаю фай для чтения и который возвращает 
аррэй типа студент    уже заполненный
 */
public class FileIO { // 1. studentservice // studentIO

    String path = "src/student/StudentList.txt";
    private final ArrayList<String> arrayListStudent = new ArrayList();

    public ArrayList getArrayListStudent() {
        return arrayListStudent;
    }

    public StudentManager parsingStudentLine(StudentManager studentManager) {
        System.out.println("Otladka!!!!");

        System.out.println("arrayListStudent.size()" + arrayListStudent.size());

        for (int i = 0; i < arrayListStudent.size(); i++) {
            System.out.println("i:" + i);
            System.out.println("arrayListStudent.get(i)" + arrayListStudent.get(i));;

            String str = arrayListStudent.get(i);
            String[] output = str.split(";");
            //  System.out.println("tempStudentList[i]"+tempStudentList[i]);

            studentManager.studentList[i] = new Student(output[0], output[1], Integer.parseInt(output[2]),
                    output[3], output[4], Boolean.parseBoolean(output[5]));
            studentManager.studentCounter++;
            System.out.println("studentManager.studentCounter" + studentManager.studentCounter);
        }

        return studentManager;
    }

    public ArrayList getStudentListFromFile(StudentManager studentManager) {

        String line;
        String FileStudentList = "";
        try {
            FileReader input = new FileReader(path);
            BufferedReader reader = new BufferedReader(new FileReader(path));

            try {
                // System.out.println(path);
                while ((line = reader.readLine()) != null) {
                    arrayListStudent.add(line);
                }

            } catch (IOException e) {

                System.out.println("IOException!!!");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!!!");

        }

//        for (int i = 0; i < arrayListStudent.size(); i++) {
//
//            System.out.println(arrayListStudent.get(i));
//
//        }
        return arrayListStudent;
    }

    void saveToFile(StudentManager studentManager) {
        File file = new File(path);
        int counter = 0;
        FileWriter writer;
        BufferedWriter bufferWriter;
        //
        try {
            writer = new FileWriter(file.getAbsolutePath());
            bufferWriter = new BufferedWriter(writer);
            if (file.exists()) {  //

                System.out.println("File exist write to file!");
                System.out.println(studentManager.studentCounter);
                while (counter != studentManager.studentCounter) {
                    bufferWriter.write(studentManager.studentList[counter].studentName + ";"
                            + studentManager.studentList[counter].studentAddress + ";"
                            + studentManager.studentList[counter].studentAge + ";"
                            + studentManager.studentList[counter].studentTel + ";"
                            + studentManager.studentList[counter].studentEmail + ";"
                            + studentManager.studentList[counter].studentPaidContract + ";");
                    bufferWriter.newLine();
                    counter++;
                }
                bufferWriter.close();
                writer.close();

            } else {
                file.createNewFile();
                System.out.println("File dose not exist!, creating new file...");

            }

        } catch (IOException e) {
        }

    }

}
