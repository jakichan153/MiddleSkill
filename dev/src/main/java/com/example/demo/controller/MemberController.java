package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.MemberUpdate;
import com.example.demo.model.Member;
import com.example.demo.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

 
   	@GetMapping("/member/add")
   	public String displayAdd(Model model) {
   		model.addAttribute("memberDto", new MemberDto());
   		return "member/add";
   	}
   	/**
   	 * ユーザー新規登録
   	 * @param  userRequest リクエストデータ
   	 * @param  model Model
   	 * @return  ユーザー情報一覧画面
   	 */
   	@GetMapping("/member/create")
   	public String create(@Validated @ModelAttribute MemberDto memberDto, BindingResult result, Model model) {
   		//入力判定入れること
   		if (result.hasErrors()) {
   		      // 入力チェックエラーの場合３行実装
   		      List<String> errorList = new ArrayList<String>();
   		      for (ObjectError error : result.getAllErrors()) {
   		        errorList.add(error.getDefaultMessage());
   		      }
   		      //エラー判定後の画面遷移２行実装
   		      model.addAttribute("validationError", errorList);
   		      model.addAttribute("memberDto", new MemberDto());
   		      return "member/add";
   		    }
   		    // ユーザー情報の登録２行実装
   		    memberService.createMember(memberDto);
   		    return "redirect:/member/add";
   		  }
   	@GetMapping("/member/{id}/edit")
	  public String displayEdit(@PathVariable  Integer id, Model model) {
		Member member = memberService.findById(id);		    
		MemberUpdate memberUpdate = new MemberUpdate();
	 //実装5行
		memberUpdate.setId(member.getId());
		memberUpdate.setName(member.getName());
		memberUpdate.setAge(member.getAge());
		memberUpdate.setGenderId(member.getGenderId());
		memberUpdate.setBirthday(member.getBirthday());
		memberUpdate.setBloodTypeId(member.getBloodTypeId());
	    model.addAttribute("memberUpdate", memberUpdate);
	    return "member/edit";
	  }
	  /**
	   * ユーザー更新
	   * @param  userRequest リクエストデータ
	   * @param  model Model
	   * @return  ユーザー情報詳細画面
	   */
@RequestMapping("/member/update")
	  public String update(@Validated  @ModelAttribute  MemberUpdate memberUpdate, BindingResult result, Model model) {
	    if (result.hasErrors()){
	      List<String> errorList = new ArrayList<String>();
	    
	      for (ObjectError error : result.getAllErrors()) {
	        errorList.add(error.getDefaultMessage());
	      }
	      model.addAttribute("validationError", errorList);
	      return "member/edit";
	    }
	    // ユーザー情報の更新
	    memberService.updateMember(memberUpdate);
	    return String.format("redirect:/member/%d", memberUpdate.getId());
}
@GetMapping("/member/{id}/delete")
public String delete(@PathVariable Integer id ,Model model) {
	// ユーザー情報の削除実装2行
memberService.delete(id);
return "redirect:/member/add";

}
}