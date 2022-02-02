package RecursiveTest;

public class Recursive{
    static int lim = 6;  
    public static void main(String[] args){
        int[] chosen = new int[3]; 
        
        // 1~10까지의 수에서 중복 있이 5개 뽑기 
        solve(chosen, 0, 0, 3);
    }
    
    // chosen: 선택된 숫자가 저장된 배열
    // current: 현재 숫자를 선택하는 index
    // cnt: 몇 개의 숫자가 선택되었는지 확인
    static void solve(int[] chosen, int current, int cnt, int n){
    
        // n개의 숫자를 다 선택했다면 출력 후 더 이상 재귀를 돌지 않아야 한다!
        // 탈출 조건의 정의!
        if(cnt == n){
        	print(chosen);
            return;
        }
        
        // 반복문을 통해 숫자를 계속 선택!
        for(int i=current+1; i <= lim; i++){
            // 현재 선택된 숫자를 저장
            chosen[cnt] = i;
            
            // 다음 숫자를 선택하기 위해 재귀 호출
            solve(chosen, current, cnt+1, n);
        }
    }
    static void print(int[] arr) {
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}