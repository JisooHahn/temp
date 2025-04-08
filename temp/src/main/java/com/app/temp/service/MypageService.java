package com.app.temp.service;

import com.app.temp.controller.exception.MypageSelectExcpetion;
import com.app.temp.domain.dto.MypageDTO;
import com.app.temp.domain.vo.MemberVO;
import com.app.temp.mapper.ApplyMapper;
import com.app.temp.mapper.MemberMapper;
import com.app.temp.mapper.ScrapMapper;
import com.app.temp.repository.MemberDAO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MypageService {
    private final MemberDAO memberDAO;
    private final MemberMapper memberMapper;
    private final ApplyMapper applyMapper;
    private HttpSession session;
    private final ScrapMapper scrapMapper;

//     마이페이지 회원 정보 조회
    public Optional<MemberVO> accountInfoSelect(Long id) {
        return memberDAO.findById(id);
    }
//     마이페이지 회원정보 수정
    public void accountInfoUpdate(MemberVO memberVO) {
//     DB 업데이트
        memberDAO.setMember(memberVO);
//     업데이트 된 정보 찾기
        Optional<MemberVO> foundMember = memberDAO.findById(memberVO.getId());
        log.info(foundMember.toString());
        session.setAttribute("member", foundMember.orElseThrow(() ->  new MypageSelectExcpetion("")));
    }
//    마이페이지 스크랩 리스트 조회
            public List<MypageDTO> mypageDTOList(Long id, HttpSession session) {
                 MemberVO member = (MemberVO) session.getAttribute("member");
                List<MypageDTO> newList = scrapMapper.selectMemberScrabByMemberId(member.getId());
                newList.forEach(mypageDTO -> {if(mypageDTO.getDDay().equals("0") || mypageDTO.getDDay().contains("-")) {
                    mypageDTO.setDDay("day");
                }
                });
                return newList;
    }
}
