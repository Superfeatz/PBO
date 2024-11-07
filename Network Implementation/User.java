import java.util.ArrayList;
import java.util.List;

// User.java
public class User {
    private String username;
    private List<Post> posts;
    private List<User> following;
    private Network network;  // Add reference to network
    
    public User(String username, Network network) {  // Modified constructor
        this.username = username;
        this.posts = new ArrayList<>();
        this.following = new ArrayList<>();
        this.network = network;
    }
    
    public void createPost(String content) {
        Post post = new Post(content, this);
        posts.add(post);
        network.addPost(post);  // Add post to network
    }
    
    public void likePost(Post post) {
        post.addLike(this);
    }
    
    public void follow(User user) {
        if (!following.contains(user)) {
            following.add(user);
        }
    }
    
    public String getUsername() {
        return username;
    }
    
    public List<Post> getPosts() {
        return posts;
    }
    
    public List<User> getFollowing() {
        return following;
    }
}