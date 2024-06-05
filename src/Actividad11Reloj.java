import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Color;

public class Actividad11Reloj extends JFrame {

    private JPanel panelContenido;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Actividad11Reloj marco = new Actividad11Reloj();
                    marco.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Actividad11Reloj() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        panelContenido = new JPanel();
        panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelContenido);
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.X_AXIS));
        
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int centroX = 275;
                int centroY = 275;
                int radio = 265;

                g2.setColor(Color.red);
                g2.fillOval(centroX - radio, centroY - radio, radio * 2, radio * 2);

                g2.setColor(Color.white);
                g2.fillOval(centroX - radio + 40, centroY - radio + 40, (radio - 40) * 2, (radio - 40) * 2);
                
                g2.setColor(Color.gray);
                for (int i = 0; i < 60; i++) {

                    g2.setStroke(new java.awt.BasicStroke(3));
                    double angulo = Math.toRadians((360 / 60) * i);
                    int x1 = (int) (centroX + Math.cos(angulo) * (235 - 10));
                    int y1 = (int) (centroY + Math.sin(angulo) * (235 - 10));
                    int x2 = (int) (centroX + Math.cos(angulo) * (235 - 30));
                    int y2 = (int) (centroY + Math.sin(angulo) * (235 - 30));
                    g2.drawLine(x1, y1, x2, y2);
                }
                g2.setColor(Color.black);
                for (int i = 0; i < 12; i++) {

                    g2.setStroke(new java.awt.BasicStroke(6));
                    double angulo = Math.toRadians((360 / 12) * i);
                    int x1 = (int) (centroX + Math.cos(angulo) * (234 - 10));
                    int y1 = (int) (centroY + Math.sin(angulo) * (234 - 10));
                    int x2 = (int) (centroX + Math.cos(angulo) * (234 - 30));
                    int y2 = (int) (centroY + Math.sin(angulo) * (234 - 30));
                    g2.drawLine(x1, y1, x2, y2);
                }
                g2.setColor(Color.black);
                for (int i = 1; i <= 12; i++) {
                    double angulo = Math.toRadians((360 / 12) * (i - 3));
                    int numeroX = (int) (centroX + Math.cos(angulo) * (174));
                    int numeroY = (int) (centroY + Math.sin(angulo) * (174));
                    String numero = Integer.toString(i);
                    g2.drawString(numero, numeroX - 5, numeroY + 5);
                }
                Calendar ahora = Calendar.getInstance();
                int hora = ahora.get(Calendar.HOUR);
                int minuto = ahora.get(Calendar.MINUTE);
                int segundo = ahora.get(Calendar.SECOND);

                double anguloHora = Math.toRadians((360 / 12) * hora - 90);
                int horaX = (int) (centroX + Math.cos(anguloHora) * (radio - 120));
                int horaY = (int) (centroY + Math.sin(anguloHora) * (radio - 120));
                g2.setColor(Color.black);
                g2.setStroke(new java.awt.BasicStroke(9));
                g2.draw(new Line2D.Float(centroX, centroY, horaX, horaY));

                double anguloMinuto = Math.toRadians((360 / 60) * minuto - 90);
                int minutoX = (int) (centroX + Math.cos(anguloMinuto) * (radio - 80));
                int minutoY = (int) (centroY + Math.sin(anguloMinuto) * (radio - 80));
                g2.setColor(Color.gray);
                g2.setStroke(new java.awt.BasicStroke(6));
                g2.draw(new Line2D.Float(centroX, centroY, minutoX, minutoY));

                double anguloSegundo = Math.toRadians((360 / 60) * segundo - 90);
                int segundoX = (int) (centroX + Math.cos(anguloSegundo) * (radio - 60));
                int segundoY = (int) (centroY + Math.sin(anguloSegundo) * (radio - 60));
                g2.setColor(Color.red);
                g2.setStroke(new java.awt.BasicStroke(3));
                g2.draw(new Line2D.Float(centroX, centroY, segundoX, segundoY));
                
                g2.fillOval(centroX-10, centroY-10, 20, 20);
                repaint();
            }
        };
        panel.setBackground(new Color(191, 255, 191));
        panelContenido.add(panel);
    }
}
