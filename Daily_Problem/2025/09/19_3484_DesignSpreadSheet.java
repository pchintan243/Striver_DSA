package Daily_Problem.2025.09;
import java.util.HashMap;
import java.util.Map;

public class 19_3484_DesignSpreadSheet {
    Map<String, Integer> mp;
    public Spreadsheet(int rows) {
        mp = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        mp.put(cell, value);
    }
    
    public void resetCell(String cell) {
        mp.remove(cell);
    }
    
    public int getValue(String formula) {

        int ind = formula.indexOf('+');
        String first = formula.substring(1, ind);
        String sec = formula.substring(ind + 1);

        int val1 = 0;
        int val2 = 0;

        if(first.charAt(0) > '9') {
            val1 = mp.getOrDefault(first, 0);
        } else {
            val1 = Integer.parseInt(first);
        }

        if(sec.charAt(0) > '9') {
            val2 = mp.getOrDefault(sec, 0);
        } else {
            val2 = Integer.parseInt(sec);
        }

        return val1 + val2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */