package test.gracefully.shutdown.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "posts")
public class PostController {

	@Autowired
	private PostService postService;

	@RequestMapping("/{id}")
	public Post getPost(@PathVariable("id") Long id) {
		return postService.findPost(id);
	}

	@PostMapping(value = "/{id}/like")
	public void like(@PathVariable("id") Long id) {
		postService.like(id);
	}

}
