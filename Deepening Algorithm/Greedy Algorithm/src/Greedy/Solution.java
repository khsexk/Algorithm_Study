package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Model.Action;

public class Solution{
	public ArrayList<Action> solution(ArrayList<Action> actionList) {
		// 종료시간 기준 정렬 (같을 시 시작시간 정렬)
		Collections.sort(actionList, new Comparator<Action>() {
			
			@Override
			public int compare(Action a, Action b){
				int result = a.f - b.f;
		        
				if(result == 0)
					return a.s-b.s;
				
				return result;
			} // compare
		});
	    
		int time = 0;
		ArrayList<Action> doList = new ArrayList<>();
	    
		for(Action act : actionList){
			if(time <= act.s){
				time = act.f;
				doList.add(act);
			}
		}
	    
	    return doList;
	  } // method
} // class