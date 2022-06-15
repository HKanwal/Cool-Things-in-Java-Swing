import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class LandingPage extends JFrame {
    private final int width = 500;
    private final int height = 200;
    private HashMap<String, App> apps = new HashMap<>();

    public LandingPage() {
        apps.put("Greeting Generator", new GreetingGenerator());
        apps.put("Pinger", new Pinger());
        apps.put("Key Code Identifier", new KeyCodeIdentifier());

        JLabel title = new JLabel("Cool Things in Java Swing");
        title.setBounds(0, 40, width, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("Open the 'Apps' menu to browse apps.");
        subtitle.setBounds(0, 80, width, 30);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JMenu menu = new JMenu("Apps");
        apps.forEach((name, app) -> {
            JMenuItem menuItem = new JMenuItem(name);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    app.open();
                }
            });
            menu.add(menuItem);
        });

        JMenuBar menuBar = new JMenuBar();
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
}
