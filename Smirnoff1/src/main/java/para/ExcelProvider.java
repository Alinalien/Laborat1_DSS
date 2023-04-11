//package smirnoff1;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//
//    public class ExcelProvider {
//    
//    private File file;
//    private XSSFWorkbook wb;
//    private Journal journal;
//    
//    public ExcelProvider() {       // конструктор без входных аргументов, который вызывает метод инициализации
//      init();
//    }
//
//    public ExcelProvider(String srcmainjavainformФИОxlsx) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//        
//    private void init() {          // указываем файл с оценками, который хотим закачивать
//       setFile(new File("Статистика_свод_2022.xlsx"));
//    }
//            
//    public void run() throws IOException, InvalidFormatException {            // метод, осуществляюзий запуск. 3 подметода:
//       loadFile();                 // загрузка файла, то есть, создание вб, который будет в себя аккумулировать (накапливать) инфу про наш файл
//       readSheets();               // разбор листов и чтение информации с них
//       close();                    // разрыв соединения с файлом
//    }
// 
//    public File getFile() {    
//        return file;
//        }
//    
//    private void setFile(File file) {     
//    this.file = file;
//    }
//     
//    public void loadFile()  {                                                             //создание вб из файла
//        try {    
//            wb = new XSSFWorkbook(file);
//        } catch (IOException ex) {                                                        // ошибка чтения файла
//             Logger.getLogger(ExcelProvider.class.getName()).log(Level.SEVERE, null, ex);       
//        } catch (InvalidFormatException ex) {                                             // ошибка POI, если файл другого формата, не того, который нужен, т.е. не XLSX
//          Logger.getLogger(ExcelProvider.class.getName()).log(Level.SEVERE, null,ex);
//        } 
//        
//    }
//    private void readSheets() {                         // обработка данных
//        int N = wb.getNumberOfSheets();                 // вб прочитан, записан в эксель_провайдер, обращаемся к вб и спрашиваем, сколько в нем листов, каждый лист - отдельная группа
//        journal = new Journal();                        // новый класс, пока пустой, который будет отображать элементы предметной области, ведомость, тут будет вся инфа про группы, студентов и оценки
//        for (int i = 0; i < N; i++) {                   // запускаем цикл, в котором пробегаем все листы (N = количеству листов)
//            XSSFSheet sheet = wb.getSheetAt(i);         // считываем лист из вб
//            String name = sheet.getSheetName();         // считываем имя листа, оно совпадает с номером группы, поэтому используем это для создания группы
//            journal.addGroup(name);                     // создание группы, передаем имя в журнал
//            getHeader(sheet);                           // получить заголовок таблички
//            getTable(sheet);                            // получить саму табличку
//        }
//    }
//    
//    private void close() {
//        try {
//             wb.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ExcelProvider.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    private void getHeader(XSSFSheet sheet) {           // в заголовок передаем лист
//        XSSFRow header = sheet.getRow(0);               // читаем первую строчу с листа, заголовок листа содержит названия работ, при этом, в разных группах - они разные
//        int C = header.getLastCellNum();                // передаёт, сколько есть ячеек в строчке, записываем это число в переменную С
//        ArrayList<String> tasknames = new ArrayList();  // формируем пустой список названий работ
//        
//        for (int i = 2; i < C; i++) {                   // цикл идёт с i = 2, т. к. первые две ячейки в заголовке пустые (а мы считаем с нулевой)
//            XSSFCell cell = header.getCell(i);          // считываем cell из первой строчки
//            tasknames.add(cell.getStringCellValue());   // записываем в список названий информацию, полученную из ячейки cell, в виде String-а
//        }
//        journal.setTasks(tasknames);                    // записываем в журнал перечень названий работ
//    }
//    
//    private void getTable(XSSFSheet sheet) {            // необходимо прочитать остальные столбцы
//        int R = sheet.getLastRowNum();                  // переменная R =  количеству строк на листе, т.е. сколько у нас студентов в группе
//        
//        
//        for (int j = 1; j < R; j++) {                   // цикл начинается не с 0, так как первую строчку(заголовок) мы уже обработали
//            XSSFRow row = sheet.getRow(j);              // читаем строчку и делим её на две части
//            getObservation(row);                        // информация про студентов
//            getValues(row);                             // численные данные, относящиеся к оценкам за работы
//        }           
//                                                        // разделяем на 2 части, т.к когда читаем Обзервейшн, нам нужно создать агента(???)
//    }
//    
//    private void getObservation(XSSFRow row) {          
//        int number = (int)row.getCell(0).getNumericCellValue();  // из первой ячейки получаем числовую информацию (индекс студента); перерводим в int, тк числовая информация по умолчанию читается в формате double и записываем в number
//        String FIO = row.getCell(1).getStringCellValue();        // из второй ячейки получаем ФИО студента
//        journal.addStudent(number, FIO);                         // добавляем студента ( в журнале )
//    }
//
//    private void getValues(XSSFRow row) {                        
//        int C = row.getLastCellNum();                            //получаем информацию про количество ячеек в записи
//        for (int i = 2; i < (C-1); i++) {                        // пробегаем цикл с i = 2, т.е. с первой оценки за работу, не включая столбец с итоговыми оценками за семестр
//            XSSFCell cell = row.getCell(i);                      // считываем ячейку
//            double mark = cell.getNumericCellValue();            // считываем оценку, как информацию из этой ячейки, как численная переменная, не меняем на int, т. к. есть оценки с дробной частью
//            journal.writeMark(mark);                             // записываем оценки в журнал
//        }
//        XSSFCell cell = row.getCell(C-1);                        // считываем оценку
//        String fmark = cell.getStringCellValue();                //  fmark - финальная оценка, 
//        journal.setFinalMark(fmark);                             // записываем в журнал финальную оценку
//    }
//    public Journal getJournal() {                                // получаем заполненный журнал
//       return journal;
//   }
//    
//
// }
//
