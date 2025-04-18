package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String content;

  @ManyToOne // 1 : N   중 N 이 Onwership을 가짐
  private Post post;
  // @ManyToOne 관계를 가진 Table comment 에 연결 컬럼은 직접 지정하지 않으면 non-owing entity의 이름 + "_id" 로 자동 생성된다.

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  @Override
  public String toString() {
    return "Comment{" +
        "id=" + id +
        ", content='" + content + '\'' +
        ", post=" + post +
        '}';
  }
}
