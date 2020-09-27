package main

import (
	"fmt"
	"sync"
)

func first(wg *sync.WaitGroup, ch1 chan bool) {
	defer wg.Done()
	fmt.Println("first")
	ch1 <- true
}
func second(wg *sync.WaitGroup, ch1 chan bool, ch2 chan bool) {
	defer wg.Done()
	<-ch1
	fmt.Println("second")
	ch2 <- true
}
func third(wg *sync.WaitGroup, ch2 chan bool) {
	defer wg.Done()
	<-ch2
	fmt.Println("third")
}

/**
func main() {
	var wg sync.WaitGroup
	ch1 := make(chan bool)
	ch2 := make(chan bool)
	wg.Add(3)
	go third(&wg, ch2)
	go second(&wg, ch1, ch2)
	go first(&wg, ch1)
	wg.Wait()
}*/
