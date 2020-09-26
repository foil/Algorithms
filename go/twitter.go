package main

import "fmt"

type Twitter struct {
	userTweets	map[int][]int
	userFollows	map[int]map[int]bool
	tweets	map[int]int
	count	int
}


/** Initialize your data structure here. */
func Constructor() Twitter {
	return Twitter{
		count: 0,
		userTweets: map[int][]int{},
		userFollows: map[int]map[int]bool{},
		tweets: map[int]int{},
	}
}


/** Compose a new tweet. */
func (this *Twitter) PostTweet(userId int, tweetId int)  {
	this.tweets[tweetId] = this.count
	this.count += 1
	this.userTweets[userId] = append(this.userTweets[userId], tweetId)
}


/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
func (this *Twitter) GetNewsFeed(userId int) []int {
	res := make([]int, 0)
	l := make([][]int, 0)
	if ll, has := this.userTweets[userId]; has {
		l = append(l, ll)
	}
	if m, has := this.userFollows[userId]; has {
		for t := range m {
			if t == userId {
				continue
			}
			if ll, has := this.userTweets[t]; has {
				l = append(l, ll)
			}
		}
	}
	if len(l) == 0 {
		return res
	}
	indice := make([]int, len(l))
	for idx, ll := range l {
		indice[idx] = len(ll) - 1
	}
	for len(res) < 10 {
		max := -1
		index := -1
		for idx, ll := range l {
			if indice[idx] >= 0 {
				tid := ll[indice[idx]]
				if this.tweets[tid] > max {
					max = this.tweets[tid]
					index = idx
				}
			}
		}
		if index < 0 {
			return res
		}
		res = append(res, l[index][indice[index]])
		indice[index] -= 1
	}
	return res
}


/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
func (this *Twitter) Follow(followerId int, followeeId int)  {
	if _, has := this.userFollows[followerId]; !has {
		this.userFollows[followerId] = map[int]bool{}
	}
	if _, exists := this.userFollows[followerId][followeeId]; !exists {
		this.userFollows[followerId][followeeId] = true
	}
}


/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
func (this *Twitter) Unfollow(followerId int, followeeId int)  {
	if _, has := this.userFollows[followerId]; has {
		if _, exists := this.userFollows[followerId][followeeId]; exists {
			delete(this.userFollows[followerId], followeeId)
		}
	}
}


/**
 * Your Twitter object will be instantiated and called as such:
 * obj := Constructor();
 * obj.PostTweet(userId,tweetId);
 * param_2 := obj.GetNewsFeed(userId);
 * obj.Follow(followerId,followeeId);
 * obj.Unfollow(followerId,followeeId);
 */

func main()  {
	twitter := Constructor()
	// User 1 posts a new tweet (id = 5).
	twitter.PostTweet(1, 5)

	// User 1's news feed should return a list with 1 tweet id -> [5].
	fmt.Println(twitter.GetNewsFeed(1))

	// User 1 follows user 2.
	twitter.Follow(1, 2)

	// User 2 posts a new tweet (id = 6).
	twitter.PostTweet(2, 6)

	// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
	// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
	fmt.Println(twitter.GetNewsFeed(1))

	// User 1 unfollows user 2.
	twitter.Unfollow(1, 2)

	// User 1's news feed should return a list with 1 tweet id -> [5],
	// since user 1 is no longer following user 2.
	fmt.Println(twitter.GetNewsFeed(1))
}