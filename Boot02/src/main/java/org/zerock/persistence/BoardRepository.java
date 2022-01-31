package org.zerock.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	
	/* CrudRepository */
	/* 부모인터페이스인 CrudRepository 인터페이스는 아래와 같은 메서드를 제공한다. */
	
	// log count()									: 모든 엔티티의 개수
	// void delete(ID)								: 식별키를 통한 삭제 
	// void delete(Iterable<? extemds T>)			: 주어진 모든 엔티티 삭제
	// void deleteAll()								: 모든 엔티티 삭제
	// boolean exists(ID)							: 식별키를 가진 엔티티가 존재하는지 확인
	// Iterable<T> findAll()						: 모든 엔티티 목록
	// Iterable<T> findAll(Iterable<ID>)			: 해당 식별키를 가진 엔티티 목록 반환
	// T findOne(ID)								: 해당 식별키에 해당하는 단일 엔티티 반환
	// <S extends T> Iterable<S> save(Iterable<S>)	: 해당 엔티티들의 등록과 수정
	// <S extends T> S save(S entity)				: 해당 엔티티의 등록과 수정
	
	
}
