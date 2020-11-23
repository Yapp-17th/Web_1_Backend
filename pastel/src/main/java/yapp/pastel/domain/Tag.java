package yapp.pastel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
// @AllArgsConstructor
public class Tag {
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  // private Long id;
  public Tag(String content) {
    this.content = content;
    this.count = 1L;
  }
  
  @Id
  private String content;

  // @ManyToOne
  // @JsonBackReference
  // private Cake cake;

  @ColumnDefault("0")
  private Long count;
}
