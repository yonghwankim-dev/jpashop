package jpabook.jpashop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;

@Entity
@Getter
@DiscriminatorValue(value = "B")
public class Book extends Item {
	private String author;
	private String isbn;
}
