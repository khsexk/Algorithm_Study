func selection_Sort_ASCE(arr: [Int]) -> [Int] {
	var sortArr = arr
    
    for i in 0..<sortArr.count-1 {
        var index: Int = 0
        
       	for j in 1..<sortArr.count-i {
            if(sortArr[index] > sortArr[j]){
                sortArr.swapAt(index, j);
            }
            index += 1
       	} // for_j
    }
    return sortArr
}

func selection_Sort_DESC(arr: [Int]) -> [Int] {
	var sortArr = arr
    
    for i in 0..<sortArr.count-1 {
        var index: Int = 0
        
       	for j in 1..<sortArr.count-i {
            if(sortArr[index] < sortArr[j]){
                sortArr.swapAt(index, j);
            }
            index += 1
       	} // for_j
    }
    	return sortArr
}

var a = [2, 4, 3, 5, 1]

print(selection_Sort_ASCE(arr: a))
print(selection_Sort_DESC(arr: a))