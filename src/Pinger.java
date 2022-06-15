import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Pinger extends JFrame {
    private final int width = 500;
    private final int height = 250;
    JButton submit;
    JLabel output;

    public Pinger() {
        setTitle("Pinger");
        setSize(width, height);

        JLabel label = new JLabel("Enter a URL:");
        label.setBounds(100, 40, 100, 30);

        JTextField tf = new JTextField();
        tf.setBounds(100, 70, 300, 30);
        tf.addKeyListener(new InpKeyListener());

        submit = new JButton("Ping");
        submit.setBounds(200, 110, 100, 30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(ping(tf.getText()));
            }
        });

        output = new JLabel("");
        output.setBounds(100, 150, 300, 30);

        add(label);
        add(tf);
        add(submit);
        add(output);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private String ping(String urlStr) {
        HttpURLConnection connection = null;

        try {
            URL url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.getContent();
        } catch (MalformedURLException e) {
            output.setForeground(Color.RED);
            return "Unable to parse URL";
        } catch (Exception e) {
            output.setForeground(Color.RED);
            return "Unable to connect";
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        output.setForeground(Color.GREEN);
        return "Pong";
    }

    private class InpKeyListener implements KeyListener {
        InpKeyListener() {}

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                submit.doClick();
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
