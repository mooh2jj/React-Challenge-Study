package com.mo.reactchallenge.entity.core;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Comment;

import lombok.Getter;

/**
 * packageName    : com.mo.reactchallenge.entity.core
 * fileName       : BaseEntity
 * author         : Jang Hyun Suk
 * date           : 11/6/23
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 11/6/23       Jang Hyun Suk       최초 생성
 */
@Getter
@MappedSuperclass
public abstract class BaseEntity {

	@Column(updatable = false)
	@Comment("생성일자")
	private LocalDateTime createAt;

	@Column(updatable = false)
	@Comment("수정일자")
	private LocalDateTime updateAt;

	@PrePersist
	protected void onCreate() {
		createAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updateAt = LocalDateTime.now();
	}
}
