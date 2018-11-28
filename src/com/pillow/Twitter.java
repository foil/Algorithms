package com.pillow;

class Twitter {
    private map<Integer, List<Integer>> follows;
    private map<Integer, List<Integer>> userTweets;
    private List<Integer> tweets;

    /** Initialize your data structure here. */
    public Twitter() {
        follows = new HashMap<>();
        userTweets = new HashMap<>();
        tweets = new ArrayList<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.add(tweetId);
        List<Integer>l = userTweets.get(userId);
        if (l == null) {
            l = new ArrayList<>();
            userTweets.put(userId, l);
        }
        l.add(tweets.size() - 1);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        List<Integer> l = follows.get(userId);
        if (l == null) {
            List<Integer> t = userTweets.get(userId);
            if (t != null) {
                for (int i = t.size() - 1, c = 0; i >= 0 && c < 10; i --, c ++) {
                    res.add(tweets.get(t.get(i)));
                }
            }
        } else {

    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
