package DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Car")
public class CarDTO {

@Id
@Column(name="Number")
private int carNo;

@Column(name="Car_Name")
private String carName;
@Column(name="BrandName")
private String brandName;

}
