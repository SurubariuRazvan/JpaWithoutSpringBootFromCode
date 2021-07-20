package org.example.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(indexes = @Index(name = "idAndName", columnList = "id, name", unique = true))
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	public Integer id;
	public String name;
	
}
