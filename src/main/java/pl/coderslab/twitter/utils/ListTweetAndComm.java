package pl.coderslab.twitter.utils;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.twitter.entity.Comment;
import pl.coderslab.twitter.entity.Tweet;
import pl.coderslab.twitter.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;


public class ListTweetAndComm {

    @Autowired
    CommentRepository commentRepository;

    Tweet tweet  = new Tweet();

    List<Comment> commentList = new ArrayList<>();

    public ListTweetAndComm(Tweet tweet) {
        this.tweet = tweet;
        //System.out.println(commentRepository.findAllByTweetId(tweet.getId()));
        //this.commentList = commentRepository.findAllByTweetId(tweet.getId());

    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }

    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
