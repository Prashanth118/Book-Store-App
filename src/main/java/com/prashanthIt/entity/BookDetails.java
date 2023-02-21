package com.prashanthIt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "BS_BOOK_DTLS_TBL")
public class BookDetails {

	@Id
	@GeneratedValue
	@Column(name = "BOOK_ID")
	private Integer bookId;
	@Column(name = "BOOK_NAME")
	private String bookName;
	@Column(name = "BOOK_AUTHOR")
	private String author;
	@Column(name = "BOOK_DESCRIPTION")
	private String bookDescription;
	@Column(name = "BOOK_IMAGE")
	private String bookImage;
	@Column(name = "BOOK_ISBN")
	private String bookIsbn;
	@Column(name = "BOOK_PRICE")
	private Double bookPrice;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "BOOK_PUBLISHED_DATE")
	private Date publishedDate;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private Category category;
}
