package Metodos;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TablaBotones extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

      if(value instanceof JButton){
          JButton boton = (JButton)value;
          return boton;

        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

}
