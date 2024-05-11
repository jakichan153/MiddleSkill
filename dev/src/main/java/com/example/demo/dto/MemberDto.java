package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;


@Data
public class MemberDto implements Serializable {

	
	@NotEmpty(message = "名前を入力してください")
	 //実装1行
	  private String name;
	
	@NotEmpty(message = "年齢を入力してください")
	 //実装1行
	  private String age;
	
	@NotEmpty(message = "性別を選択してください")
	 //実装1行
	  private String genderId;
	
	@NotEmpty(message = "誕生日を入力してください")
	 //実装1行
	/**
     * 誕生日
     */
    @NotNull(message = "誕生日を入力してください")
    @Past(message = "誕生日は過去の日付を入力してください")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

	
	@NotEmpty(message = "血液型を選択してください")
	 //実装1行
	  private String bloodTypeId;
}
