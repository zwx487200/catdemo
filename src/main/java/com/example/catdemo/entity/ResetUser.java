package com.example.catdemo.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ResetUser extends User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    FamilyMember familyMemberHouseOwner;
    FamilyMember familyMemberForUpdate;
    String oldPassword;
    String newPassword;
    String confirmPassword;
}
