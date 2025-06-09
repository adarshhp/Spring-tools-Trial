package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name="plant_table")
public class Plants {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer Id;
  private String plantname;
  private String plantcolor;
  @Column(name = "is_deleted", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
  private int is_deleted = 0;
public Integer getId() {
	return Id;
}
public void setId(Integer id) {
	Id = id;
}
public String getPlantname() {
	return plantname;
}
public void setPlantname(String plantname) {
	this.plantname = plantname;
}
public String getPlantcolor() {
	return plantcolor;
}
public void setPlantcolor(String plantcolor) {
	this.plantcolor = plantcolor;
}
public int getIs_deleted() {
	return is_deleted;
}
public void setIs_deleted(int is_deleted) {
	this.is_deleted = is_deleted;
}
  
}
