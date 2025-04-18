package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SubjectRegistration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Student student;

  @ManyToOne(fetch = FetchType.LAZY)
  private Subject subject;

  public SubjectRegistration() {}
  public SubjectRegistration(Student student, Subject subject) {
    this.student = student;
    this.subject = subject;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  @Override
  public String toString() {
    return "SubjectRegistration{" +
        "id=" + id +
        ", student=" + student +
        ", subject=" + subject +
        '}';
  }
}