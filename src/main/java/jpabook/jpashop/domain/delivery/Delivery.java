package jpabook.jpashop.domain.delivery;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.order.Order;
import lombok.Getter;

@Entity
@Getter
public class Delivery {
	@Id
	@GeneratedValue
	@Column(name = "DELIVERY_ID")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
	private Order order;

	@Embedded
	private Address address;

	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;

	public void setOrder(Order order) {
		this.order = order;
	}
}
