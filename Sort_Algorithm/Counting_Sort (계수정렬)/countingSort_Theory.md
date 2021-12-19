# Counting Sort

<blockquote data-ke-style="style2"><span><b><br />0. 개요</b></span></blockquote>
<p data-ke-size="size16">&nbsp;일반적으로 알고 있는 정렬들은 모두 비교 정렬(Comparison Sort)이었다. 옆의 수를 &nbsp;비교하든, 반을 갈라 비교하든, 어쨋든 비교했다. 비교 정렬은 시간복잡도가 O(n&sup2;)의 한계점을 벗어나지 못했고, 아무리 줄이고 줄여도 O(nlgn)이었다. 하지만 non-comparison sort는 달랐다. 이 정렬은 O(n)을 만족하고, 알고리즘 또한 간단하다. 여기엔 두 가지 종류가 있는데, 오늘은 이 중 계수 정렬(Counting Sort)를 알아볼 것이다.</p>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><span><b>1. 계수 정렬(Counting Sort)</b></span></blockquote>
<p data-ke-size="size16"><span><b>&nbsp;</b>계수 정렬은 일단 핵심 가정이 존재한다. 일단 정렬되는 수가 { 0, 1, ... , k } 안에 있어야 한다. 가정에 대해 좀 더 자세히 살펴보면,</span><span></span></p>
<p data-ke-size="size16"><span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 1. 데이터가 모두 양수여야 한다.&nbsp;</span></p>
<p data-ke-size="size16"><span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;2. 값의 범위가 너무 크지 않아야 한다.</span></p>
<p data-ke-size="size16"><span>이렇게 두 가지 가정이 있다. 그럼 이제 입력과 출력에 대해 알아보자</span></p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16"><span><b>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;Input:</b><span><span>&nbsp;A[1 .. n], where A[j] <span style="background-color: #ffffff; color: #000000;">&isin; { 0, 1, ... , k } for j = 1, 2, ..., n</span></span></span></span></p>
<p data-ke-size="size16"><span><span><span><span style="background-color: #ffffff; color: #000000;">&nbsp;여기서 배열 A와 n, 그리고 k는 parameter로서 주어진다.</span></span></span></span></p>
<p data-ke-size="size16"><span><span><span><span style="background-color: #ffffff; color: #000000;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<b>Output:&nbsp;</b>B[1 .. n]</span></span></span></span></p>
<p data-ke-size="size16"><span><span><span><span style="background-color: #ffffff; color: #000000;">&nbsp;B는 정렬된 배열이다. B는 이미 할당된 것으로 간주하고, parameter로서 주어진다.</span></span></span></span></p>
<p data-ke-size="size16"><span><span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<b>Auxiliary Storage:&nbsp;</b>C[0 .. k]</span></span></p>
<p data-ke-size="size16"><span><span>&nbsp;C는 보조 저장소다. 그럼 이제 알고리즘에 대해 보도록 하자.</span></span></p>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><b>2. About Quick Sort</b><span style="background-color: #fdfdfd; color: #000000;"><span style="background-color: #fdfdfd; color: #000000;"><b></b></span></span></blockquote>
<pre id="code_1639913755569" class="shell" data-ke-language="shell" data-ke-type="codeblock"><code>COUNTING-SORT (A, B, k)
1    let C[0 .. k] be a new array
2    for i = 0 to k
3          C[i] = 0    // Count Array init
4    for j = 1 to A.length
5          C[A[j]] = C[A[j]] + 1    // 각 숫자의 갯수 구하기
6    
7    for i = 1 to k
8          C[i] = C[i] + C[i-1]     // 누적 갯수 구하기
9    
10   for j = A.length downto 1      // 출력을 위해 정렬
11         B[C[A[j]]] = A[j]
12         C[A[j]] = C[A[j]] - 1</code></pre>
<p data-ke-size="size16">&nbsp;정렬 과정을 살펴보자.</p>
<p align="left"><img src="https://user-images.githubusercontent.com/56003992/146674555-e90ab5c1-3ac9-4ef7-b025-f2ff850b3975.png"  width="200" height="100"></p>
<p data-ke-size="size16">처음 상태이다. 매개변수로 주어진 k를 기준으로 C[0 .. k] 배열을 만들어주고, A 배열 내의 각 값의 갯수로 요소를 채워주었다. ( ex) A 내에 3을 가진 요소가 3개라 C 배열의 인덱스 3에 해당하는 요소의 값이 3이다)</p>
<p data-ke-size="size16">&nbsp;</p>

<p align="left"><img src="https://user-images.githubusercontent.com/56003992/146674673-00a47c2e-996b-4d81-ab78-61a5b71404fd.png"  width="150" height="70"></p>
<p data-ke-size="size16">Line8까지 수행한 결과다. C 배열에 누적 갯수를 반영했다. 누적에 대해서는 위의 사진을 보면 보다 이해가 편할 것이다. 이제 정렬 파트만 남았다. Line10~12까지가 정렬하는 부분이다.</p>
<p data-ke-size="size16">&nbsp;</p>

<p align="left"><img src="https://user-images.githubusercontent.com/56003992/146674723-ddf9734b-04f5-4e80-b0c0-15186cb03096.png"  width="200" height="100"></p>
<p data-ke-size="size16">&nbsp;반복문을 한번 돌린 상태다. Output을 저장할 배열 B의 7번 인덱스에 3이 들어갔다. for문은 A의 마지막 인덱스부터 1씩 감소하면서 반복하는데, B[C[3]]은 B[7]이므로 B[7] = A[8] 을 수행한 결과가 바로 위의 사진이다. 그리고 C의 3번 인덱스의 값은 감소시킨다.</p>
<p data-ke-size="size16">&nbsp;</p>

<p align="left"><img src="https://user-images.githubusercontent.com/56003992/146674763-81aa97b6-1275-4ba4-8879-d75a624893e9.png"  width="200" height="100"></p>
<p data-ke-size="size16">&nbsp;이제 두 번 돌린 상태다. A의 7번 인덱스는 0이다. B[C[A[7]]]는 B[C[0]]이고, B[2]이다. 따라서 B[2]에 0을 넣어주고, C[0]의 값은 감소시킨다.</p>
<p data-ke-size="size16">&nbsp;</p>


<p align="left"><img src="https://user-images.githubusercontent.com/56003992/146674800-daca2aeb-4705-41d6-ac79-2c07373f9a9f.png"  width="200" height="100"></p>
<p data-ke-size="size16">&nbsp;세 번째 또한 똑같이 해주면 된다. A의 6번 인덱스가 3이다. B[C[3]는 B[6]이므로, B[6]에 3을 넣어주고, C[3]은 감소시킨다. 이 과정을 반복하면 아래와 같이 정렬된다.</p>

<p align="left"><img src="https://user-images.githubusercontent.com/56003992/146674874-197eb682-c31d-44b1-802b-893648241461.png"  width="200" height="70"></p>

<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">시간복잡도를 보면&nbsp;</p>
<p data-ke-size="size16">&nbsp; &nbsp; &nbsp; &nbsp; &bull; Count Array 초기화:&nbsp;O(k)&nbsp;</p>
<p data-ke-size="size16">&nbsp; &nbsp; &nbsp; &nbsp; &bull; 각 숫자의 갯수 구하기:&nbsp;O(n)&nbsp;&nbsp;</p>
<p data-ke-size="size16">&nbsp; &nbsp; &nbsp; &nbsp; &bull;&nbsp;최악의&nbsp;시간&nbsp;복잡도:&nbsp;O(k)</p>
<p data-ke-size="size16">&nbsp; &nbsp; &nbsp; &nbsp; &bull;&nbsp;정렬:&nbsp;O(n)</p>
<p data-ke-size="size16">와 같이 나온다. 따라서 총 시간 복잡도는 2&bull;O(k) + 2&bull;O(n)이고, 이는 O(n)과 동일하다. 따라서 계수 정렬의 시간복잡도는 O(n)이다.</p>
