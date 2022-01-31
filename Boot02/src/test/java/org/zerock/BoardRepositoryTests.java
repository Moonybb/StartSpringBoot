package org.zerock;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Board;
import org.zerock.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void inspect() {
		
		// 실제 객체의 클래스 이름
		Class<?> clz = boardRepo.getClass();
		
		System.out.println(clz.getName()); // com.sun.proxy.$Proxy108
		
		// 클래스가 구현하고 있는 인터페이스 목록
		Class<?>[] interfaces = clz.getInterfaces();
		
		Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));
		
		// 클래스의 부모 클래스
		Class<?> superClasses = clz.getSuperclass();
		
		System.out.println(superClasses.getName());
	}
	
	/**
	 * 등록 작업 테스트 
	 * */
	@Test
	public void testInsert() {
		
		Board board = new Board();
		board.setTitle("게시물의 제목");
		board.setContent("게시물 내용 넣기....");
		board.setWriter("user00");
		
		// title, content, writer 속성값만 지정하는 이유는 
		// Board의 식별 데이터인 bno는 자동 생성 방식을 이용하도록 설정되어 있다.
		
		boardRepo.save(board);
		
		testRead(); // 조회
	}
	
	/**
	 * 조회 작업 테스트 
	 * */
	@Test
	public void testRead() {
		
		boardRepo.findById(1L).ifPresent((board)->{
		System.out.println(board);
		});
	}
	
	@Test
	public void testUpdate() {
		System.out.println("Read First...............");
		Board board = new Board();
		boardRepo.findById(1L).ifPresent((findBoard)->{
			BeanUtils.copyProperties(findBoard, board);
		});
		
		System.out.println("Update Title.............");
		board.setTitle("수정된 제목입니다");
		
		System.out.println("Call Save()..............");
		boardRepo.save(board);
	}
	
	@Test
	public void testDelete() {
		
		System.out.println("Delete Entity");
		
		boardRepo.deleteById(1L); // 식별자로 삭제
	}
}
