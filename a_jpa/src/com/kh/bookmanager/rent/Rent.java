package com.kh.bookmanager.rent;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.kh.bookmanager.member.Member;

import lombok.Data;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class Rent {

	@Id
	@GeneratedValue
	private Long rmIdx;
	
	@ManyToOne //현재 Entity 기준으로 Rent가 M, Member가 1 => M : 1
	@JoinColumn(name = "userId")
	private Member member;
	
	@OneToMany(mappedBy = "rent")
	private List<RentBook> rentBooks;
	
	@Column(columnDefinition = "date default sysdate")
	private Date regDate;
	
	@Column(columnDefinition = "number default 0")
	private Boolean isReturn;
	private String title;
	@Column(columnDefinition = "number default 0")
	private Integer rentBookCnt;
	
}
