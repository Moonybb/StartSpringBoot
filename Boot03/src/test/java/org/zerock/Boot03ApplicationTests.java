package org.zerock;


import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Board;
import org.zerock.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class Boot03ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private BoardRepository repo;
	
	@Test
	public void testInsert200() {
		
		for(int i=1; i<=200; i++) {
			
			Board board = new Board();
			board.setTitle("제목.." +i);
			board.setContent("내용...." + i + " 채우기");
			board.setWriter("user0" + (i%10));
			repo.save(board);
		}
	}

	@Test
	public void testByTitle() {
		
		/* before Java 8 */
//		List<Board> list = repo.findBoardByTitle("제목..177");
//		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		
		/* Java 8 */
		repo.findBoardByTitle("제목..177")
		.forEach(board -> System.out.println(board));
		
	}
	
	@Test
	public void testByWriter() {
		
		Collection<Board> results = repo.findByWriter("user00");
		
		results.forEach(
			board -> System.out.println(board)
		);
	}
	
	@Test
	public void testByWriterContaining() {
		
		Collection<Board> results = repo.findByWriterContaining("05");
		
		results.forEach(board -> System.out.println(board));
	}
	
	@Test
	public void testByTitleAndBno() {
		
		Collection<Board> results = repo.findByTitleContainingAndBnoGreaterThan("5", 50L);
		
		results.forEach(board -> System.out.println(board));
	}
	
	@Test
	public void testBnOrderBy() {
		Collection<Board> results = 
				repo.findByBnoGreaterThanOrderByBnoDesc(90L);
		
		results.forEach(board -> System.out.println(board));
	}
	
	@Test
	public void testBnoOrderByPaging() {
		
		/*-------------------------------------------------------------
		 * Pageable 인터페이스에는 여러 메소드가 존재하기 때문에 이를 구현하는 대신에 
		 * PageReqeust 클래스를 이용하는 것이 편리합니다. PageReqeust는 데이터의 수를 지정하는 방식입니다.
		 * 
		 * Pageable paging = PageRequest.of(0, 10);
		 * -> 0(첫번째 페이지) 이고 10건의 데이터를 가져오도록 설정
		 *------------------------------------------------------------- */
		
		Pageable paging = PageRequest.of(0, 10);
		
		Collection<Board> results = repo.findByBnoGreaterThanOrderByBnoDesc(0L, paging);
		
		results.forEach(board -> System.out.println(board));
	}
	
	@Test
	public void testBnoPagingSort() {
		
		Pageable paging = PageRequest.of(0, 10, Sort.Direction.ASC, "bno");
		
		Collection<Board> results = repo.findByBnoGreaterThan(0L, paging);
		results.forEach(board -> System.out.println(board));
	}
}
