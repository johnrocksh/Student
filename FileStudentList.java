package student;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;//для очистки экрана
import java.util.ArrayList;
import java.nio.file.*;

/*
/мнк нужно считать строку 
разобрать ее на 3 строки до ;  и записать в аррэй Student
Для этого я вызываю из студент метод  в который передаю фай для чтения и который возвращает 
аррэй типа студент    уже заполненный
 */
public class FileStudentList {

    String path = "src/student/StudentList.txt";
    ArrayList<String> arrayListStudent = new ArrayList();

    public StudentManager parsingStudentLine(StudentManager studentManager) {
        
              
        for(int i=0;i<arrayListStudent.size();i++){
       
         
          String str=arrayListStudent.get(i);
          String[] output=str.split(";");
         // System.out.println(output[0]+" "+output[1]+" "+output[2]);
          studentManager.StudentList[i] = new Student(output[0], output[1], Integer.parseInt(output[2]));
          studentManager.studentCounter++;
         // System.out.println(studentManager.StudentList[i].name+" "+studentManager.StudentList[i].city+" "+studentManager.StudentList[i].age);
       }
        
      return   studentManager;
    }

    public StudentManager getStudentListFromFile(StudentManager studentManager) {

        String line = "";
        String FileStudentList = "";
        try {
            FileReader input = new FileReader(path);
            BufferedReader reader = new BufferedReader(new FileReader(path));

            try {
                System.out.println(path);
                while ((line = reader.readLine()) != null) {

                    arrayListStudent.add(line);
                }

            } catch (IOException e) {

                System.out.println("IOException!!!");
            }

        } catch (Exception e) {
            System.out.println("File Not Found!!!");

        }

        for (int i = 0; i < arrayListStudent.size(); i++) {

            System.out.println(arrayListStudent.get(i));

        }
       studentManager= this.parsingStudentLine(studentManager);
       return studentManager;
    }

    void SaveToFile(StudentManager studentManager) {
        //getStudentListFromFile(path);
        File file = new File(path);
        int counter = 0;   
        FileWriter writer;
        BufferedWriter bufferWriter;
       //
        try {
         writer = new FileWriter(file.getAbsolutePath());
         bufferWriter= new BufferedWriter(writer);
            if (file.exists()) {  //
                
                System.out.println("File exist write to file!");
                System.out.println(studentManager.studentCounter);
                while (counter != studentManager.studentCounter) {
                      bufferWriter.write(studentManager.StudentList[counter].name+";"+studentManager.StudentList[counter].city+";"+studentManager.StudentList[counter].age+";");
                      bufferWriter.newLine();
                      counter++;   
                }
                bufferWriter.close();
                writer.close();

            }
            else{
                file.createNewFile();
                System.out.println("File dose not exist!, creating new file...");
                
            
            }

        } catch (Exception e) {
        }
        

    }

}
