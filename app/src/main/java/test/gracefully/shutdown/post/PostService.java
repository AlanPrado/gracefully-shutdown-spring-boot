 package test.gracefully.shutdown.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.gracefully.shutdown.exception.ResourceNotFound;

import javax.transaction.Transactional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public void like(Long id) {
        Post post = findPost(id);
        post.like();
        postRepository.save(post);
    }

    public Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Post not found"));
    }
}
