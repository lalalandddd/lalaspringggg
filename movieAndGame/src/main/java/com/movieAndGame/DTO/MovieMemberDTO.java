package com.movieAndGame.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MovieMemberDTO {
	private int movieMemberId;
	@NotEmpty(message="아이디는 필수 기재 사항입니다.")
	private String memberId;
	@Size(min=6, max=15, message="비밀번호는 6~15자리로 입력하세요.")
	@Pattern(regexp="^[a-zA-Z0-9]*$",message="비밀번호는 영어와 숫자만 사용 가능합니다.")
	private String password;
	@NotEmpty(message="이름은 필수 기재 사항입니다.")
	private String name;
	private String nick;
	@NotEmpty(message="이메일은 필수 기재 사항입니다.")
	@Email(message="이메일이 잘못되었습니다.")
	private String email;
	@NotEmpty(message="연락처는 필수 기재 사항입니다.")
	private String tel;
	private int birthYear;
	private int birthMonth;
}

/*
@Valid 데이터 유효성 검증 종류
 - @Min : 최소값 확인 (숫자형 변수에 사용) 지정한 최소값보다 작으면 메시지 출력
   > @Min(value=6, message="6 이상만 입력하세요")
 - @Max : 최대값 확인 (숫자형 변수에 사용) 지정한 최대값보다 크면 메시지 출력
   > @Max(value=15, message="15 이하만 입력하세요")
 - @Size : 자릿수 확인 (문자열, 컬렉션, 배열 등에 사용) min과 max 속성으로 범위를 지정 (범위를 벗어나면 메시지 출력)
   > @Size(min=6, max=15, message="비밀번호는 6~15자리로 입력하세요")
 - @Null : null값만 허용
 - @NotNull : 해당 필드가 null 값이 아니어야 함=반드시 값을 가져야 함
   > @NotNull(message="필수 기재 사항입니다.")
 - @NotEmpty : 해당 필드가 빈 문자열이나 null 값이 아니어야 함 (문자열, 컬렉션 등에 사용) 길이가 0이면 메시지 출력
   > @NotEmpty(message="아이디를 입력하세요")
 - @NotBlank : 빈 문자열이나 공백만 포함하는 문자열이 아니어야 함 (문자열에 사용) 공백만 있어도 메시지 출력
   > @NotBlank(message="내용을 입력하세요")
 - @Pattern : 정규 표현식에 맞는지 확인 (문자열에 사용) regexp 속성에 정규 표현식을 지정 (일치하지 않으면 메시지 출력)
   > @Pattern(regexp="^[a-zA-Z0-9]*$",message="비밀번호는 소문자,대문자,숫자만 사용 가능합니다.")
 - @Email : 유효한 이메일 형식인지 확인 (문자열에 사용) 이메일 형식에 맞지 않으면 메시지 출력, 공백이면 패스
   > @Email(message="이메일이 잘못되었습니다.")
 - @Positive : 양수값만 허용
 - @Negative : 음수값만 허용
 - @PositiveOrZero : 양수와 0만 허용
 - @NegativeOrZero : 음수와 0만 허용
 - @Past : 과거의 날짜인지 확인 (날짜 타입에 사용) 현재 시점보다 미래이면 메시지 출력
   > 
 - @Future : 미래의 날짜인지 확인 (날짜 타입에 사용) 현재 시점보다 과거이면 메시지 출력
   > 
*/
