package sample.board;
import java.util.ArrayList;

public class Board {
    int startPositionX;
    int startPositionY;
    private Cell[][] cellsArray = new Cell[4][4];

    public Board(Cell[][] cellsArray) {
        this.cellsArray = cellsArray;
    }

    public Board(){

    }

    public Cell[][] getCellsArray() {
        return cellsArray;
    }

    public void setCellsArray(Cell[][] cellsArray) {
        this.cellsArray = cellsArray;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < cellsArray.length; row++){
            for (int col = 0; col < cellsArray[row].length; col++){
                sb.append(cellsArray[col][row].getValue());
                System.out.print(cellsArray[row][col].getValue() + "\t");
            }
            System.out.println();
        }
    }

    public void generateBoard(){
        for (int row = 0; row < cellsArray.length; row++) {
            for (int col = 0; col < cellsArray[row].length; col++) {
                cellsArray[row][col] = new Cell(row,col,"X", true);
            }
        }
    }

    public void connectCells(){
        for (int row = 0; row < cellsArray.length; row++){
            for (int col = 0; col < cellsArray[row].length; col++){
                Cell currentCell = cellsArray[row][col];
                ArrayList<Cell> connectedCells = new ArrayList<>();
                //Check S
                if (checkSouth(currentCell)){
                    connectedCells.add(cellsArray[currentCell.getNextCellX()][col]);
                }
                //Check SE
                if (checkSouth(currentCell) && checkEast(currentCell)){
                    connectedCells.add(cellsArray[currentCell.getNextCellX()][currentCell.getPreviousCellY()]);
                }
                //Check SW
                if (checkSouth(currentCell) && checkWest(currentCell)){
                    connectedCells.add(cellsArray[currentCell.getNextCellX()][currentCell.getNextCellY()]);
                }
                //Check N
                if (checkNorth(currentCell)){
                    connectedCells.add(cellsArray[currentCell.getPreviousCellX()][col]);
                }
                //Check NW
                if (checkNorth(currentCell) && checkWest(currentCell)){
                    connectedCells.add(cellsArray[currentCell.getPreviousCellX()][currentCell.getNextCellY()]);
                }
                //Check NE
                if (checkNorth(currentCell) && checkEast(currentCell)){
                    connectedCells.add(cellsArray[currentCell.getPreviousCellX()][currentCell.getPreviousCellY()]);
                }
                // Check W
                if (checkWest(currentCell)){
                    connectedCells.add(cellsArray[row][currentCell.getNextCellY()]);
                }
                // Check E
                if (checkEast(currentCell)){
                    connectedCells.add(cellsArray[row][currentCell.getPreviousCellY()]);
                }
                currentCell.setConectedCells(connectedCells);
            }
        }
        for (int row = 0; row < cellsArray.length; row++){
            for (int col = 0; col < cellsArray[row].length; col++){
                if (isEdgeCell(row,col)){
                    System.out.println(cellsArray[row][col].getValue() + "RÓG");
                }else if (isSideCellNotEdge(row,col)){
                    System.out.println(cellsArray[row][col].getValue() + "BOCZNA");
                } else {
                    System.out.println(cellsArray[row][col].getValue() + "środkowa");
                }
            }
        }
    }
    private boolean checkSouth(Cell currentCell){
        return currentCell.getNextCellX() < 4;
    }
    private boolean checkNorth(Cell currentCell){
        return currentCell.getPreviousCellX() >= 0;
    }
    private boolean checkWest(Cell currentCell){
        return currentCell.getNextCellY() < 4;
    }
    private boolean checkEast(Cell currentCell){
        return currentCell.getPreviousCellY() >= 0;
    }

    boolean isEdgeCell(int row, int col){
        return (row == 0 || row == cellsArray.length - 1) && (col == 0 || col == cellsArray.length -1);
    }
    boolean isSideCellNotEdge(int row, int col){
        return ((row == 0 || row == cellsArray.length - 1) && !(col == 0 || col == cellsArray.length - 1)) || (!(row == 0 || row == cellsArray.length - 1) && (col == 0 || col == cellsArray.length - 1));
    }
}
