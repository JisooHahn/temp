document.addEventListener("DOMContentLoaded", function () {
  // DOM 요소 참조 영역
  // ----------------------------------------------------

  // 신고관리 필터 요소 선택
  const companyReportStatusFilter = document.querySelector(".company-report-status-filter"); // 상태 필터 드롭다운
  const programReportStatusFilter = document.querySelector(".program-report-status-filter"); // 상태 필터 드롭다운
  const companyReportDateFilter = document.querySelector(".company-report-date-filter"); // 기간 필터 드롭다운
  const programReportDateFilter = document.querySelector(".program-report-date-filter"); // 기간 필터 드롭다운
  const companyReportSearchInput = document.querySelector(".company-report-search-input"); // 검색어 입력창
  const programReportSearchInput = document.querySelector(".program-report-search-input"); // 검색어 입력창
  const companyReportSearchBtn = document.querySelector(".company-report-search-btn"); // 검색 버튼
  const programReportSearchBtn = document.querySelector(".program-report-search-btn"); // 검색 버튼

  // 필수 DOM 요소 존재 검증
  //   if (
  //     !reportStatusFilter ||
  //     !reportDateFilter ||
  //     !reportSearchInput ||
  //     !reportSearchBtn
  //   ) {
  //     console.error("신고관리 필터 초기화 실패: 필수 DOM 요소 누락");
  //     return;
  //   }

  // 유틸리티 함수 정의 영역
  // ----------------------------------------------------

  // 검색어 유효성 검사 및 검색 실행
  function reportSearch(searchText) {
    // 검색어 입력 여부 확인
    if (!searchText) {
      alert("검색어를 입력해주세요.");
      return;
    }

    // 검색 실행 (추후 서버 연동)
    console.log("신고관리 검색어:", searchText);
  }

  // 필터 초기화 함수
  function initializeFilters() {
    companyReportStatusFilter.value = "all"; // 상태 필터 '전체'로 초기화
    programReportStatusFilter.value = "all"; // 상태 필터 '전체'로 초기화
    companyReportDateFilter.value = "all"; // 기간 필터 '전체'로 초기화
    programReportDateFilter.value = "all"; // 기간 필터 '전체'로 초기화
    companyReportSearchInput.value = ""; // 검색어 입력창 비우기
    programReportSearchInput.value = ""; // 검색어 입력창 비우기
    console.log("신고관리 필터 초기화 완료");
  }

  // 이벤트 리스너 설정 영역
  // ----------------------------------------------------

  // 상태 필터 변경 이벤트
  companyReportStatusFilter.addEventListener("change", function () {
    const selectedStatus = this.value;
    // 선택된 상태값에 따른 한글 상태 매핑
    console.log(
      "신고관리 상태값:",
      selectedStatus === "hold"
        ? "보류"
        : selectedStatus === "pending"
        ? "처리중"
        : selectedStatus === "false"
        ? "허위신고"
        : selectedStatus === "completed"
        ? "처리완료"
        : "전체"
    );
  });

  programReportStatusFilter.addEventListener("change", function () {
    const selectedStatus = this.value;
    // 선택된 상태값에 따른 한글 상태 매핑
    console.log(
        "신고관리 상태값:",
        selectedStatus === "hold"
            ? "보류"
            : selectedStatus === "pending"
                ? "처리중"
                : selectedStatus === "false"
                    ? "허위신고"
                    : selectedStatus === "completed"
                        ? "처리완료"
                        : "전체"
    );
  });

  // 기간 필터 변경 이벤트
  companyReportDateFilter.addEventListener("change", function () {
    const selectedDate = this.value;
    // console.log("신고관리 기간 필터:", selectedDate);
  });
  programReportDateFilter.addEventListener("change", function () {
    const selectedDate = this.value;
    // console.log("신고관리 기간 필터:", selectedDate);
  });

  // 검색 버튼 클릭 이벤트
  companyReportSearchBtn.addEventListener("click", function () {
    const searchText = companyReportSearchInput.value.trim();
    reportSearch(searchText);
  });
  programReportSearchBtn.addEventListener("click", function () {
    const searchText = programReportSearchInput.value.trim();
    reportSearch(searchText);
  });

  // 검색어 입력창 엔터키 이벤트
  companyReportSearchInput.addEventListener("keypress", function (e) {
    if (e.key === "Enter") {
      const searchText = this.value.trim();
      reportSearch(searchText);
    }
  });
  programReportSearchInput.addEventListener("keypress", function (e) {
    if (e.key === "Enter") {
      const searchText = this.value.trim();
      reportSearch(searchText);
    }
  });

  // 초기화 실행
  // ----------------------------------------------------
  initializeFilters(); // 필터 초기 상태 설정
  console.log("신고관리 필터 기능 초기화 완료");
});
