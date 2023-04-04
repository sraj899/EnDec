import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.Font;
import java.beans.JavaBean;


public class EncryptionProject {

    public static void operate(int key)
{
    JFileChooser fileChooser=new JFileChooser();
    fileChooser.showOpenDialog(null);
    File file=fileChooser.getSelectedFile();
    try{
        FileInputStream fis=new FileInputStream(file);
        byte []data=new byte[fis.available()];
        fis.read(data);
        int i=0;
        for(byte b:data)
        {
            data[i]=(byte)(b^key);
            i++;

        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
        fis.close();
        JOptionPane.showMessageDialog(null,"Encrypted");
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}
    public static void main(String[] args) {
        JFrame f=new JFrame();
        ImageIcon img=new ImageIcon("C:/Users/RAJ/Desktop/endec.jpg");
        JLabel bg=new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,800,900);
        //Image img = Toolkit.getDefaultToolkit().getImage("C:/Users/RAJ/Desktop");
        f.setTitle("Encrypt & Decrypt");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Bahamas",Font.BOLD,30);
        
        JButton button=new JButton();
        button.setText("Open File");
        button.setFont(font);

        JTextField textField=new JTextField(10);
        textField.setFont(font);

        f.setLayout(new FlowLayout());

        
        JLabel label1=new JLabel();
        label1.setText("Enter a numeric key below and click Open File to encrypt");

        button.addActionListener(e->{
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);

        });

        f.add(bg);
        f.add(label1);
        f.add(textField);
        f.add(button);


        f.setVisible(true);


    }
    
}
