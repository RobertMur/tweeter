package pl.coderslab.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.twitter.entity.Comment;
import pl.coderslab.twitter.entity.Tweet;
import pl.coderslab.twitter.entity.User;
import pl.coderslab.twitter.repository.CommentRepository;
import pl.coderslab.twitter.repository.TweetRepository;
import pl.coderslab.twitter.repository.UserRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    Validator validator;


    @RequestMapping(value="/add", method = RequestMethod.GET) // /tweet/add?userId=1
    public String showAddTweetForm(Model model, @RequestParam("userId") Long userId) { // TODO automativ strong 2 long conversion
        Tweet t = new Tweet();
        t.setUser(userRepository.findById(userId).get());
        model.addAttribute("tweet", t);
        return "tweetForm";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String saveTweet(@Valid Tweet tweet, BindingResult result,  Model model) {

        if (result.hasErrors()) {
            return "tweetForm";
        }
        tweet.setCreated(new Date());
        tweetRepository.save(tweet);
        return "redirect:/user/" + tweet.getUser().getId() ;
    }


    @ModelAttribute("/all")
    public List<Tweet> getAllTweets() {
        List<Tweet> tweetList= tweetRepository.findAll();
        return tweetList;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTweet(Model model, @PathVariable Long id) {

        Tweet tweet = tweetRepository.getOne(id);
        model.addAttribute("tweet", tweet);
        return "tweetForm";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editTweetPost(@Valid Tweet tweet, BindingResult result) {
//        User user = userRepository.getOne(id);
//        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "tweetForm";
        }
        tweet.setCreated(new Date());
//        tweet.setUser(user);
        tweetRepository.save(tweet);
        return "redirect:/user/" + tweet.getUser().getId();
    }


    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteTweet(@PathVariable Long id) {
        Tweet deleteTweet = tweetRepository.getOne(id);
        Long userId = deleteTweet.getUser().getId();
        tweetRepository.delete(deleteTweet);
        return "redirect:/user/" + userId;
    }

    @RequestMapping(value = "/{id}/comment", method = RequestMethod.GET)
    public String commentPrepare(Model model, @PathVariable Long id){

        model.addAttribute("comment", new Comment());
        return "commentForm";
    }

    @RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
    public String comment(@ModelAttribute Comment comment, @PathVariable Long id){
        User commentingUser = userRepository.getOne(1L); // TODO get logged in user
        Comment com = new Comment();
        com.setUser(commentingUser);
        com.setTweet(tweetRepository.getOne(id));
        com.setText(comment.getText());
        com.setCreated(new Date());

        commentRepository.save(com);

        return "redirect:/";

    }
}
