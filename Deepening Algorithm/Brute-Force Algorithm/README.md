# Brute-Force Algorithm
</br>
  
## 1. 완전 탐색 알고리즘이란?

**def)** 가능한 모든 경우의 수를 다 체크해서 정답을 찾는 방법  
</br>
#### 기본적인 2가지 규칙
```text
i) 사용된 알고리즘이 적절한가? (문제 해결이 가능한가?)
ii) 효율적으로 동작하는가?
```
  
##### 만약 다른 알고리즘을 사용하면 O(N)으로 해결되는 어떤 문제가 있는데, O(N²)이 걸리는 Brute-Force를 사용하는 것은 옳지 않다!  
### 따라서 아래와 같은 사항을 고려해서 수행해야 한다.
```text
i) 해결하고자 하는 문제의 가능한 경우의 수를 대략적으로 계산
ii) 가능한 모든 방법을 다 고려
iii) 실제 답을 구할 수 있는지 적용
```

* * *

## 2. 완전 탐색 기법

### i) 단순 Brute-Force 문제
: 특별한 어느 기법을 사용하지 않고, 단순히 반복문과 조건문 등으로 모든 case들을 만들어 답을 구하는 방식  
☛ 시간복잡도가 O(N²)이나 O(N!)이기 때문에 케이스으 범위를 보고 사용해야 함  
☛ 사실 간단한 문제이기 때문에 코딩 테스트 문제로 자주 출제되지 않음  
</br>  
ex) 예시 문제집 [BOJ Brute-Force 문제집](https://www.acmicpc.net/step/22)
  
### ii) Bit-Mask
: 비트 연산을 통해 부분 집합을 표현하는 방법  
☛ and(&&), or(||), not(!), xor(^), shift(<<, >>)  
  
|A|B|A && B|A &#124;&#124; B|A!|A &#94; B|
|-|-|------|----------------|--|---------|
|0|0|0|0|1|0|
|0|1|0|1|1|1|
|1|0|0|1|0|1|
|1|1|1|1|0|0|

ex) 예시 문제 → [BOJ 11723 집합](https://www.acmicpc.net/problem/11723)

### iii) Recursive
: 말 그대로 자기 자신을 호출  
  
```text
1) 재귀를 탈출하기 위한 탈출 조건 필요
2) 현재 함수으 상태를 저장하는 Parameter 필요
3) Return문을 신경쓸 것
```
☛ DP와의 차이점  
: DP는 작은 문제가 큰 문제와 동일한 구조를 가져 큰 문제의 답을 구할 시에 작은 문제의 결과를 기억한 뒤 그대로 사용하여 수행속도르 빠르게 함  
: 완전탐색은 크고 작은 문제의 구조가 다를 수 있고, 해결 가능한 방법을 모두 탐색  
</br>  
1. [로또](https://www.acmicpc.net/problem/6603)  
2. [암호 만들기](https://www.acmicpc.net/problem/1759)  
3. [일곱 난쟁이](https://www.acmicpc.net/problem/2309)  
4. [부분 수열의 합](https://www.acmicpc.net/problem/1182)  

### iv) Permutation
: 임의의 수열이 있을 때, 그것을 다른 순서로 연산하는 방법  
</br>
#### ① Swap을 이용한 구현  
<img width="580" alt="swap" src="https://user-images.githubusercontent.com/56003992/152120314-324fb689-5cc1-4ade-9179-06f61de4f794.png">

- 배열의 첫 값부터 순서대로 하나씩 바꾸며 모든 값을 한번씩 SWAP
- depth를 기준으로, depth보다 index가 작은 값들은 고정, 큰 값들은 SWAP 진행
- 순열들의 순서 보장 X 
```java
void swapPermutation(int[] arr, int depth, int n, int r){
  if(depth == r){
    배열 출력
    return;
  }
  for(int i=depth ; i<n ; i++{
    swap(arr, depth, i);
    swapPermutation(arr, depth+1, n, r);
    swap(arr, depth, i);
  }
}
static void swap(int[] arr, int depth, int i) { 
  int temp = arr[depth];
	arr[depth] = arr[i];
	arr[i] = temp;
}
```

  
</br> 

#### ② DFS로 구현 
<img width="579" alt="dfs" src="https://user-images.githubusercontent.com/56003992/152121515-767ba0b5-d9f4-4612-ac5c-42b3ad8c90e6.png">

- DFS로 모든 인덱스를 방문하여 output에 값을 넣음
- depth는 output에 들어간 숫자의 길이와 같음
- 순열들의 순서 보장 O
```java
void dfsPermutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
	if(depth == r) {
		print(output, r); //순열 출력을 위한 print 함수 
		return;
	}

	for(int i = 0; i < n; i++) {
		if(visited[i] != true) {
			visited[i] = true;
			output[depth] = arr[i];
			per2(arr, output, visited, depth + 1, n, r);    
			visited[i] = false;
		}
	}
}
```
  </br>  
  
#### ❖ 실행결과!
<img width="192" alt="exe" src="https://user-images.githubusercontent.com/56003992/152123019-b74f506e-449e-429d-ab75-5638909d00f9.png"> 

- SWAP을 이용했을 때 순서가 보장되지 않았음
- 테스트케이스가 많아질수록 DFS를 이용한 메서드 실행속도가 SWAP을 이용한 메서드 실행속도보다 빨라짐
  
  
</br>  
  
ex) 예시 문제 → [BOJ 11723 모든 순열](https://www.acmicpc.net/problem/10974)

### v) BFS /DFS
: 이후 따로 다루어 볼 예정

