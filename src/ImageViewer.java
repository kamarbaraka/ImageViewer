
/*A simple program to view image files*/

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**created by {@author kamar baraka}
 * @version 1.0*/
public class ImageViewer {
    /**the main method
     * @param args
     * takes an array of string arguments
     * returns{@return void}
     */
    public static void main(String[] args){
        JFrame image = new ImageFrame();

        image.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        image.setSize(300, 300);
        image.setVisible(true);
    }
}

class ImageFrame extends JFrame
    implements ActionListener{
    int imageHeight, imageWidth;
    String theImagePath, theTitle;
    JLabel label;
    JFileChooser chooser;
    JMenuBar menubar;
    JMenu fileMenu;
    JMenuItem openMenuItem;
    ImageIcon icon;

    public ImageFrame(){
        theTitle = theImagePath;
        setTitle(theTitle);
        imageWidth = 300; imageHeight = 300;
        setSize(imageWidth, imageHeight);
//        JFrame frame = new JFrame(theTitle);
        label = new JLabel();
        add(label);

//        set up the file chooser
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        //set up the menu bar
        menubar = new JMenuBar();
        setJMenuBar(menubar);

        fileMenu = new JMenu("File");
        menubar.add(fileMenu);

        openMenuItem = new JMenuItem("Open");
        fileMenu.add(openMenuItem);
        openMenuItem.addActionListener(this);
    }

    /**@param event
     * takes an ActionEvent object as argument*/
    public void actionPerformed(ActionEvent event){
        //define the action taken when open menu item is clicked
        if (event.getSource() == openMenuItem){
            //show file chooser dialogue
            int result = chooser.showOpenDialog(null);

            //if file selected set it as the icon of the label
            if (result == JFileChooser.APPROVE_OPTION){
                theImagePath = chooser.getSelectedFile().getPath();
                icon = new ImageIcon(theImagePath);

                imageHeight = icon.getIconHeight();
                imageWidth = icon.getIconWidth();

                setSize(imageWidth, imageHeight);

                label.setIcon(icon);
            }
        }
    }
}
