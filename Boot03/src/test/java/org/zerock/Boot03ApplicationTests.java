package org.zerock;


import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
	}
}
