import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Actividad12Flores extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private Color petalosC = Color.BLACK;
    private List<Integer> coordenadasX = new ArrayList<>();
    private List<Integer> coordenadasY = new ArrayList<>();
    private List<Color> colores = new ArrayList<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Actividad12Flores frame = new Actividad12Flores();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Actividad12Flores() {
        Color moradoC = new Color(141, 58, 211);
        Color azulC = new Color(58, 181, 211);
        Color rojoC = new Color(211, 58, 61);
        Color rosaC = new Color(179, 103, 164);
        Color lilaC = new Color(84, 91, 127);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 680, 720);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(0, 0, 664, 492);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (int i = 0; i < coordenadasX.size(); i++) {
                    int x = coordenadasX.get(i);
                    int y = coordenadasY.get(i);
                    Color color = colores.get(i);

                    g.setColor(new Color(100, 255, 0));
                    g.fillRect(x + 21, y + 40, 10, 90);
                    g.setColor(color);
                    g.fillOval(x - 25, y - 10, 50, 50);
                    g.fillOval(x + 25, y - 10, 50, 50);
                    g.fillOval(x + 15, y + 15, 50, 50);
                    g.fillOval(x - 15, y + 15, 50, 50);
                    g.fillOval(x, y - 25, 50, 50);

                    g.setColor(new Color(255, 220, 0));
                    g.fillOval(x + 5, y + 5, 40, 40);
                }
            }
        };
        panel.add(panel_1, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("Flores");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
        panel.add(lblNewLabel, BorderLayout.NORTH);

        JLabel lblNewLabel_1 = new JLabel("        ");
        panel.add(lblNewLabel_1, BorderLayout.EAST);

        JLabel lblNewLabel_2 = new JLabel("        ");
        panel.add(lblNewLabel_2, BorderLayout.WEST);

        textField = new JTextField();
        textField.setBounds(124, 522, 121, 29);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Coordenada X:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3.setBounds(29, 523, 100, 26);
        contentPane.add(lblNewLabel_3);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(376, 522, 121, 29);
        contentPane.add(textField_1);

        JLabel lblNewLabel_3_1 = new JLabel("Coordenada Y:");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3_1.setBounds(281, 523, 100, 26);
        contentPane.add(lblNewLabel_3_1);

        JButton dibujar = new JButton("Dibujar");
        dibujar.setBounds(507, 522, 134, 29);
        dibujar.setFocusable(false);
        dibujar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int x = Integer.parseInt(textField.getText());
                    int y = Integer.parseInt(textField_1.getText());
                    coordenadasX.add(x);
                    coordenadasY.add(y);
                    colores.add(petalosC);
                    panel_1.repaint();
                } catch (NumberFormatException ex) {
                    // Handle invalid input
                }
            }
        });
        contentPane.add(dibujar);

        JButton limpiar = new JButton("Limpiar");
        limpiar.setBounds(507, 604, 134, 29);
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coordenadasX.clear();
                coordenadasY.clear();
                colores.clear();
                panel_1.repaint();
            }
        });
        contentPane.add(limpiar);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(29, 604, 468, 29);
        contentPane.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 5, 0, 0));

        JButton morado = new JButton("");
        morado.setFocusable(false);
        morado.setBackground(moradoC);
        morado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petalosC = moradoC;
            }
        });
        panel_2.add(morado);

        JButton azul = new JButton("");
        azul.setFocusable(false);
        azul.setBackground(azulC);
        azul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petalosC = azulC;
            }
        });
        panel_2.add(azul);

        JButton rojo = new JButton("");
        rojo.setFocusable(false);
        rojo.setBackground(rojoC);
        rojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petalosC = rojoC;
            }
        });
        panel_2.add(rojo);

        JButton rosa = new JButton("");
        rosa.setFocusable(false);
        rosa.setBackground(rosaC);
        rosa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petalosC = rosaC;
            }
        });
        panel_2.add(rosa);

        JButton lila = new JButton("");
        lila.setFocusable(false);
        lila.setBackground(lilaC);
        lila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petalosC = lilaC;
            }
        });
        panel_2.add(lila);

        JLabel lblNewLabel_4 = new JLabel("Colores");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_4.setBounds(29, 579, 468, 19);
        contentPane.add(lblNewLabel_4);
    }
}
