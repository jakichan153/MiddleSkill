package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MemberUpdateRequest extends MemberRequest implements Serializable {

  /**
   * ユーザーID
   */
	@NotNull(message = "IDを入力してください")
  private Integer id;
}