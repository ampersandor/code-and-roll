package main

import "fmt"

func main() {
	var a, b, c, d, e int
	fmt.Scanf("%d %d %d %d %d", &a, &b, &c, &d, &e)
	res := (a*a + b*b + c*c + d*d + e*e) % 10
	fmt.Println(res)
}
