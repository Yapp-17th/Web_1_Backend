package yapp.pastel.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Review {
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  private Long id;
  
  private Long storeId;
  private Float rating;

  @ColumnDefault("0")
  private Integer likes;
  
  private String photoUrl;
  private String comment;
  private String content;
  private LocalDateTime createdAt;

  @PrePersist
  public void createdAt() {
    createdAt = LocalDateTime.now();
  }
}
