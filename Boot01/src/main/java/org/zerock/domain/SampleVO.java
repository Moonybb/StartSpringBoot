package org.zerock.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude={"val3"})
public class SampleVO {
	
	/* @Data */
	// Getter/Setter/ToString/EqualsAndHashCode/RequireArgsConstructor 의 묶음
	// ORM에서 주의해야 함 - 상호호출의 문제
	
	/* @ToString(exclude={"val3"}) */
	// 위 어노테이션에 exclude를 설정하면 toString 출력 시 val3이라는 속성은 제외한다.
	
	private String val1;
	private String val2;
	private String val3;
}
