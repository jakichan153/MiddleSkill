package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.MemberUpdate;
import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

    @Autowired
    MemberRepository memberRepository;
    
    public Member findById(Integer id) {
		
    	return memberRepository.findById(id).orElse(null);
	}


    public Member createMember(MemberDto memberDto) {
    	Member member = new Member();
    	member.setName(memberDto.getName());
    	member.setAge(memberDto.getAge());
    	member.setGenderId(memberDto.getGenderId());
        member.setBirthday(memberDto.getBirthday());
        member.setBloodTypeId(memberDto.getBloodTypeId());
        return memberRepository.save(member);
    }

    public Member updateMember(MemberUpdate memberUpdate) {
    	Member member = findById(memberUpdate.getId());
    	member.setName(memberUpdate.getName());
    	member.setAge(memberUpdate.getAge());
    	member.setGenderId(memberUpdate.getGenderId());
        member.setBirthday(memberUpdate.getBirthday());
        member.setBloodTypeId(memberUpdate.getBloodTypeId());
        return memberRepository.save(member);
    }
   

	public void delete(Integer id) {
    	Member member = findById(id);
		 memberRepository.delete(member);
	    }

}