func insertion_Sort_ASCE(arr: [Int]) -> [Int] {
	var sortArr = arr
    
    	for i in 1..<sortArr.count {
    		var index = i
        
       		while index > 0 , sortArr[index] < sortArr[index - 1] {
        		sortArr.swapAt(index, index - 1)
            		index -= 1
        	}
    	}
    	return sortArr
}

func insertion_Sort_DESC(arr: [Int]) -> [Int] {
	var sortArr = arr
    
    	for i in 1..<sortArr.count {
    		var index = i
        
       		while index > 0 , sortArr[index] > sortArr[index - 1] {
        		sortArr.swapAt(index, index - 1)
            		index -= 1
        	}
    	}
    	return sortArr
}

var a = [2, 4, 3, 5, 1]

print(insertion_Sort_ASCE(arr: a))
print(insertion_Sort_DESC(arr: a))