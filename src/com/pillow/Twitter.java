package com.pillow;

import java.util.*;

class Twitter {
    private Map<Integer, Set<Integer>> follows;
    private Map<Integer, List<Integer>> userTweets;
    private Map<Integer, Integer> tweets;
    private int count;

    /** Initialize your data structure here. */
    public Twitter() {
        follows = new HashMap<>();
        userTweets = new HashMap<>();
        tweets = new HashMap<>();
        count = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.put(tweetId, count++);
        List<Integer> l = userTweets.computeIfAbsent(userId, k -> new ArrayList<>());
        l.add(0, tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> l = new ArrayList<>();
        if (userTweets.containsKey(userId))
            l.add(userTweets.get(userId));
        if (follows.containsKey(userId)) {
            for (int followee: follows.get(userId))
                if (followee != userId && userTweets.containsKey(followee))
                    l.add(userTweets.get(followee));
        }
        int[] indice = new int[l.size()];
        int max, index;
        while (res.size() < 10) {
            max = -1;
            index = -1;
            for (int i = 0; i < l.size(); i ++) {
                List<Integer> ll = l.get(i);
                if (indice[i] < ll.size()) {
                    int tid = ll.get(indice[i]);
                    if (tweets.get(tid) > max) {
                        max = tweets.get(tid);
                        index = i;
                    }
                }
            }
            if (index < 0)
                return res;
            res.add(l.get(index).get(indice[index]));
            indice[index]++;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId)) {
            follows.put(followerId, new HashSet<>());
        }
        follows.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
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
