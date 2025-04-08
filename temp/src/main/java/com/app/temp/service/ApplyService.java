package com.app.temp.service;

import com.app.temp.domain.dto.*;
import com.app.temp.domain.vo.AdminVO;
import com.app.temp.domain.vo.MemberVO;
import com.app.temp.repository.AdminDAO;
import com.app.temp.repository.ApplyDAO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ApplyService {
    private final MypageDTO mypageDTO;
    private final ApplyDAO applyDAO;
    private final Pagination pagination;

// 지원하기 버튼
    public void apply(ApplyIDDTO applyIDDTO) {
        applyDAO.set(applyIDDTO);
    }
    //    마이페이지 지원  조회
    public List<ApplicationDTO> selelctApllyById(Long id, Pagination pagination, String applyMemberStatus) {
        pagination.create(applyDAO.findApplicationCount(id));
        return applyDAO.findApplicationById(id, pagination, applyMemberStatus);
    }


//    전체 개수 조회
    public int selectApplicationCount(Long id) {
        return applyDAO.findApplicationCount(id);
    }

//    지원자 현황
    public Optional<ApplyDTO> selectApplicationMemberStatus(Long id) {
        return applyDAO.selectApplicationMemberStatus(id);
    }
}

