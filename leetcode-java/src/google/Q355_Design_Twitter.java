package google;

import java.util.*;

public class Q355_Design_Twitter {

    class Twitter {
        Map<Integer, LinkedList<Tweet>> tweets = new HashMap<>();
        Map<Integer, Set<Integer>> followees = new HashMap<>();
        int worldclock = 0;
        /** Initialize your data structure here. */
        public Twitter() {
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            tweets.computeIfAbsent(userId, k -> new LinkedList<>());
            tweets.get(userId).addFirst(new Tweet(tweetId, worldclock++));
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> result = new LinkedList<>();
            PriorityQueue<Tweet> Q = new PriorityQueue<>((a, b) -> b.timestamp-a.timestamp);
            Set<Integer> users = followees.getOrDefault(userId, new HashSet<>());
            users.add(userId);
            for (int user : users) {
                int k = 0;
                for (Tweet tweet : tweets.getOrDefault(user, new LinkedList<>())) {
                    Q.add(tweet);
                    k++;
                    if (k == 10) break;
                }
            }
            while (result.size() < 10 && !Q.isEmpty()) {
                result.add(0, Q.poll().id);
            }
            return result;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }
            followees.computeIfAbsent(followerId, k -> new HashSet<>());
            followees.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (!followees.containsKey(followerId)) {
                return;
            }
            followees.get(followerId).remove(followeeId);
        }
    }

    class Tweet {
        int id;
        int timestamp;
        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
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

}
