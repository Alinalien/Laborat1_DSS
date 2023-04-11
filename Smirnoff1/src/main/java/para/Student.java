/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package para;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 *
 * @author Alina
 */
public class Student {
//
//    private int number;                               // номер студента
//    private String FIO;                               // ФИО студента
//    private LinkedHashMap<String, Double> Marks;      // индивидуальный список оценок; HashMap - коллекция, хранит в себе элементы типа "ключ - значение"; ключ - название работы, а value - оценка за него
//    private String finalmark;                         // возьмём итоговую оценку за сем, как атрибут студента
//                             // в LinkedHМ - жёстко упорядоченна пара "ключ - значение", в отлтчии от HM
//
//    public Student(int number, String FIO) {          // конструктор студента
//        this.number = number;                         // запись номера
//        this.FIO = FIO;                               // запись ФИО
//        Marks = new LinkedHashMap();                  // инициализация HashMap
//    }
//
//    
//
//    void setMark(String task, double mark) {          // добавляем новую запись в коллекцию
//        Marks.put(task, mark);                        // Прикол HashMap-а, там не "add", а "put"
//    }
//
//    public void setFinalmark(String finalmark) {
//        this.finalmark = finalmark;
//    }
//
//    public MutableTreeNode getNode() {
//        DefaultMutableTreeNode snode = new DefaultMutableTreeNode(FIO);      // корневой узел студента; добавляем новый узел, состоящий из двуз записей: оценка и еще один узел mnode
//        snode.add(new DefaultMutableTreeNode(finalmark));                    
//        DefaultMutableTreeNode marknode = new DefaultMutableTreeNode();         // узел оценок
//        for (Map.Entry<String, Double> entry : Marks.entrySet())   {
//            String key = entry.getKey();
//            Double val = entry.getValue();                                   // val - оценка
//            String record = key + " : " + val;
//            marknode.add(new DefaultMutableTreeNode(record));
//        }
//        snode.add(marknode);
//        return snode;
//
    }
//
//}
//// с точки зрения классов,и у нас по сути есть КЛАССЫ ГРАФИЧЕСКОГО ОТОБРАЖЕНИЯ giu 
//// предметное отображение : студенты и группы     Мы формируем набор методов которые позволяют отразить это в GUI У нас там был корневой класс журнао который имел один экземпляр, а групп много. внутри журнала список групп. Внутри журнала множество экземпляров групп у них внутри список со студентами. Наша задача сделать так же но в примере только 3 набора ответвлений а у нас их больше 