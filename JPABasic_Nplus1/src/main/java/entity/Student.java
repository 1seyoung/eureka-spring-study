package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  private School school;

  @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
  private List<SubjectRegistration> registrations;

  public Student() {}
  public Student(String name, School school) {
    this.name = name;
    this.school = school;
  }

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

  public School getSchool() {
    return school;
  }

  public void setSchool(School school) {
    this.school = school;
  }

  public List<SubjectRegistration> getRegistrations() {
    return registrations;
  }

  public void setRegistrations(List<SubjectRegistration> registrations) {
    this.registrations = registrations;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", school=" + school +
        ", registrations=" + registrations +
        '}';
  }
}