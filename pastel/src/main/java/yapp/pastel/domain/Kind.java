package yapp.pastel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Kind {
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  private Long id;

  @ManyToOne
  @JsonBackReference
  private Cake cake;
  
  private String size;
  private Integer price;
}
