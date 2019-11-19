package driveme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@Entity
@Table(name = "car")
public class car {
	@Id
	@GeneratedValue
	@Column(name = "car_id")
	private Long car_id;

	@Column(name = "car")
	private String car;

	@Column(name = "car_model")
	private String car_model;

	@Column(name = "reg_number")
	private String reg_number;

	@Column(name = "owned_by")
	private Long owned_by;

	public Long getCar_id() {
		return car_id;
	}

	public void setCar_id(Long car_id) {
		this.car_id = car_id;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}

	public String getReg_number() {
		return reg_number;
	}

	public void setReg_number(String reg_number) {
		this.reg_number = reg_number;
	}

	public Long getOwned_by() {
		return owned_by;
	}

	public void setOwned_by(Long owned_by) {
		this.owned_by = owned_by;
	}

}
