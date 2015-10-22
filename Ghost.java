public class Ghost{
	int direction;
	int grid[][];
	int lastSpot;
	int pacmanRow;
	int pacmanColumn;
	int ghostRow;
	int ghostColumn;
	final int LEFT=2;
	final int RIGHT=3;
	final int UP=0;
	final int DOWN=1;
	final int PACMAN = 1;
	final int EMPTY = 0;
	final int WALL = 2;
	final int PELLET = 7;
	final int GHOST = 5;
	final int SUPERPELLET = 8; 
	int moves[];
	int movesLength;

	public void flip(){
		if(direction==0)direction=1;
		else if(direction==1)direction=0;
		else if(direction==2)direction=3;
		else if(direction==3)direction=2;
	}

	public Ghost(int r, int c, int d, int g[][], int m[]){
		ghostRow=r;
		ghostColumn=c;
		grid=g;
		direction=d;
		lastSpot=EMPTY;
		moves=m;
		movesLength=0;
	}
	
	public void move(){
		if(movesLength!=moves.length){
			direction=moves[movesLength];
			movesLength++;
		}
		if(direction==UP){
			pacmanRow=getPacManRow();
			pacmanColumn=getPacManCol();
			
			if(grid[ghostRow-1][ghostColumn] == EMPTY){
				if(lastSpot==EMPTY){
					grid[ghostRow][ghostColumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostRow][ghostColumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostRow][ghostColumn]=SUPERPELLET;
				}
				grid[ghostRow-1][ghostColumn] = GHOST;
				lastSpot=EMPTY;
			}
			if(grid[ghostRow-1][ghostColumn]==PELLET){
				if(lastSpot==EMPTY){
					grid[ghostRow][ghostColumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostRow][ghostColumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostRow][ghostColumn]=SUPERPELLET;
				}
				grid[ghostRow-1][ghostColumn] = GHOST;
				lastSpot=PELLET;
			}
			if(grid[ghostRow-1][ghostColumn]==SUPERPELLET){
				if(lastSpot==EMPTY){
					grid[ghostRow][ghostColumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostRow][ghostColumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostRow][ghostColumn]=SUPERPELLET;
				}
				grid[ghostRow-1][ghostColumn] = GHOST;
				lastSpot=SUPERPELLET;

			}
			if(grid[ghostRow-1][ghostColumn]==WALL){
				flip();
			} 
			ghostRow--;
		}

		
		if(direction==DOWN){
			pacmanRow=getPacManRow();
			pacmanColumn=getPacManCol();
			
			if(grid[ghostRow+1][ghostColumn] == EMPTY){
				if(lastSpot==EMPTY){
					grid[ghostRow][ghostColumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostRow][ghostColumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostRow][ghostColumn]=SUPERPELLET;
				}
				grid[ghostRow+1][ghostColumn] = GHOST;
				lastSpot=EMPTY;
			}
			if(grid[ghostRow+1][ghostColumn]==PELLET){
				if(lastSpot==EMPTY){
					grid[ghostRow][ghostColumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostRow][ghostColumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostRow][ghostColumn]=SUPERPELLET;
				}
				grid[ghostRow+1][ghostColumn] = GHOST;
				lastSpot=PELLET;
			}
			if(grid[ghostRow+1][ghostColumn]==SUPERPELLET){
				if(lastSpot==EMPTY){
					grid[ghostRow][ghostColumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostRow][ghostColumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostRow][ghostColumn]=SUPERPELLET;
				}
				grid[ghostRow+1][ghostColumn] = GHOST;
				lastSpot=SUPERPELLET;
			}
			if(grid[ghostRow+1][ghostColumn]==WALL){
				flip();
			} 
			ghostRow++; 
		}
		if(direction==LEFT){
			pacmanRow=getPacManRow();
			pacmanColumn=getPacManCol();
			
			if(grid[ghostRow][ghostColumn-1] == EMPTY){
				if(lastSpot==EMPTY){
					grid[ghostRow][ghostColumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostRow][ghostColumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostRow][ghostColumn]=SUPERPELLET;
				}
				grid[ghostRow][ghostColumn-1] = GHOST;
				lastSpot=EMPTY;
			}
			if(grid[ghostRow][ghostColumn-1]==PELLET){
				if(lastSpot==EMPTY){
					grid[ghostRow][ghostColumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostRow][ghostColumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostRow][ghostColumn]=SUPERPELLET;
				}
				grid[ghostRow][ghostColumn-1] = GHOST;
				lastSpot=PELLET;
			}
			if(grid[ghostRow][ghostColumn-1]==SUPERPELLET){
				if(lastSpot==EMPTY){
					grid[ghostRow][ghostColumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostRow][ghostColumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostRow][ghostColumn]=SUPERPELLET;
				}
				grid[ghostRow][ghostColumn-1] = GHOST;
				lastSpot=SUPERPELLET;
			}
			if(grid[ghostRow][ghostColumn-1]==WALL){
				flip();
			}  
			ghostColumn--;
		}
		if(direction==RIGHT){
			pacmanRow=getPacManRow();
			pacmanColumn=getPacManCol();
			
			if(grid[ghostRow][ghostColumn+1] == EMPTY){
				if(lastSpot==EMPTY){
					grid[ghostRow][ghostColumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostRow][ghostColumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostRow][ghostColumn]=SUPERPELLET;
				}
				grid[ghostRow][ghostColumn+1] = GHOST;
				lastSpot=EMPTY;
			}
			if(grid[ghostRow][ghostColumn+1]==PELLET){
				if(lastSpot==EMPTY){
					grid[ghostRow][ghostColumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostRow][ghostColumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostRow][ghostColumn]=SUPERPELLET;
				}
				grid[ghostRow][ghostColumn+1] = GHOST;
				lastSpot=PELLET;
			}
			if(grid[ghostRow][ghostColumn+1]==SUPERPELLET){
				if(lastSpot==EMPTY){
					grid[ghostRow][ghostColumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostRow][ghostColumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostRow][ghostColumn]=SUPERPELLET;
				}
				grid[ghostRow][ghostColumn+1] = GHOST;
				lastSpot=SUPERPELLET;
			}
			if(grid[ghostRow][ghostColumn+1]==WALL){
				flip();
			}  
			ghostColumn++;
		}
	}
	public void chase(){
	if(ghostRow==pacmanRow){
		if(ghostColumn<=pacmanColumn){
			for(int i=ghostColumn+1;i<pacmanColumn;i++){
				if(grid[ghostRow][i]==WALL)return;
				else{
					direction=RIGHT;
					}
			}
		}else if(pacmanColumn<=ghostColumn){
			for(int i=ghostColumn-1;i<pacmanColumn;i++){
				if(grid[ghostRow][i]==WALL)return;
				else direction=LEFT;
			}
		}

	}
	if(ghostColumn==pacmanColumn){
		if(ghostRow<=pacmanRow){
			for(int i=ghostRow+1;i<pacmanRow;i++){
				if(grid[i][ghostColumn]==WALL){
					return;
				}else{
				direction=DOWN;
			}
		}
	}
			else if(pacmanRow<=ghostRow){
			for(int i=ghostRow-1;i<pacmanRow;i++){
				if(grid[ghostRow][i]==WALL)return;
				else{
					direction=LEFT;
					}
			}
		}
			
		
	}
}
	public int getPacManRow(){
	for(int i=0;i<16;i++){
		for(int j=0;j<8;j++){
			if(grid[i][j]==1)
				return i;
		}
	}return 0;
}

public int getPacManCol(){
	for(int i=0;i<16;i++){
		for(int j=0;j<8;j++){
			if(grid[i][j]==1)
				return j;
		}
	}return 0;
}
}
