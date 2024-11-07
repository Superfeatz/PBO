import java.util.ArrayList;
import java.util.List;


// Network.java remains the same
public class Network {
    private List<User> users;
    private List<Post> allPosts;
    
    public Network() {
        users = new ArrayList<>();
        allPosts = new ArrayList<>();
    }
    
    public void addUser(User user) {
        users.add(user);
    }
    
    public void addPost(Post post) {
        allPosts.add(post);
    }
    
    public List<User> getUsers() {
        return users;
    }
    
    public List<Post> getAllPosts() {
        return allPosts;
    }
}
