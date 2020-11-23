package yapp.pastel.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cake {
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  private Long id;

  private String name;
  private String photoUrl;
  private String description;
  private LocalDateTime createdAt;

  @ColumnDefault("0")
  private Integer likes;

  @ColumnDefault("0")
  private Integer views;

  // @ManyToMany(mappedBy = "cake", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  // @JsonManagedReference
  @ElementCollection(targetClass=String.class)
  private Set<String> tags = new HashSet<>();

  @OneToMany(mappedBy = "cake", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JsonManagedReference
  private Set<Kind> kinds = new HashSet<>();

  @PrePersist
  public void createdAt() {
    createdAt = LocalDateTime.now();
  }
}
