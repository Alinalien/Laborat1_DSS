/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creation;

import java.util.ArrayList;

/**
 *
 * @author Alina
 */
public abstract class Polzovatel {
    
    private String CompleteName;                                       // считываем полное имя пользователя библиотеки в переменную
    private ArrayList<Knigi> kniga = new ArrayList<>();                // беру список книг
    
    public Polzovatel(String CompleteName) {                           // присваиваем имя пользователю
        this.CompleteName = CompleteName;
    }
    public String getCompleteName() {                                  // гетеры - сетеры
        return CompleteName;
    }

    public void setCompleteName(String CompleteName) {                 
        this.CompleteName = CompleteName;
    }

    public ArrayList<Knigi> getKnigi() {                               // гетеры - сетеры
        return kniga;
    }

    public void setKnigi(ArrayList<Knigi> books) {
        this.kniga = kniga;
    }

    abstract void TakeKniga(ArrayList<Knigi> kniga);
    
     

    
}
