import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyCodeIdentifier extends App {
    private final int width = 500;
    private final int height = 250;
    JLabel output;

    public KeyCodeIdentifier() {
        setTitle("Key Code Identifier");
        setSize(width, height);

        output = new JLabel("Press a Key");
        output.setBounds(0, 0, width, height-20);
        output.setHorizontalAlignment(SwingConstants.CENTER);
        output.setVerticalAlignment(SwingConstants.CENTER);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                return;
            }

            @Override
            public void keyPressed(KeyEvent e) {
                output.setText(String.valueOf(e.getKeyCode()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                return;
            }
        });

        add(output);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
