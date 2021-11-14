# Quick Sort

<blockquote data-ke-style="style2"><span><b><br />1. 퀵 정렬(Quick Sort)란?</b></span></blockquote>
<p data-ke-size="size16"><span><b>def.</b><span> 하나의 Array를 피벗(pivot)을 기준으로 두 개의 비균등한 크기로 분할하고, 분할된 subArray를 정렬한 다음, 두 개의 정렬된 subArray를 합하여 전체가 정렬된 리스트가 되게 하는 정렬 알고리즘</span></span></p>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><b>2. About Quick Sort</b></blockquote>
<p data-ke-size="size16">&bull;&nbsp;최악의&nbsp;시간&nbsp;복잡도:&nbsp;O(n&sup2;)&nbsp;&nbsp;<br />&bull;&nbsp;최고의&nbsp;시간&nbsp;복잡도:&nbsp;O(nlgn)&nbsp;&nbsp;<br />&bull;&nbsp;O(nlgn)에&nbsp;숨겨진&nbsp;상수들은&nbsp;작다.&nbsp;&nbsp;<br />&bull;&nbsp;"Divide-and-Conquer"의&nbsp;3단계&nbsp;프로세스를&nbsp;기반으로&nbsp;한다.&nbsp;<br>
&bull;&nbsp;subArray를 분할하는 위치를 표시하는 인덱스 q를 반환하는 절차인<span>&nbsp;</span><b>PARTITION</b>으로&nbsp;분할 단계를 수행한다.<br>&bull;&nbsp;Subarray&nbsp;A[p&nbsp;.&nbsp;.&nbsp;r]&nbsp;정렬:&nbsp;&nbsp;<br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - Divide: 파티션 <b>A[p...r]</b>는 (비어있을 가능성이 있는) 두 subArray <b>A[p .. q-1]</b>와 <b>A[q+1 .. r]</b>로 나뉜다.<br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &rarr; 첫 번째 subArray <b>A[p .. q-1]</b>의 각 요소 <b>&le;</b> <b>A[q]</b> <b>&le;</b> 두 번째 subArray <b>A[q+1 .. r]</b>의 각 요소.<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - Conquer: Quick Sort의 재귀호출을 이용하여 두 subArray를 정렬한다.<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;- Combine: <span style="background-color: #fdfdfd; color: #000000;">subArray는 정렬되어 있기 때문에 결합하는 작업은 필요하지 않다.</span></p>
<p data-ke-size="size16"></p>

<pre id="code_1636859959938" data-ke-language="java" data-ke-type="codeblock"><code>QUICKSORT(A, p, r)
1	if p &lt; r
2		q = PARTITION(A, p, r)
3		QUICKSORT(A, p, q-1)
4		QUICKSORT(A, q+1, r)</code></pre>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><b>3. Partitioning</b></blockquote>
<p data-ke-size="size16">&bull; <span style="background-color: #fdfdfd; color: #000000;">PARTION은 항상 subArray <b>A[p .. r]</b>의 마지막 요소 <b>A[r]</b>를 분할할 요소인 <b>피벗(pivot)</b>으로 선택한다.</span></p>
<p data-ke-size="size16">&bull; <span style="background-color: #fdfdfd; color: #000000;">절차가 실행될 때, array는 4개의 영역으로 분할되며 일부는 비어 있을 수 있다. (4개의 영역에 대해선 밑에서 설명)</span></p>
<p data-ke-size="size16">&bull; Loop Invariant:</p>
<p data-ke-size="size16">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - A[p .. i ]의 모든 요소 &le; pivot.</p>
<p data-ke-size="size16">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - A[i+1 .. j-1]의 모든 요소 &gt; pivot.</p>
<p data-ke-size="size16">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - A[r] = pivot.</p>
<p data-ke-size="size16">&bull; <span style="background-color: #fdfdfd; color: #000000;">loop invariant의 일부로 필요하지 않지만, 네 번째 영역은 A[ j . r-1]이며, 이 영역은 아직 검사되지 않았기 때문에 피벗과 어떻게 비교되는지 알 수 없다.&nbsp;</span><span style="background-color: #fdfdfd; color: #000000;"></span></p>
<pre id="code_1636862118062" class="java" data-ke-language="java" data-ke-type="codeblock"><code>PARTITION(A, p , r)
1	x = A[r]
2	i = p - 1
3	for j=p to r-1
4		if A[j] &le; x
5			i = i+1
6 			exchange A[i] with A[j]
7	exchange A[i+1] with A[r]
8	return i+1</code></pre>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;그림, 설명과 함께 보면서 이해해보자.</p>
<p align="center"><img src="https://user-images.githubusercontent.com/56003992/141670098-e226d496-de60-492f-b0df-659105811065.png"  width="500" height="700"></p>
<p> &nbsp;따라서 위에서 말한 4개의 영역은 다음과 같다.</p>
<p align="Left"><img src="https://user-images.githubusercontent.com/56003992/141670184-f6d26d9d-a551-4c6e-89e8-08b82743c493.JPG"  width="300" height="65"></p>

<p data-ke-size="size16">&nbsp;PARTITION 과정에서 이 4개의 영역을 항상 유지하는데, <b>A[p .. i]</b>은 피벗(x)보다 작거나 같다. <b>A[i+1 .. j-1]</b>은 피벗(x)보다 작고, 마지막 요소인 <b>A[r]</b>은 피벗(x)이다. 마지막으로 <b>A[j .. r-1]</b>은 아직 PARTITION이 실행되지 않은 subArray로, 아무 값이나 들어가 있을 수 있고, 비어있을 수도 있다.</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;알고리즘을 좀 더 상세히 보자면,</p>
<p align="Left"><img src="https://user-images.githubusercontent.com/56003992/141670214-a3818a3e-1f94-4b88-a7bb-f02ca018032c.JPG"  width="400" height="133"></p>
<p data-ke-size="size16">만약 A[j]가 피벗(x)보다 크다면, "j = j+1"를 수행하여 두 번째 SubArray의 크기를 늘리고,</p>
<p align="Left"><img src="https://user-images.githubusercontent.com/56003992/141670232-b8041816-a02c-4795-baad-0dac9f5ebd28.JPG"  width="400" height="133"></p>
<p data-ke-size="size16">반대로 A[j]가 피벗(x)보다 작거나 같으면, "i = i+1"을 수행하고, A[i]와 A[j]를 SWAP한 후 "j = j+1"을 수행한다.</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;이와 같은 방식으로 Loop Invariant를 유지한다.</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><b>4. 정확성</b></blockquote>
<p data-ke-size="size16">&rarr; <span style="background-color: #fdfdfd; color: #000000;">Loop Invariant를 사용하여 PARTITION의 정확성을 입증</span></p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16"><span style="background-color: #fdfdfd; color: #000000;"><b>i) Initialization</b></span></p>
<p data-ke-size="size16"><span style="background-color: #fdfdfd; color: #000000;"><span style="background-color: #fdfdfd; color: #000000;">: 루프가 시작되기 전, <b>r</b>은 피벗이고 subArray <b>A[p .. i]</b>와 <b>A[i+1 .. j-1]</b>은 비어 있기 때문에, Loop Invariant의 모든 조건이 충족된다.</span></span></p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16"><span style="background-color: #fdfdfd; color: #000000;"><span style="background-color: #fdfdfd; color: #000000;"><b>ii) Maintenance</b></span></span></p>
<p data-ke-size="size16"><span style="background-color: #fdfdfd; color: #000000;"><span style="background-color: #fdfdfd; color: #000000;">: 루프가 진행되는 동안, 만약 A[ j ] &le; pivot이면 A[j]와 A[i+1]은 SWAP하고 i와 j를 증가시킨다.</span></span></p>
<p data-ke-size="size16"><span style="background-color: #fdfdfd; color: #000000;"><span style="background-color: #fdfdfd; color: #000000;">: 만약 A[j] &gt; pivot이면, j만 증가시킨다.</span></span></p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16"><b><span style="background-color: #fdfdfd; color: #000000;"><span style="background-color: #fdfdfd; color: #000000;">iii) Termination</span></span></b></p>
<p data-ke-size="size16"><span style="background-color: #fdfdfd; color: #000000;"><span style="background-color: #fdfdfd; color: #000000;">: 루프가 종료됐을 때, j=r이므로 <span style="background-color: #fdfdfd; color: #000000;">A의 모든 요소는 세 가지 경우 중 하나로 분할된다.</span></span></span></p>
<p data-ke-size="size16">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - A[p . . i ] &le; pivot</p>
<p data-ke-size="size16">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - A[i+1 .. r-1] &gt; pivot</p>
<p data-ke-size="size16">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - A[r] = pivot</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16"><span style="background-color: #fdfdfd; color: #000000;">&bull; 파티션의 마지막 두 줄은 피벗 요소를 배열의 끝에서 두 하위 배열 사이로 이동한다.</span></p>
<p data-ke-size="size16">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &rarr; <span style="background-color: #fdfdfd; color: #000000;">피벗(A[r])과 두 번째 subArray의 첫 번째 요소(A[i + 1]) 교환</span></p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16"><span style="background-color: #fdfdfd; color: #000000;">&bull;<span> Partitioning의 시간 복잡도: O(n)&nbsp;</span></span></p>
<p data-ke-size="size16">&nbsp;</p>
