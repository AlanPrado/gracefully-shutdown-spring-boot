package test.gracefully.shutdown.post;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int likes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public int like() {
        return ++this.likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return name.equals(post.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
