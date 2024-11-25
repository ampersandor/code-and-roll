package main

import (
	"fmt"
	"strconv"
)

func main() {
	var a, b, c int
	fmt.Scanf("%d", &a)
	fmt.Scanf("%d", &b)
	fmt.Scanf("%d", &c)
	fmt.Println(a + b - c)
	result, _ := strconv.Atoi(strconv.Itoa(a) + strconv.Itoa(b))
	fmt.Println(result - c)

}
