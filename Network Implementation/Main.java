// Main.java
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Network network = new Network();
    
    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            System.out.println("\n=== Simple Social Network ===");
            System.out.println("1. Create new user");
            System.out.println("2. Create post");
            System.out.println("3. Like a post");
            System.out.println("4. Follow user");
            System.out.println("5. View all posts");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    createPost();
                    break;
                case 3:
                    likePost();
                    break;
                case 4:
                    followUser();
                    break;
                case 5:
                    viewAllPosts();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        
        System.out.println("Thank you for using Simple Social Network!");
    }
    
    private static void createUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        User user = new User(username, network);  // Pass network reference
        network.addUser(user);
        System.out.println("User created successfully!");
    }
    
    private static void createPost() {
        if (network.getUsers().isEmpty()) {
            System.out.println("No users exist! Please create a user first.");
            return;
        }
        
        System.out.println("Select user:");
        for (int i = 0; i < network.getUsers().size(); i++) {
            System.out.println((i+1) + ". " + network.getUsers().get(i).getUsername());
        }
        
        int userIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        
        if (userIndex >= 0 && userIndex < network.getUsers().size()) {
            System.out.print("Enter post content: ");
            String content = scanner.nextLine();
            
            User user = network.getUsers().get(userIndex);
            user.createPost(content);
            System.out.println("Post created successfully!");
        } else {
            System.out.println("Invalid user selection!");
        }
    }
    
    private static void likePost() {
        if (network.getAllPosts().isEmpty()) {
            System.out.println("No posts exist!");
            return;
        }
        
        System.out.println("Select post to like:");
        for (int i = 0; i < network.getAllPosts().size(); i++) {
            Post post = network.getAllPosts().get(i);
            System.out.println((i+1) + ". " + post.getContent() + " (by " + post.getAuthor().getUsername() + ")");
        }
        
        int postIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        
        if (postIndex >= 0 && postIndex < network.getAllPosts().size()) {
            System.out.println("Select user who is liking:");
            for (int i = 0; i < network.getUsers().size(); i++) {
                System.out.println((i+1) + ". " + network.getUsers().get(i).getUsername());
            }
            
            int userIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume newline
            
            if (userIndex >= 0 && userIndex < network.getUsers().size()) {
                User user = network.getUsers().get(userIndex);
                Post post = network.getAllPosts().get(postIndex);
                user.likePost(post);
                System.out.println("Post liked successfully!");
            } else {
                System.out.println("Invalid user selection!");
            }
        } else {
            System.out.println("Invalid post selection!");
        }
    }
    
    private static void followUser() {
        if (network.getUsers().size() < 2) {
            System.out.println("Not enough users to follow! Need at least 2 users.");
            return;
        }
        
        System.out.println("Select user who will follow:");
        for (int i = 0; i < network.getUsers().size(); i++) {
            System.out.println((i+1) + ". " + network.getUsers().get(i).getUsername());
        }
        
        int followerIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        
        if (followerIndex >= 0 && followerIndex < network.getUsers().size()) {
            System.out.println("Select user to follow:");
            for (int i = 0; i < network.getUsers().size(); i++) {
                if (i != followerIndex) {
                    System.out.println((i+1) + ". " + network.getUsers().get(i).getUsername());
                }
            }
            
            int followeeIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume newline
            
            if (followeeIndex >= 0 && followeeIndex < network.getUsers().size() && followeeIndex != followerIndex) {
                User follower = network.getUsers().get(followerIndex);
                User followee = network.getUsers().get(followeeIndex);
                follower.follow(followee);
                System.out.println("Now following user!");
            } else {
                System.out.println("Invalid user selection!");
            }
        } else {
            System.out.println("Invalid user selection!");
        }
    }
    
    private static void viewAllPosts() {
        if (network.getAllPosts().isEmpty()) {
            System.out.println("No posts exist!");
            return;
        }
        
        System.out.println("\n=== All Posts ===");
        for (Post post : network.getAllPosts()) {
            System.out.println("Author: " + post.getAuthor().getUsername());
            System.out.println("Content: " + post.getContent());
            System.out.println("Likes: " + post.getLikeCount());
            System.out.println("-------------------");
        }
    }
}