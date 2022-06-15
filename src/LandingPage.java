import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage extends JFrame {
    private final int width = 500;
    private final int height = 200;
    private App[] apps = { new GreetingGenerator(), new Pinger(), new KeyCodeIdentifier() };

    public LandingPage() {
        JLabel title = new JLabel("Cool Things in Java Swing");
        title.setBounds(0, 40, width, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("Open the 'Apps' menu to browse apps.");
        subtitle.setBounds(0, 80, width, 30);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JMenu menu = new JMenu("Apps");
        for (int i = 0; i < apps.length; i++) {
            App app = apps[i];
            JMenuItem menuItem = new JMenuItem(app.getTitle());
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    app.open();
                }
            });
            menu.add(menuItem);
        }

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
