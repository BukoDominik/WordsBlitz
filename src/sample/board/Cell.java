package sample.board;

import java.util.ArrayList;

public class Cell {
    private int positionX;
    private int positionY;
    private String value;
    private Boolean isVisited;
    private ArrayList<Cell> conectedCells;
    private int nextCellX;
    private int previousCellX;
    private int nextCellY;
    private int previousCellY;

    public ArrayList<Cell> getConectedCells() {
        return conectedCells;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setConectedCells(ArrayList<Cell> conectedCells) {
        this.conectedCells = conectedCells;
    }

    public int getNextCellX() {
        return nextCellX;
    }

    public void setNextCellX(int nextCellX) {
        this.nextCellX = nextCellX;
    }

    public int getPreviousCellX() {
        return previousCellX;
    }

    public void setPreviousCellX(int previousCellX) {
        this.previousCellX = previousCellX;
    }

    public int getNextCellY() {
        return nextCellY;
    }

    public void setNextCellY(int nextCellY) {
        this.nextCellY = nextCellY;
    }

    public int getPreviousCellY() {
        return previousCellY;
    }

    public void setPreviousCellY(int previousCellY) {
        this.previousCellY = previousCellY;
    }

    public Cell(int positionX, int positionY, String value, Boolean isVisited) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.value = value;
        this.isVisited = isVisited;
        this.nextCellX = positionX + 1;
        this.previousCellX = positionX - 1;
        this.nextCellY = positionY + 1;
        this.previousCellY = positionY - 1;
    }

    public Boolean getBorder() {
        return isVisited;
    }

    public void setBorder(Boolean border) {
        isVisited = border;
    }
}
