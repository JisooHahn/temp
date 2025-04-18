package com.app.temp.domain.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NoticeListDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String noticeTitle;
    private String createdDate;
    private String noticeContent;
    private String noticeCategory;
    private String updatedDate;

}
