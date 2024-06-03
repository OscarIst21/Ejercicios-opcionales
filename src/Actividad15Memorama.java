import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.Timer;

public class Actividad15Memorama extends JFrame {

    private JPanel contentPane;
    private JButton[] botones = new JButton[16];
    private List<String> icons = new ArrayList<>();
    private JButton boton1 = null;
    private JButton boton2 = null;
    private Timer timer;
    private int paresEncontrados = 0;
    private int intentos = 0;
    private JLabel tiempo;
    private Timer temporizador;
    private int segundos = 0;
    private boolean puedePresionar = true;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Actividad15Memorama frame = new Actividad15Memorama();
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
    public Actividad15Memorama() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 650);
        this.setTitle("Memorama SpiderVerse");
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        tiempo = new JLabel("Tiempo: 0");
        tiempo.setFont(new Font("Tahoma", Font.BOLD, 20));
        tiempo.setForeground(Color.white);
        tiempo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(tiempo, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        for (int i = 1; i < 9; i++) {
            icons.add(i + ".png");
            icons.add(i + ".png");
        }

        Collections.shuffle(icons);

        for (int i = 0; i < 16; i++) {
            botones[i] = new JButton("");
            botones[i].setFocusable(false);
            botones[i].setBackground(new Color(79, 183, 255));
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	temporizador.start();
                    if (!puedePresionar) {
                        return;
                    }
                    JButton boton = (JButton) e.getSource();
                    int index = -1;
                    for (int j = 0; j < botones.length; j++) {
                        if (botones[j] == boton) {
                            index = j;
                            break;
                        }
                    }
                    if (boton.getIcon() == null) {
                        boton.setIcon(new ImageIcon(Actividad15Memorama.class.getResource("/imagenes/" + icons.get(index))));
                        if (boton1 == null) {
                            boton1 = boton;
                        } else {
                            boton2 = boton;
                            intentos++;
                            if (icons.get(index).equals(icons.get(encontrarIndiceBoton(boton1)))) {
                                paresEncontrados++;
                                boton1 = null;
                                boton2 = null;
                                if (paresEncontrados == 8) {
                                	temporizador.stop();
            		                JOptionPane.showMessageDialog(null, "¡Felicidades Ganaste!");
            		                temporizador.start();
                                }
                            } else {
                                puedePresionar = false;
                                timer.start();
                            }
                        }
                    }
                }
            });
            panel.add(botones[i]);
        }

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 128, 192));
        contentPane.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new GridLayout(0, 3, 0, 0));

        JLabel lblNewLabel_1 = new JLabel("           ");
        lblNewLabel_1.setBackground(new Color(0, 128, 192));
        panel_1.add(lblNewLabel_1);

        JButton btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setForeground(new Color(255, 255, 255));
        btnReiniciar.setFocusable(false);
        btnReiniciar.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnReiniciar.setBackground(new Color(255, 0, 0));
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciar();
            }
        });
        panel_1.add(btnReiniciar);

        JLabel lblNewLabel_2 = new JLabel("           ");
        lblNewLabel_2.setBackground(new Color(0, 128, 192));
        panel_1.add(lblNewLabel_2);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boton1 != null && boton2 != null) {
                    boton1.setIcon(null);
                    boton2.setIcon(null);
                    boton1 = null;
                    boton2 = null;
                }
                puedePresionar = true;
            }
        });
        timer.setRepeats(false);

        temporizador = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                tiempo.setText("Tiempo: " + segundos);
            }
        });
        temporizador.stop();
    }

    private int encontrarIndiceBoton(JButton button) {
        for (int i = 0; i < botones.length; i++) {
            if (botones[i] == button) {
                return i;
            }
        }
        return -1;
    }

    private void reiniciar() {
        Collections.shuffle(icons);
        for (JButton button : botones) {
            button.setIcon(null);
        }
        boton1 = null;
        boton2 = null;
        paresEncontrados = 0;
        intentos = 0;
        segundos = 0;
        tiempo.setText("Tiempo: 0");
        temporizador.restart();
        puedePresionar = true;
    }
}
