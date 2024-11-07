import java.util.ArrayList;
import java.util.List;


// Post.java remains the same
public class Post {
    private String content;
    private User author;
    private List<User> likes;
    
    public Post(String content, User author) {
        this.content = content;
        this.author = author;
        this.likes = new ArrayList<>();
    }
    
    public void addLike(User user) {
        if (!likes.contains(user)) {
            likes.add(user);
        }
    }
    
    public String getContent() {
        return content;
    }
    
    public User getAuthor() {
        return author;
    }
    
    public int getLikeCount() {
        return likes.size();
    }
}
