package model;

public class Board {
    public static final int SIZE = 5;
    private int[][] matrix = {
            {0, -79, 0, 0, -51},
            {-47, -71, -95, -99, 0},
            {0, -43, 0, -91, 0},
            {0, 0, 0, 0, 0},
            {0, -107, 0, -55, 0}
    };

    public Board() {


    }

    public int[] getRow(int index) {
        return matrix[index];
    }

    public int sumRow(int rowIndex) {
        int sum = 0;
        for(int i = 0; i< SIZE; i++) {
            sum += matrix[rowIndex][i];
        }
        return sum;

    }


    public int sumColumn(int columnIndex) {
        int sum = 0;
        for(int i = 0; i< SIZE; i++) {
            sum += matrix[i][columnIndex];
        }
        return sum;

    }


    public int sumDiagonal(Boolean bool) {
        int sum = 0;
        if (bool) {
            for (int i = 0; i < SIZE; i++) {
                sum += matrix[i][i];
            }
        } else {
            for (int i = 0; i < SIZE; i++) {
                sum += matrix[i][SIZE -1-i];
            }

        }
        return sum;
    }

    public Boolean isPositionEmpty(int rowIndex, int columnIndex) {
        return matrix[rowIndex][columnIndex] == 0;
    }

   public void setPosition(int rowIndex, int columnIndex, int value) {
        matrix[rowIndex][columnIndex] = value;

   }
}
