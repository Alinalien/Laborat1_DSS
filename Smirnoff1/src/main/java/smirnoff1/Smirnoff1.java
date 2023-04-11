
package smirnoff1;

/**
 *
 * @author Alina
 */
public class Smirnoff1 {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            loadFile dialog = new loadFile(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
}
