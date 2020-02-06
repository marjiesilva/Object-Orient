import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class SeperateActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("SeperateActionListener::actionPerformed!");
    }
}

class ButtonFrame extends JFrame implements ActionListener {
    public ButtonFrame() {
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myButtonPanel = new JPanel();
        myButtonPanel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Button 1****************************");
        button1.addActionListener(this);

        JButton button2 = new JButton("Button 2");
        button2.addActionListener(new SeperateActionListener());

        JButton button3 = new JButton("Button 3");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Anonymous::actionPerformed");
            }
        });

        myButtonPanel.add(button1);
        myButtonPanel.add(button2);
        myButtonPanel.add(button3);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(myButtonPanel, BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("mybuttonFrame::actionPerformed!");

    }

}

public class ButtonClick {
    public static void main(String[] args) {
        System.out.println("Hello ButtonCLick!");

        ButtonFrame myButtonFrame = new ButtonFrame();
        myButtonFrame.setVisible(true);
    }
}
