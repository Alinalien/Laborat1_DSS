/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creation;

/**
 *
 * @author Alina
 */
public abstract class Knigi {
    
    private String CompleteName;             // переменная, будем записывать название книги
    
    public Knigi(String fullName) {          // считываем название книги и записываем его
        this.CompleteName = fullName;
    }

    public String getCompleteName() {        // гетеры - сетеры
        return CompleteName;
    }

    public void setCompleteName(String CompleteName) {
        this.CompleteName = CompleteName;
    }
    

    
}
