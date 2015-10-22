import java.awt.*;
import javax.swing.*;
 
public class StartPacManGame extends JWindow {
     
    private int duration;
    JFrame window;
     
    public StartPacManGame(int d) {
        duration = d; 
        window=new JFrame("PacMan");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
     
    
    public void showStartPacManGame() {
         
        JPanel content = (JPanel)getContentPane();
        content.setBackground(new Color(0,0,0)); 
        int width = 256;
        int height =512;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = 0;
        int y = 20;
        setBounds(x,y,width,height);
         
       
        JLabel label = new JLabel(new ImageIcon("CMgMNcgUYAAVRij.jpg"));
        JLabel text = new JLabel
                ("DankMan", JLabel.CENTER);
        text.setForeground(Color.magenta);
        text.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        content.add(label, BorderLayout.CENTER);
        content.add(text, BorderLayout.NORTH);
        Color oraRed = new Color(255, 255,255,  255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 16));
         
        
        setVisible(true);
         
        
        try { Thread.sleep(duration); } catch (Exception e) {}
         
        setVisible(false);
         
    }
     
    public void showStart() {
         
        showStartPacManGame();
        new PacMan();

         
    }
     
    public static void main(String[] args) {
         
        
        StartPacManGame startingPhase = new StartPacManGame(5000);
 
        
        startingPhase.showStart();
       
         
    }

}

