package org.zerock.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/* @Entity - 해당 클래스가 엔티티 클래스임을 명시 */

/* @Table을 설정하는 경우에는 기본적으로 데이터베이스의 클래스명과 동일한 이름으로 생성된다. */
// 만일 클래스명과 다른 이름으로 테이블 이름을 지정하고 싶을 때에는 @Table의 name속성을 사용한다.

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_boards")
public class Board {
	
	/* @Id 어노테이션 */
	// 식별키PK 라는 것을 의미한다. 모든 엔티티에는 반드시 @Id가 지정되어야 한다.
	// @Id는 주로 @GeneratedValue라는 어노테이션과 같이 이용해 식별키를 어떤 전략으로 생성하는지 명시 한다.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	private String title;
	private String writer;
	private String content;
	
	/* @CreationTimestamp / @UpdateTimestamp */
	// org.hibernat 패키지의 것으로 엔티티가 생성되거나 업데이트 되는 시점의 날짜 데이터를 기록하는 설정
	
	@CreationTimestamp
	private Timestamp regdate;		// LocalDateTime
	@UpdateTimestamp
	private Timestamp updatedate;	// LocalDateTime
}
