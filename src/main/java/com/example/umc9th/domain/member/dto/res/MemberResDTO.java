package com.example.umc9th.domain.member.dto.res;

import com.example.umc9th.domain.member.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MemberResDTO {
    private String name;
    private String gender;
    private String birthday;
    private String address;
    private String detailAddress;
    private List<String> userFood;
}
