package main

import (
	"fmt"
	"sync"
)

func Foo(wg *sync.WaitGroup, ch1 chan bool, ch2 chan bool) {
	defer wg.Done()
	for i := 0; i < 10; i++ {
		<-ch1
		fmt.Printf("foo %d\n", i)
		ch2 <- true
	}
}
func Bar(wg *sync.WaitGroup, ch1 chan bool, ch2 chan bool) {
	defer wg.Done()
	for i := 0; i < 10; i++ {
		<-ch2
		fmt.Printf("bar %d\n", i)
		ch1 <- true
	}
}

/**
func main() {
	var wg sync.WaitGroup
	wg.Add(2)
	m1 := make(chan bool, 1)
	m2 := make(chan bool)
	go Foo(&wg, m1, m2)
	go Bar(&wg, m1, m2)
	m1 <- true
	wg.Wait()
}
*/
