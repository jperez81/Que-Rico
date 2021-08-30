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
public class ViajeCerrado extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel labelResultado = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof String) {
            String Dato = (String) value;
            if (Dato.equals("Cerrado")) {
                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.red);

            } else if (Dato.equals("Suspendido")) {

                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.orange);
            } else if (Dato.equals("Proceso")) {
                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.green);

            } else if (Dato.equals("Tratamiento")) {
                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.cyan);
            } else {
                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.gray);
            }

        }
        return labelResultado;
    }

}
