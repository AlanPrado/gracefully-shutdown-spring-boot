package test.gracefully.shutdown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.gracefully.shutdown.post.Post;
import test.gracefully.shutdown.post.PostRepository;

import javax.annotation.PostConstruct;

@Configuration
public class DataLoader {

    @Autowired
    private PostRepository repository;

    @PostConstruct
    private void loadData() {
        Post post = new Post();
        post.setName("My first post");
        repository.save(post);
    }

}
