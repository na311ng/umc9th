package com.example.umc9th.domain.member.dto.req;

import lombok.Getter;

import java.util.List;

@Getter
public class MemberReqDTO {
    private String name;
    private String gender;
    private String birthday;
    private String address;
    private String detailAddress;
    private List<String> userFood;
}
