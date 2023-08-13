package jpabook.jpashop.domain.order_item;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.order.Order;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID") // 외래키
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ITEM_ID") // 외래키
	private Item item;

	private int orderPrice; // 주문 가격

	private int count; // 주문 수량

	//==연관 관계 메소드==//
	public void setOrder(Order order) {
		this.order = order;
	}
}
