import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LandingPage extends JFrame {
    private final int width = 500;
    private final int height = 200;

    public LandingPage() {
        JLabel title = new JLabel("Cool Things in Java Swing");
        title.setBounds(0, 40, width, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("Open the 'Apps' menu to browse apps.");
        subtitle.setBounds(0, 80, width, 30);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JMenu menu = new JMenu("Apps");
        JMenuItem greetingGenerator = new JMenuItem("Greeting Generator");
        greetingGenerator.addActionListener(new GreetingGeneratorListener());
        JMenuItem pinger = new JMenuItem("Pinger");
        pinger.addActionListener(new PingerListener());
        JMenuBar menuBar = new JMenuBar();

        menu.add(greetingGenerator);
        menu.add(pinger);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        setTitle("Landing Page");
        setSize(width, height);

        add(title);
        add(subtitle);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class GreetingGeneratorListener implements ActionListener {
        GreetingGeneratorListener() {}

        @Override
        public void actionPerformed(ActionEvent e) {
            new GreetingGenerator();
        }
    }

    private class PingerListener implements ActionListener {
        PingerListener() {}

        @Override
        public void actionPerformed(ActionEvent e) {
            new Pinger();
        }
    }
}
