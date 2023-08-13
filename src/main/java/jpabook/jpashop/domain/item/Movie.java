package jpabook.jpashop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;

@Entity
@Getter
@DiscriminatorValue(value = "M")
public class Movie extends Item {
	private String director;
	private String actor;
}
