package com.prashanthIt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "SB_CATEGORY_DTLS_TBL")
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	/*@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<BookDetails> bookDetails = new ArrayList<>();*/
}
