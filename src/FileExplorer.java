package explorer;
import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * A class to represent a file explorer.
 * @author wellswa
 * 
 * note: requires .swing and .awt for UI.
 *
 */
@SuppressWarnings("serial")
public class FileExplorer extends JFrame{

    private JTree fileTree;
    private JTable fileTable;
    private JPanel contentPane;
    
    private JScrollPane treeSP;
    private JScrollPane tableSP;

    private DefaultMutableTreeNode rootNode;
    private FileTableModel tableModel;
    
    /**
     * Default constructor. Builds the explorer app.
     */
    public FileExplorer() {
        
        buildComponents();
        
        
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("File Explorer");
        
        this.setVisible(true);
    }
    
    
    /**
     * Generates the GUI components.
     */
    private void buildComponents() {
        //borderlayout with horizontal padding of 5
        contentPane = new JPanel(new BorderLayout(5, 0));
        this.setContentPane(contentPane);
       
        //create Computer home directory as root
        rootNode = new DefaultMutableTreeNode("My Computer");
        fileTree = new JTree(rootNode);
        treeSP = new JScrollPane(fileTree);
        
        //contents of selected file tree displayed in table
        tableModel = new FileTableModel();
        populateExplorer("/Users/wellswa/Desktop/Backup/Schoolwork");
        fileTable = new JTable(tableModel);
        fileTable.setFillsViewportHeight(true);
        tableSP = new JScrollPane(fileTable);
        
        
        contentPane.add(treeSP, BorderLayout.WEST);
        contentPane.add(tableSP, BorderLayout.CENTER);
        

    }
    
    
    /**
     * Explores all subfolders and files recursively, populating the file explorer.
     */
    private void populateExplorer(String path) {
                
        File root = new File(path);
        
        File[] roots = root.listFiles();
        
        
        for (File current: roots) {
            
            if (current.isDirectory()) 
            {
                rootNode.add(new DefaultMutableTreeNode(current.getName()));
                populateExplorer(current.getAbsolutePath());
                
            } 
            else 
            {
                Object[] rowData = { current.getName(), current.length(), "toDO", current.lastModified() };
                tableModel.addRow(rowData);
                
            }

        }
        
    }
    

    
    
    
    
    
}
