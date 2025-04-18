package entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
  private List<SubjectRegistration> registrations;

  public Subject() {}
  public Subject(String title) {
    this.title = title;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<SubjectRegistration> getRegistrations() {
    return registrations;
  }

  public void setRegistrations(List<SubjectRegistration> registrations) {
    this.registrations = registrations;
  }

  @Override
  public String toString() {
    return "Subject{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", registrations=" + registrations +
        '}';
  }
}