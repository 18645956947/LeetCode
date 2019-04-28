package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N»Êºó
 * @author zhx
 */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        LinkedList<Integer> row = new LinkedList<>();

        boolean[] col = new boolean[n];
        for (int i = 0; i < col.length; i++) {
            col[i] = false;
        }
        boolean[]dia1 = new boolean[2*n-1];
        for (int i = 0; i < dia1.length; i++) {
            dia1[i] = false;
        }
        boolean[] dia2 = new boolean[2*n-1];
        for (int i = 0; i < dia2.length; i++) {
            dia2[i] = false;
        }
        putQueen(col, dia1, dia2, res, n, 0, row);
        return res;
    }

    private void putQueen(boolean[] col, boolean[]dia1, boolean[] dia2, List<List<String>> res, int n, int index, LinkedList<Integer> row){

        if(index == n){
            res.add(generateBorard(n, row));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!col[i] && !dia1[index+i] && !dia2[index - i + n-1]){
                row.add(i);
                col[i] = true;
                dia1[index+i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(col, dia1, dia2, res, n, index+1, row);
                col[i] = false;
                dia1[index+i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();
            }
        }
    }
    public List<String> generateBorard(int n, List<Integer> row){

        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == row.get(i))
                    sb.append("Q");
                else
                    sb.append(".");
            }
            board.add(sb.toString());
        }
        return board;
    }
}
