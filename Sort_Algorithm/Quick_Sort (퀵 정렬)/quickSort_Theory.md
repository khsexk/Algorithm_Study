# Quick Sort

### 1. About Quick Sort
• Worst-case running time: (n²).
• Expected running time: (n lg n).
• Constants hidden in (n lg n) are small.
• Based on the three-step process of divide-and-conquer.
• To sort the subarray A[p . . r]:

– Divide: Partition A[p..r], into two (possibly empty) subarrays A[p .. q-1]
and A[q+1 .. r], such that each element in the first subarray A[p .. q-1] is
 A[q] and A[q] is  each element in the second subarray A[q+1 .. r].
– Conquer: Sort the two subarrays by recursive calls to QUICKSORT.
– Combine: No work is needed to combine the subarrays, because they
are sorted in place.
• Perform the divide step by a procedure PARTITION, which
returns the index q that marks the position separating the
subarrays.

