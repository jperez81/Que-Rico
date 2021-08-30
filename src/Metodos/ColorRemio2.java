package Metodos;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author José Pérez
 */
public class ColorRemio2 extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel labelResultado = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof String) {
            String Dato = (String) value;
            if (Dato.equals("A")) {
                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.green);

            } else if (Dato.equals("B")) {

                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.yellow);

            } else if (Dato.equals("C")) {
                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.blue);

            } else if (Dato.equals("D")) {
                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.red);
            } else if (Dato.equals("E")) {
                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.lightGray);
            } else {
                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.orange);
            }

        }
        return labelResultado;
    }
}
