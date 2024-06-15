package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.MemberRequest;
import com.example.demo.dto.MemberUpdateRequest;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

/**
 * メンバー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

  /**
   * メンバー情報 Repository
   */
  @Autowired
  private MemberRepository memberRepository;

  /**
   * メンバー情報 全検索
   * @return 検索結果
   */
  public List<Member> searchAll() {
    return memberRepository.findAll();
  }
  
  /**
   * ユーザー情報 主キー検索
   * @return 検索結果
   */
  public Member findById(Integer id) {
    return memberRepository.findById(id).get();
  }

  
  /**
   * メンバー情報 新規登録
   * @param member メンバー情報
   */
  public Member createMember(MemberRequest memberRequest) {
  	Member member = new Member();
  	member.setName(memberRequest.getName());
  	member.setAge(memberRequest.getAge());
  	member.setGenderId(memberRequest.getGenderId());
    member.setDate(memberRequest.getDate());
    member.setBloodTypeId(memberRequest.getBloodTypeId());
      return memberRepository.save(member);
  }
  
  /**
   * ユーザー情報 更新
   * @param user ユーザー情報
   */
  public void update(MemberUpdateRequest memberUpdateRequest) {
    Member member = findById(memberUpdateRequest.getId());
    member.setName(memberUpdateRequest.getName());
    member.setAge(memberUpdateRequest.getAge());
    member.setGenderId(memberUpdateRequest.getGenderId());
    member.setDate(memberUpdateRequest.getDate());
    member.setBloodTypeId(memberUpdateRequest.getBloodTypeId());
    memberRepository.save(member);
  }
  
  /**
   * ユーザー情報 物理削除
   * @param id ユーザーID
   */
  public void delete(Integer id) {
    Member member = findById(id);
    memberRepository.delete(member);
  }
}