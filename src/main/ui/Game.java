package ui;

import model.Board;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.Board.SIZE;

public class Game {
    private int[] nums = { -115, -111, -103, -87, -83, -75, -67,-63 -59,-39,-35, -31,-27,-23, -19 };
    private List<List<Integer>> listOfList = permute(nums);

    private Board board;
    public Game() {
        runGame();
    }


    public void runGame() {
        fillBoard();
        printBoard();
        }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            int[] row = board.getRow(i);
            System.out.println(Arrays.toString(row));
        }

    }






    public void fillBoard() {
        for (int i = 0; i <listOfList.size(); i++) {
            board = new Board();
            List<Integer> list = listOfList.get(i);
            int index = 0;
            for (int j = 0; j <SIZE; j++) {
                for (int k = 0; k<SIZE; k++) {
                    if(board.isPositionEmpty(j, k)) {
                        board.setPosition(j, k, list.get(index));
                        index +=1;
                    }
                }
            } if (checkValid()) {
                break;
            }
        }


    }

    public boolean checkValid() {
        List<Integer> aList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            int columnSum = board.sumColumn(i);
            int rowSum = board.sumRow(i);
            aList.add(columnSum);
            aList.add(rowSum);

        }
        int dSum = board.sumDiagonal(true);
        int dSum2 = board.sumDiagonal(false);
        aList.add(dSum);
        aList.add(dSum2);

        int x = aList.get(0);
        for(int num: aList) {
            if(num != x) {
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver() {
        for(int i=0; i< SIZE; i++) {
            for(int j=0; j<SIZE; j++) {
                if (board.isPositionEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;


    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    private void helper(int start, int[] nums, List<List<Integer>> result){
        if(start==nums.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            result.add(list);
            return;
        }

        for(int i=start; i<nums.length; i++){
            swap(nums, i, start);
            helper(start+1, nums, result);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
