import Foundation

func gcd(_ l: Int, _ s: Int) -> Int {
    return l % s == 0 ? s : gcd(s, l % s)
}

let a = readLine()
let b = readLine()

var l = 0
var s = 0

if a >= b {
    l = a
    s = b
} else{
    l = b
    s = a
}
var gcdNum = gcd(l, s)

print("GCD: ", gcdNum)