/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Bíró Zoltán
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Movie implements Serializable {
  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(unique = true)
  @NotNull
  private String name;
  
  @Column
  @NotNull
  private String genre;
  
  @Column(length = 1000)
  @NotNull
  private String description;
  
  @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
  private List<Projection> projections;
  
  public String getName() {
      return name;
  }
  
  public String getGenre() {
      return genre;
  }
  
  public String getDescription() {
      return description;
  }
  
  public List<Projection> getProjection() {
      return projections;
  }
  
}
