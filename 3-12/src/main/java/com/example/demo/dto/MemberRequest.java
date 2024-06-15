package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.entity.BloodType;
import com.example.demo.entity.Gender;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class MemberRequest implements Serializable {

	
	@NotEmpty(message = "名前を入力してください")
	 //実装1行
	  private String name;
	
	@NotNull(message = "年齢を入力してください")
	 //実装1行
	  private Integer age;
	
	@NotNull(message = "性別を選択してください")
	 //実装1行
	  private Gender genderId;
	
	@NotEmpty(message = "日付を入力してください")
	
    private String date;

	
	@NotNull(message = "血液型を選択してください")
	 //実装1行
	  private BloodType bloodTypeId;
}


