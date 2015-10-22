import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*import java.lang.*;
import java.util.*;*/
import javax.swing.Timer;

public class PacMan implements KeyListener, ActionListener{
	ImageIcon eblock = new ImageIcon("icon.png");
	ImageIcon blocks[] = {new ImageIcon("black.png"),
						  new ImageIcon("pepe-body.png"),
						  new ImageIcon("wall.png"),
						  new ImageIcon("wall2.png"),
						  new ImageIcon("wall2.png"),
						  new ImageIcon("feelsman.png"),
						  new ImageIcon("dank dank.png"),
						  new ImageIcon("dank dank.png"),
						  new ImageIcon("dank dank.png")
						 };
	JFrame window;
	JLabel block;
	int score = 0, lives = 3;
	final int PACMAN = 1, EMPTY = 0, WALL = 2, PELLET = 7, GHOST = 5, SUPERPELLET = 8; 
	
	int grid[][]={
					{2,2,2,0,0,2,2,2},
					{2,8,7,7,7,7,8,2},
					{2,7,4,4,4,4,7,2},
					{2,7,7,4,4,7,7,2},
					{2,7,7,7,5,7,7,2},
					{2,7,4,4,4,7,7,2},
					{2,8,7,7,7,7,8,2},
					{0,7,7,4,4,7,7,0},
					{0,7,7,4,4,7,7,0},
					{2,8,7,7,7,7,7,2},
					{2,3,4,7,4,4,7,2},
					{2,3,7,7,7,7,7,2},
					{2,7,7,4,7,7,7,2},
					{2,1,4,4,7,4,5,2},
					{2,7,7,7,7,7,8,2},
					{2,2,2,0,0,2,2,2}
				

	};
	
	JLabel pGrid[][];
	int blinkyMoves[]={2,2,2,0,0,0,3,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2};
	int pinkyMoves[]={0,0,0,0,2,2,2,2};
	Ghost blinky = new Ghost(4,4,2,grid,blinkyMoves), pinky = new Ghost(13,6,0,grid,pinkyMoves);
    Timer time;

	public void actionPerformed(ActionEvent e){
		blinky.move();
		pinky.move();
		blinky.chase();
		pinky.chase();
		paintGrid();
	}

	public void keyTyped(KeyEvent e){

	}
	public void keyPressed(KeyEvent e){
		
		int value = e.getKeyCode();
		
		if(value==38){
			int pacmanRow=getPacManRow();
			int pacmanColumn=getPacManCol();
			if(pacmanRow==0) pacmanRow=16;
			if(grid[pacmanRow-1][pacmanColumn]==0||grid[pacmanRow-1][pacmanColumn]==7||grid[pacmanRow-1][pacmanColumn]==8){
				if(grid[pacmanRow-1][pacmanColumn]==PELLET){
					score++;
				}
				else if(grid[pacmanRow-1][pacmanColumn]==SUPERPELLET){
					score+=10;
				}
			grid[pacmanRow-1][pacmanColumn]=1;
			if(pacmanRow==16){
				pacmanRow=getPacManRow();
			}
			grid[pacmanRow][pacmanColumn]=0;
			}else if(grid[pacmanRow-1][pacmanColumn]==GHOST){
				lives--;
				switch(lives){
				case 2:
				    lives1.setIcon(new ImageIcon("black.png"));
				    break;
				case 1:
				    lives2.setIcon(new ImageIcon("black.png"));
				    break;
				case 0:
					JOptionPane.showMessageDialog(null, "u lose lul");
					System.exit(0);
					break;
				}
				grid[pacmanRow][pacmanColumn]=0;
				grid[13][1]=1;
			}
		}
		else if(value==40){
			int pacmanRow=getPacManRow();
			int pacmanColumn=getPacManCol();
			if(pacmanRow==15) pacmanRow=-1;
			if(grid[pacmanRow+1][pacmanColumn]==0||grid[pacmanRow+1][pacmanColumn]==7||grid[pacmanRow+1][pacmanColumn]==8){
				if(grid[pacmanRow+1][pacmanColumn]==PELLET){
					score++;
				}
				else if(grid[pacmanRow+1][pacmanColumn]==SUPERPELLET){
					score+=10;
				}
			grid[pacmanRow+1][pacmanColumn]=1;
			if(pacmanRow==-1){
				pacmanRow=15;
			}
			grid[pacmanRow][pacmanColumn]=0;
			}
			else if(grid[pacmanRow+1][pacmanColumn]==GHOST){
				lives--;
				if(lives==2) lives1.setIcon(new ImageIcon("black.png"));
				if(lives==1) lives2.setIcon(new ImageIcon("black.png"));
				if(lives==0) {
					JOptionPane.showMessageDialog(null, "u lose");
					System.exit(0);
				}
				grid[pacmanRow][pacmanColumn]=0;
				grid[13][1]=1;
			}
		}
		else if(value==37){
			int pacmanRow=getPacManRow();
			int pacmanColumn=getPacManCol();
			if(pacmanColumn==0) pacmanColumn=8;
			if(grid[pacmanRow][pacmanColumn-1]==0||grid[pacmanRow][pacmanColumn-1]==7||grid[pacmanRow][pacmanColumn-1]==8){
				if(grid[pacmanRow][pacmanColumn-1]==PELLET)
					score++;
				else if(grid[pacmanRow][pacmanColumn-1]==SUPERPELLET)
					score+=10;
			grid[pacmanRow][pacmanColumn-1]=1;
			if(pacmanColumn==8){
				pacmanColumn=getPacManCol();
			}
			grid[pacmanRow][pacmanColumn]=0;
			}
			else if(grid[pacmanRow][pacmanColumn-1]==GHOST){
				lives--;
				switch(lives){
				    case 2:
				        lives1.setIcon(new ImageIcon("black.png"));
				        break;
				    case 0:
				        JOptionPane.showMessageDialog(null, "ur a nube");
				        break;
				    case 1:
				        lives2.setIcon(new ImageIcon("black.png"));
				        break;
				}
				grid[pacmanRow][pacmanColumn]=0;
				grid[13][1]=1;
			}
		}
		else if(value==39){
			int pacmanRow=getPacManRow();
			int pacmanColumn=getPacManCol();
			if(pacmanColumn==7) pacmanColumn=-1;
			if(grid[pacmanRow][pacmanColumn+1]==0||grid[pacmanRow][pacmanColumn+1]==7||grid[pacmanRow][pacmanColumn+1]==8){
				if(grid[pacmanRow][pacmanColumn+1]==PELLET)
					score++;
				else if(grid[pacmanRow][pacmanColumn+1]==SUPERPELLET)
					score+=10;
			grid[pacmanRow][pacmanColumn+1]=1;
			if(pacmanColumn==-1){
				pacmanColumn=7;
			}
			grid[pacmanRow][pacmanColumn]=0;
			}
			else if(grid[pacmanRow][pacmanColumn+1]==GHOST){
				lives--;
				if(lives==2)lives1.setIcon(new ImageIcon("black.png"));
				if(lives==1)lives2.setIcon(new ImageIcon("black.png"));
				if(lives==0) {
					JOptionPane.showMessageDialog(null, "wow u suck");
					System.exit(0);
				}
				grid[pacmanRow][pacmanColumn]=0;
				grid[13][1]=1;
			}
		}
		paintGrid();
		if(score==121)System.exit(0);
	}
	public void keyReleased(KeyEvent e){

	}
	public void paintGrid(){
		scoreText.setText(""+score);
		if(score>=113){
			JOptionPane.showMessageDialog(null,"u won, u dank fr");
			System.exit(0);
		}
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 8; j++){
				pGrid[i][j].setIcon(blocks[grid[i][j]]);
				window.repaint();
			}
		}
	}
	public int getPacManRow(){
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 8; j++){
				if(grid[i][j]==1) return i;
			}
		}
		return 0;
	}
	public int getPacManCol(){
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 8; j++){
				if(grid[i][j]==1)return j;
			}
		}
		return 0;
	}
	JPanel top;
	JPanel body;
	JLabel scoreLabel = new JLabel("Score: ");
	JLabel scoreText = new JLabel("0");
	JLabel lives1 = new JLabel();
	JLabel lives2 = new JLabel();
	JLabel lives3 = new JLabel();
	public PacMan(){
		//ImageIcon eblock = new ImageIcon("icon.png");
		window = new JFrame("PacMan");
		body = new JPanel();
		top = new JPanel();
		window.addKeyListener(this);
		window.setLayout(new BorderLayout());
		body.setLayout(new GridLayout(16,8));
		top.setLayout(new GridLayout(1,8));
		top.add(scoreLabel);
		top.add(scoreText);
		scoreLabel.setForeground(Color.white);
		scoreLabel.setBackground(Color.black);
		scoreLabel.setOpaque(true);
		scoreText.setForeground(Color.white);
		scoreText.setBackground(Color.black);
		scoreText.setOpaque(true);
		lives1.setIcon(new ImageIcon("pepe-body.png"));
		lives1.setBackground(Color.black);
		lives1.setOpaque(true);
		lives2.setIcon(new ImageIcon("pepe-body.png"));
		lives2.setBackground(Color.black);
		lives2.setOpaque(true);
		lives3.setIcon(new ImageIcon("pepe-body.png"));
		lives3.setBackground(Color.black);
		lives3.setOpaque(true);
		top.add(lives1);
		top.add(lives2);
		top.add(lives3);
		
		block = new JLabel(eblock);
		pGrid = new JLabel[16][8];
		
		for(int i = 0; i < 16; i++){
			
			for(int j = 0; j < 8; j++){
				pGrid[i][j] = new JLabel(blocks[grid[i][j]]);
				body.add(pGrid[i][j]);
			}
		}
		window.add(block);
		window.setSize(300,300);
		window.add(body,BorderLayout.CENTER);
		window.add(top, BorderLayout.NORTH);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		time = new Timer(1000, this);
		time.start();
		time.setRepeats(true);

	}

	public static void main(String args[]){
		new PacMan();

	}
}


