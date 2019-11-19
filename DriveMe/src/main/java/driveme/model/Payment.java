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
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue
	@Column(name = "payment_id")
	private Long payment_id; // PK

	@Column(name = "amount_paid")
	private Long amount_paid;

	@Column(name = "payment_map_rr")
	private Long payment_map_rr; // foreign key, RideRequestMapping

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", amount_paid=" + amount_paid + ", payment_map_rr="
				+ payment_map_rr + "]";
	}

	public Long getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}

	public Long getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(Long amount_paid) {
		this.amount_paid = amount_paid;
	}

	public Long getPayment_map_rr() {
		return payment_map_rr;
	}

	public void setPayment_map_rr(Long payment_map_rr) {
		this.payment_map_rr = payment_map_rr;
	}

}
