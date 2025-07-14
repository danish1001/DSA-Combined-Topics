package RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class MazePath {
    public void printMazePath(int startRow, int endRow, int startCol, int endCol, String output) {
        if(startRow == endRow && startCol == endCol) {
            System.out.println(output);
            return;
        } else if(startRow > endRow || startCol > endCol) {
            return;
        }
        printMazePath(startRow, endRow, startCol+1, endCol, output + "H");
        printMazePath(startRow+1, endRow, startCol, endCol, output + "V");
    }
    public void printMazePathDiagonal(int startRow, int endRow, int startCol, int endCol, String output) {
        if(startRow == endRow && startCol == endCol) {
            System.out.println(output);
            return;
        } else if(startRow > endRow || startCol > endCol) {
            return;
        }
        printMazePathDiagonal(startRow, endRow, startCol+1, endCol, output + "H");
        printMazePathDiagonal(startRow+1, endRow, startCol, endCol, output + "V");
        printMazePathDiagonal(startRow+1, endRow, startCol+1, endCol, output + "D");
    }

    public List<String> getMazePath(int currentRow, int endRow, int currentCol, int endCol) {
        if(currentRow == endRow && currentCol == endCol) {
            List<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        if(currentRow > endRow || currentCol > endCol) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        List<String> horizontalRecursionResult = getMazePath(currentRow, endRow, currentCol+1, endCol);
        List<String> verticalRecursionResult = getMazePath(currentRow+1, endRow, currentCol, endCol);

        for(String str: horizontalRecursionResult) {
            result.add(str + "H");
        }

        for(String str: verticalRecursionResult) {
            result.add(str + "V");
        }
        return result;
    }

    public List<String> getMazePathDiagonal(int currentRow, int endRow, int currentCol, int endCol) {
        if(currentRow == endRow && currentCol == endCol) {
            List<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        if(currentRow > endRow || currentCol > endCol) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();

        List<String> horizontalRecursionResult = getMazePathDiagonal(currentRow, endRow, currentCol+1, endCol);
        for(String str: horizontalRecursionResult) {
            result.add(str + "H");
        }
        List<String> verticalRecursionResult = getMazePathDiagonal(currentRow+1, endRow, currentCol, endCol);
        for(String str: verticalRecursionResult) {
            result.add(str + "V");
        }
        List<String> diagonalRecursionResult = getMazePathDiagonal(currentRow+1, endRow, currentCol+1, endCol);
        for (String str: diagonalRecursionResult) {
            result.add(str + "D");
        }
        return result;
    }

}
