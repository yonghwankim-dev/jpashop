package jpabook.jpashop.domain;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
@Getter
public class Address {
	private String city;
	private String street;
	private String zipcode;

	protected Address() { // JPA 스펙상 필요하여 공백 생성자를 정의, protected로 설정하여 외부에서 만드는것 막습니다.
	}

	public Address(String city, String street, String zipcode) {
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
}
