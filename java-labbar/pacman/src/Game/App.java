package Game;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.CardLayout;
 
 
public class App extends JFrame {

    JPanel panelCont = new JPanel();
    JPanel menuPanel = new JPanel();
    JPanel highscorePanel = new JPanel(); 
    JButton playNormalButton = new JButton("Normal mode");
    JButton playSpecialButton = new JButton("Special mode");
    JButton highscoreButton = new JButton("Highscores");
    JButton backButton = new JButton("Back to menu");
    JButton exitButton = new JButton("Exit");
    CardLayout cl = new CardLayout();
    

    public App() {
        panelCont.setLayout(cl);
        menuPanel.add(playNormalButton);
        menuPanel.add(playSpecialButton);
        menuPanel.add(highscoreButton);
        menuPanel.add(exitButton);

        highscorePanel.add(backButton);

        menuPanel.setBackground(Color.BLACK);
        highscorePanel.setBackground(Color.BLACK);

        panelCont.add(menuPanel, "1");
        panelCont.add(highscorePanel, "2");
        cl.show(panelCont, "1");

        playNormalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                add(new PacManGame());
            }
        });

        playSpecialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //add(new PacManGame());
                System.out.println("Not yet added");
            }
        });

        highscoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "2");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "1");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        add(panelCont);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);

	}
	
	
	public static void main(String[] args) {
		App pac = new App();
		pac.setTitle("Pacman");
		pac.setSize(380,420);
		pac.setLocationRelativeTo(null);
		
	}
}
 