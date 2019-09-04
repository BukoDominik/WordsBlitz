package sample;

import sample.board.Board;
import sample.board.Cell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main  {
    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<>();
        System.out.println("heilo");

        String letters = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            letters = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Board board = new Board();
        Cell[][] cellsArray = board.getCellsArray();
        int col = 0;
        int row = 0;
        for (Character letter:
             letters.toCharArray()) {
            cellsArray[row][col] = new Cell(row,col, letter.toString(), false);
            col++;
            if (col == 4){
                col = 0;
                row++;
                if (row == 5){
                    break;
                }
            }
        }
        board.print();
        board.connectCells();
        createWords();
    }

    private static void createWords() {

    }
}
