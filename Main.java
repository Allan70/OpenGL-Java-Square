import javax.swing.*;
import java.awt.*;

class Main extends JComponent {
    public void paint(Graphics page) {
        page.setColor(Color.ORANGE);
        page.fillRect(200, 200, 100, 100);
//        Position your square with the 'x' and 'y' parameters
    }

    private void setLineThickness(Graphics page, int thickness) {
        if (thickness < 0) thickness = 0;
        ((Graphics2D)page).setStroke(new BasicStroke(thickness));
    }

    public Dimension getPreferredSize() {
        int initialWidth = 500;
        int initialHeight = 500;
        return new Dimension(initialWidth, initialHeight);
    }
//    This is our main method
    public static void main(String[] args) {
        JComponent jc = newInstance();
        JFrame frame = new JFrame(jc.getClass().getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel cp = new JPanel();
        cp.setLayout(new BorderLayout());
        cp.add(jc);
        frame.setContentPane(cp);
        frame.pack();
        frame.setVisible(true);
    }
    // Returns an instance of this class as a JComponent.
    // This is necessary so that we can rename this class without changing the "main" method's body.
    public static JComponent newInstance() {
        StackTraceElement[] trace = null;
        try { throw new RuntimeException(); }
        catch (Exception e) { trace = e.getStackTrace(); }
        try { return (JComponent)Class.forName(trace[0].getClassName()).newInstance(); }
        catch (Exception e) { return null; }
    }
}