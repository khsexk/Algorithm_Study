package Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import Greedy.Solution;
import Model.Action;

public class GreedyTest {
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Action> list = new ArrayList<>();
        list.add(new Action("i11", 12, 16));
        list.add(new Action("i10", 2, 14));
        list.add(new Action("i9", 8, 12));
        list.add(new Action("i8", 8, 11));
        list.add(new Action("i7", 6, 10));
        list.add(new Action("i6", 5, 9));
        list.add(new Action("i5", 3, 9));
        list.add(new Action("i4", 5, 7));
        list.add(new Action("i3", 0, 6));
        list.add(new Action("i2", 3, 5));
        list.add(new Action("i1", 1, 4));

        Solution S = new Solution();
        ArrayList<Action> Do = S.solution(list);
        
        for(Action act : Do)
        	bw.write(act.name + "\n");
        
        bw.flush();
        bw.close();
	}

}
