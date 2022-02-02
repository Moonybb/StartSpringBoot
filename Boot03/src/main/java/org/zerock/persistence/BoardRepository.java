package org.zerock.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

	public List<Board> findBoardByTitle(String title);
	
	public Collection<Board> findByWriter(String writer);
	
	// 작성자에 대한 like % 키워드 %
	public Collection<Board> findByWriterContaining(String writer);
}
