/**
 * Beschreiben Sie hier die Klasse board.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.awt.*;

public class board extends Ui
{
    private static final boolean black = false;
    private static final boolean white = true;
    private static int fieldAmountX = 8;
    private static int fieldAmountY = 8;
    boardField[][] playingBoard;
    

    /**
     * Konstruktor für Objekte der Klasse board
     */
    public board(int FieldLengthX, int FieldLengthY)
    {
        boolean color;
        
        this.playingBoard = new boardField[this.fieldAmountX][this.fieldAmountY];
        for(int i = 0; i < this.fieldAmountX; i++){
            for(int j = 0; j < this.fieldAmountY; j++){
                    this.playingBoard[i][j] = new boardField(white, new boardCoordinate(i,j), FieldLengthX, FieldLengthY);  
                
                if( (i+j)%2 != 0    ){
                    this.playingBoard[i][j] = new boardField(black, new boardCoordinate(i,j), FieldLengthX, FieldLengthY);  
                }
            }
        }
    }
        
    public void reset(){
        //Set Pawns on field
        for(int y = 0; y < 8; y++){
             this.playingBoard[y][1].setFigure( new pawn(black)    );
             this.playingBoard[y][6].setFigure( new pawn(white)    );
        }
        
        //Set Rooks on field
        this.playingBoard[0][0].setFigure( new rook(black)    );
        this.playingBoard[7][0].setFigure( new rook(black)    );
        this.playingBoard[0][7].setFigure( new rook(white)    );
        this.playingBoard[7][7].setFigure( new rook(white)    );
        
        //Set knights on field
        this.playingBoard[1][0].setFigure( new knight(black)    );
        this.playingBoard[6][0].setFigure( new knight(black)    );
        this.playingBoard[1][7].setFigure( new knight(white)    );
        this.playingBoard[6][7].setFigure( new knight(white)    );
        
        //Set bishops on field
        this.playingBoard[2][0].setFigure( new bishop(black)    );
        this.playingBoard[5][0].setFigure( new bishop(black)    );
        this.playingBoard[2][7].setFigure( new bishop(white)    );
        this.playingBoard[5][7].setFigure( new bishop(white)    );
        
        //Set kings on field
        this.playingBoard[4][0].setFigure( new king(black)    );
        this.playingBoard[4][7].setFigure( new king(white)    );
        
        //Set queens on field
        this.playingBoard[3][0].setFigure( new queen(black)    );
        this.playingBoard[3][7].setFigure( new queen(white)    );
    }
        
    public int render(int x, int y, Frame f){
         for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                //Calculate Offsets for each boardfield
                int fieldPosX = this.playingBoard[i][j].getSize().width*(i+1)+x;
                int fieldPosY = this.playingBoard[i][j].getSize().height*(j+1)+y;
                //Offset each boardFields position
                this.playingBoard[i][j].setLocation(fieldPosX, fieldPosY);
                
                this.playingBoard[i][j].render();
                f.add(this.playingBoard[i][j]);  
        }
     }
         return 1;
    }
    
    public int[] getBoardSize(){
        int[] xy = {this.fieldAmountX,this.fieldAmountY}; 
        return xy;
    }
    
    public int[] name2pos(String name){
        int x = name.charAt(0)-'A';
        int y = name.charAt(1)-'0'-1;
        int[] xy = {x,y};
        System.out.println("X: "+x+"Y: "+y);
        return xy;
    }
        
    
    public boolean moveFigure(){
        return false;
    }
}
