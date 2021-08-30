package Metodos;

/**
 *
 * @author José Pérez
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorearFilas extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel labelResultado = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof String) {
            String Dato = (String) value;
            if (Dato.equals("1") || Dato.equals("2") || Dato.equals("3") || Dato.equals("4") || Dato.equals("5") || Dato.equals("0")) {
                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.red);

            } else {

                labelResultado.setBackground(Color.black);
                labelResultado.setBackground(Color.green);

            }
        }
        return labelResultado;
    }
}
