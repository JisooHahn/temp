package com.app.temp.domain.dto;

import com.app.temp.domain.vo.MemberVO;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MemberDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String memberName;
    private String memberPhone;
    private String memberRecentLogin;
    private String memberEmail;
    private String memberProfilePath;
    private String memberClass;
    private int memberPoint;
    private String memberStatus;
    private String createdDate;
    private String updatedDate;
    private String memberBirth;
    private ArrayList<MemberResumeDTO> resumeList;

    public MemberVO toVO(){
        MemberVO memberVO = new MemberVO();
        memberVO.setId(id);
        memberVO.setMemberName(memberName);
        memberVO.setMemberPhone(memberPhone);
        memberVO.setMemberRecentLogin(memberRecentLogin);
        memberVO.setMemberEmail(memberEmail);
        memberVO.setMemberProfilePath(memberProfilePath);
        memberVO.setMemberClass(memberClass);
        memberVO.setMemberPoint(memberPoint);
        memberVO.setMemberStatus(memberStatus);
        memberVO.setCreatedDate(createdDate);
        memberVO.setUpdatedDate(updatedDate);
        memberVO.setMemberBirth(memberBirth);

        return memberVO;
    }
}
