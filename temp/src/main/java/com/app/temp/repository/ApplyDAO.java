package com.app.temp.repository;

import com.app.temp.domain.dto.ApplicationDTO;
import com.app.temp.domain.dto.ApplyDTO;
import com.app.temp.domain.dto.ApplyIDDTO;
import com.app.temp.domain.dto.Pagination;
import com.app.temp.mapper.ApplyMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Slf4j
@Repository
@RequiredArgsConstructor
public class ApplyDAO {
    private final ApplyMapper applyMapper;

//    마이페이지 지원 조회
    public List<ApplicationDTO> findApplicationById(Long id, Pagination pagination, String applyMemberStatus) {
        log.info(applyMapper.selectApplicationById(id, pagination, applyMemberStatus).toString());

        log.info(applyMemberStatus.toString());
        return applyMapper.selectApplicationById(id, pagination, applyMemberStatus);
    }
//    마이페이지 지원 조회(total)
    public int findApplicationCount(Long id) {
        return applyMapper.selectApplicationCount(id);
    }

//    마이페이지 지원자 상태
    public Optional<ApplyDTO> selectApplicationMemberStatus(Long id) {
        return applyMapper.selectApplicationMemberStatus(id);
    }
    // 지원 현황 추가
    public void set(ApplyIDDTO applyIDDTO) {
        applyMapper.insert(applyIDDTO);
    }
}
