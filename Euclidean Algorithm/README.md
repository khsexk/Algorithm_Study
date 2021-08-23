<blockquote data-ke-style="style2"><br /><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';"><b>유클리드 호제법이란?</b></span></blockquote>
<p data-ke-size="size16"><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';">&nbsp; 유클리드 호제법<span style="color: #202122;">(Euclidean algorithm)이란</span><span style="color: #202122;">&nbsp;2개의&nbsp;자연수</span><span style="color: #202122;">&nbsp;또는 정식의&nbsp;최대공약수</span><span style="color: #202122;">를 구하는 알고리즘 중</span><span style="color: #202122;"> 하나다. 호제법이란 말은 두 수가 서로 상대방 수를 나눠서 결국 원하는 수를 얻는 알고리즘인데, 2개의 자연수(또는 정식) a, b에 대해서 a를 b로 나눈 나머지</span><span style="color: #202122;">를 r이라 하면(단, a&gt;b), a와 b의 최대공약수는 b와 r의 최대공약수와 같다. 이 성질에 따라, b를 r로 나눈 나머지 r'를 구하고, 다시 r을 r'로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다.&nbsp;</span></span></p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16"><span style="color: #202122; font-family: 'Noto Sans Demilight', 'Noto Sans KR';">&nbsp; 이렇게만 설명하면 이해하기 어려울 수 있으므로, 증명하는 과정을 이해하고 필기해보았다.</span></p>
<p>[##_Image|kage@m7GGD/btraZLMMV9p/U2UvfPYUl2ts4Xs8KHTi8k/img.png|alignCenter|data-origin-width="829" data-origin-height="1277" width="617" height="950" data-ke-mobilestyle="widthOrigin"|||_##]</p>
<p data-ke-size="size16"><span style="color: #202122; font-family: 'Noto Sans Demilight', 'Noto Sans KR';">&nbsp;iPad가 익숙하지 않아 글씨가 엉망이긴 하지만, 아무튼 이런식으로 증명된다. 그럼 이제부터 코드를 통해 알아보자. (코드는 java와 Swift로 구성하였다.)</span></p>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';"><b>1. Java (자바)</b></span></blockquote>
<pre id="code_1627921878583" class="java" data-ke-language="java" data-ke-type="codeblock"><code>int gcd(int l, int s) {
	if(l%s == 0)
            return s;
	return gcd(s,l%s));
}</code></pre>
<p data-ke-size="size16"><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';">&nbsp;위와 같이 구현해도 간단한데, 람다식을 이용하여 조금 더 줄여보자.</span></p>
<pre id="code_1627921926663" class="swift" data-ke-language="swift" data-ke-type="codeblock"><code>int gcd(int l, int s){
     return (l%s == 0) ? s : gcd(s,l%s);
}</code></pre>
<p data-ke-size="size16"><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';">&nbsp;이렇게 한줄로도 구현된다.</span></p>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';"><b>2. Swift (스위프트)</b></span></blockquote>
<pre id="code_1627922036680" class="swift" data-ke-language="swift" data-ke-type="codeblock"><code>func gcd(_ l: Int, _ s: Int) -&gt; Int {
    return l%s == 0 ? s : gcd(s, l%s)
}</code></pre>
<p data-ke-size="size16"><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';">&nbsp;람다식으로 표현한 자바와 동일하다.</span></p>
