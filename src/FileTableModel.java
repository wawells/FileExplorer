package explorer;

import javax.swing.table.DefaultTableModel;

/**
 * A class to represent a file explorer table model.
 * @author wellswa
 *
 */
@SuppressWarnings("serial")
public class FileTableModel extends DefaultTableModel {

    
    
    public FileTableModel() {
        addColumn("Name");
        addColumn("Size");
        addColumn("Type");
        addColumn("Date Modified");
    }

    /**
     * Name, type, and date modified are all strings
     * Size is long
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 2:
            case 3:
                return String.class;
            case 1:
                return Long.class;
            default:
                System.out.println("Ooops");
                return Object.class;
        }
    }

    /**
     * Files are not to be edited at this point. Possibly change later
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
