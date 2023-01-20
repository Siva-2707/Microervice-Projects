package com.siva.employee.model.Family;

import com.siva.employee.model.Contact;
import com.siva.employee.model.Enum.Gender;
import com.siva.employee.model.Enum.Relationship;

import lombok.Data;

@Data
public class Member {

    private Relationship relationship;
    private String name;
    private Gender gender;
    private Contact contact;
    private String qualification;
    private String currentCompany;

    public Member(Relationship relationship, String name, Gender gender, Contact contact, String qualification,
            String currentCompany) {
        this.relationship = relationship;
        this.name = name;
        this.gender = gender;
        this.contact = contact;
        this.qualification = qualification;
        this.currentCompany = currentCompany;
    }

}
