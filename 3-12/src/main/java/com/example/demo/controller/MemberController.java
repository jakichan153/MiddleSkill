package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.MemberRequest;
import com.example.demo.dto.MemberUpdateRequest;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;


@Controller
public class MemberController {

  @Autowired
  private MemberService memberService;
  
  private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
  
  @ModelAttribute("bloodTypes")
  public Map<Integer, String> bloodTypes() {
      return BloodType.getBloodTypeId();
  }
  
  public class BloodType {

	    public static Map<Integer, String> getBloodTypeId() {
	        Map<Integer, String> bloodTypeId = new HashMap<>();
	        bloodTypeId.put(1, "A型");
	        bloodTypeId.put(2, "B型");
	        bloodTypeId.put(3, "O型");
	        bloodTypeId.put(4, "AB型");
	        return bloodTypeId;
	    }

  }		
  @GetMapping(value = "/member/list")
  public String displayList(Model model) {
    List<Member> memberlist = memberService.searchAll();
    model.addAttribute("memberlist", memberlist);
    return "member/list";
  }

  
  @GetMapping(value = "/member/add")
  public String displayAdd(Model model) {
	  model.addAttribute("memberRequest", new MemberRequest());
    return "member/add";
  }
  
  
  @RequestMapping(value = "/member/create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute MemberRequest memberRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      // 入力チェックエラーの場合
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "member/add";
    }
 // ユーザー情報の登録
    try {
        memberService.createMember(memberRequest);
    } catch (Exception e) {
        // 正しい値が取得できなかった際にログを出力
        logger.error("ユーザー情報の登録に失敗しました。", e);
        return "error"; // エラーページにリダイレクトなど
    }
    // 登録後にメンバーリストを再取得して表示する
    List<Member> memberlist = memberService.searchAll();
    model.addAttribute("memberlist", memberlist);
    
    return "member/list";
  }
  
  
  @GetMapping("/member/{id}/edit")
  public String displayEdit(@PathVariable Integer id, Model model) {
    Member member = memberService.findById(id);
    MemberUpdateRequest memberUpdateRequest = new MemberUpdateRequest();
    memberUpdateRequest.setId(member.getId());
    memberUpdateRequest.setName(member.getName());
    memberUpdateRequest.setAge(member.getAge());
    memberUpdateRequest.setGenderId(member.getGenderId());
    memberUpdateRequest.setDate(member.getDate());
    memberUpdateRequest.setBloodTypeId(member.getBloodTypeId());
    model.addAttribute("memberUpdateRequest", memberUpdateRequest);
    return "member/edit";
  }
 
  @PostMapping("/member/update")
  public String update(@Validated @ModelAttribute MemberUpdateRequest memberUpdateRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
          // 入力チェックエラーの場合
          List<String> errorList = new ArrayList<String>();
          for (ObjectError error : result.getAllErrors()) {
              errorList.add(error.getDefaultMessage());
          }
          model.addAttribute("validationError", errorList);
          return "member/edit";
      }
      try {
          // ユーザー情報の更新
          memberService.update(memberUpdateRequest);
      } catch (Exception e) {
          logger.error("ユーザー情報の更新に失敗しました。", e);
          model.addAttribute("updateError", "ユーザー情報の更新に失敗しました。");
          return "member/edit";
      }
      // 更新後にメンバーリストを再取得して表示する
      List<Member> memberlist = memberService.searchAll();
      model.addAttribute("memberlist", memberlist);
      // リダイレクトして画面遷移
      return "redirect:/member/list";
  }

  
  
  @GetMapping("/member/{id}/delete")
  public String delete(@PathVariable Integer id, Model model) {
    // ユーザー情報の削除
    memberService.delete(id);
    return "redirect:/member/list";
  }
  
}