func selection_Sort_ASCE(arr: [Int]) -> [Int] {
	var sortArr = arr
    
    for i in 0..<sortArr.count {
    	var minIdx = i
        
       	for j in (i+1)..<sortArr.count{
            if(sortArr[minIdx]>sortArr[j]){
       	        minIdx = j
       	    }
       	}
       	if(i != minIdx){
       		sortArr.swapAt(i, minIdx)
       	}
    }
    return sortArr
}

func selection_Sort_DESC(arr: [Int]) -> [Int] {
	var sortArr = arr
    
    for i in 0..<sortArr.count {
    	var maxIdx = i
        
       	for j in (i+1)..<sortArr.count{
            if(sortArr[maxIdx]<sortArr[j]){
       	        maxIdx = j
       	    }
       	}
       	if(i != maxIdx){
       		sortArr.swapAt(i, maxIdx)
       	}
    }
    	return sortArr
}

var a = [2, 4, 3, 5, 1]

print(selection_Sort_ASCE(arr: a))
print(selection_Sort_DESC(arr: a))