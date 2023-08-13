package jpabook.jpashop.domain.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import jpabook.jpashop.domain.delivery.Delivery;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.domain.order_item.OrderItem;
import lombok.Getter;

@Entity
@Table(name = "orders")
@Getter
public class Order {
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "DELIVERY_ID")
	private Delivery delivery;

	private LocalDateTime orderDate;

	private OrderStatus status; // 주문상태 : [ORDER ,CANCEL]

	//==연관관계 메소드==//
	public void setMember(Member member){
		this.member = member;
		member.getOrders().add(this);
	}

	public void addOrderItem(OrderItem orderItem){
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public void setDelivery(Delivery delivery){
		this.delivery = delivery;
		delivery.setOrder(this);
	}
}
