package com.example.demo.model;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer memberId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "gender_id")
    private String genderId;

    @Column(name = "date")
    private Date birthday;

    @Column(name = "blood_type_id")
    private String bloodTypeId;

    public Integer getId() {
		// TODO 自動生成されたメソッド・スタブ
		return memberId;
	}
    public void setId(Integer id) {
 
		
	}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
 
		
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {

		
	}

	public String getGenderId() {
		return genderId;
	}

	public void setGenderId(String genderId) {

		
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {

		
	}

	public String getBloodTypeId() {
		return bloodTypeId;
	}

	public void setBloodTypeId(String bloodTypeId) {

		
	}

	

}
