/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Projection implements Serializable {
  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  @JoinColumn(name="movie_id")
  private Movie movie;
  
  @ManyToOne
  @JoinColumn(name="room_id")
  private Room room;
  
  @Column
  @NotNull
  private Date projectionDate;
  
  public Movie getMovie() {
      return movie;
  }
  
  public Room getRoom() {
      return room;
  }
  
  public Date getProjectionDate() {
      return projectionDate;
  }
  
}
