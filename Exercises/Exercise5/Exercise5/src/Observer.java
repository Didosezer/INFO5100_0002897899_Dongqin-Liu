import java.util.ArrayList;
import java.util.List;

interface Observer { void update(String tweet);}
interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyUpdate(String tweet);
}

// Concrete Subject
class TwitterUser implements Subject {
    private List<Observer> followers = new ArrayList<>();
    private String userName;

    public TwitterUser(String userName) {
        this.userName = userName;
    }

    public void tweet(String tweet) {
        System.out.println(userName + " tweeted: " + tweet);
        notifyUpdate(tweet);
    }

    @Override
    public void attach(Observer o) {
        followers.add(o);
    }

    @Override
    public void detach(Observer o) {
        followers.remove(o);
    }

    @Override
    public void notifyUpdate(String tweet) {
        for (Observer follower : followers) {
            follower.update(tweet);
        }
    }
}

// Concrete Observer
class Follower implements Observer {
    private String followerName;

    public Follower(String name) {
        this.followerName = name;
    }

    @Override
    public void update(String tweet) {
        System.out.println(followerName + " received tweet: " + tweet);
    }
//}

// Main class to demonstrate
//public class TwitterDemo {
    public static void main(String[] args) {
        TwitterUser user = new TwitterUser("JohnDoe");
        Follower alice = new Follower("Alice");
        Follower bob = new Follower("Bob");

        user.attach(alice);
        user.attach(bob);

        user.tweet("Hello World!");
    }
}

