package main

import "sync"

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
