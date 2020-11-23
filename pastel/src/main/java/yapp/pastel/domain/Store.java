package yapp.pastel.domain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Store {
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Long id;
  private String email;
  private String name;
  private String photoUrl;

  private String zone;
  private String location;
  private String locationDetail;
  private LocalTime openTime;
  private LocalTime closeTime;
  private String notice;
  private String contact;
  private String introduce;

  @ColumnDefault("0")
  private Long view;

  @OneToMany
  private List<Cake> cakes = new ArrayList<>();
}
