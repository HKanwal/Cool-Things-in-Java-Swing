import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GreetingGenerator extends JFrame {
    private JLabel outLabel;
    private JButton button;

    public GreetingGenerator() {
        setTitle("Greeting Generator");
        setSize(500, 230);

        JLabel label = new JLabel("Enter your name:");
        label.setBounds(150, 30, 200, 30);

        JTextField tf = new JTextField();
        tf.setBounds(150, 60, 200, 30);
        tf.addKeyListener(new InpKeyListener());

        button = new JButton("Generate greeting!");
        button.setBounds(175, 100, 150, 30);

        outLabel = new JLabel("");
        outLabel.setBounds(150, 140, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outLabel.setText("Hello " + tf.getText() + "!");
            }
        });

        add(label);
        add(tf);
        add(button);
        add(outLabel);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private class InpKeyListener implements KeyListener {
        InpKeyListener() {}

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                button.doClick();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            return;
        }

        @Override
        public void keyTyped(KeyEvent e) {
            return;
        }
    }
}
