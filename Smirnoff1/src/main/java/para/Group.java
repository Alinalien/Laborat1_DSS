package para;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 *
 * @author Alina
 */
public class Group {
//    private ArrayList<Student> students;   //список студентов
//    private String name;                   // имя
//    private ArrayList<String> tasknames;   // список названий заданий
//    private Student activestudent;
//    private int markcounter;
//
//    Group(String name) {                   // создаем группу и её имя
//        this.name = name;
//        students = new ArrayList();        // инициализируем студентов
//    }
//    
//    public void setTasknames(ArrayList<String> tasknames) {
//        this.tasknames = tasknames;
//    }
//    
//    public void addStudent(int number, String FIO) {         // создаём студента
//        Student student = new Student(number, FIO);
//        students.add(student);                               // в список студентов группы добавляем созданного студента
//        activestudent = student;                             // активный студент - студент, для которого мы сейчас выписываем оценки
//        markcounter = 0;                                     // сбрасываем счётчик оценок - это внутренний торатор, который показывает, в какой последовательности мы обрабатываем оценки из списка
//    }
//    
//    void writeMark(double mark) {                            
////         activestudent.setMark(tasknames.get(markcounter), mark);     // активная группа достает активного студента, берёт свой список заданий, извлекает из списка заданий оценку с номером markcounter
//         markcounter++;                                               // markcounter увеличивается на единицу,те, если только начали работать со студентом, то 0(первое задание), если продолжаем работать, то +1
//    }
//
//    void setFinalMark(String fmark) {
//        activestudent.setFinalmark(fmark);
//    }
//
//    public MutableTreeNode getNode() {
//        DefaultMutableTreeNode groupnode = new DefaultMutableTreeNode(name);       // создадим переменную
//        for(Student student : students) {
//           groupnode.add(student.getNode());                                       // студент сам заполняет собственный узел
//        }
//        
//        return groupnode;
//    }
}
