package com.example.umc9th.domain.mission.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;

@Getter
@Builder
@AllArgsConstructor
public class MemberMissionResDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberMissionInfoDTO {
        private Long memberMissionId;
        private Long missionId;
        private String missionName;
        private String conditional;
        private Integer point;
        private LocalDate startDate;
        private LocalDate endDate;
        private boolean isComplete;
        private StoreInfo store;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class StoreInfo {
        private Long storeId;
        private String name;
        private String bossNumber;
        private String address;
    }


    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberMissionPageDTO {
        private List<MemberMissionInfoDTO> missions;
        private PageInfo pageInfo;

        public static MemberMissionPageDTO fromPage(Page<MemberMissionInfoDTO> page) {
            return MemberMissionPageDTO.builder()
                    .missions(page.getContent())
                    .pageInfo(new PageInfo(
                            page.getNumber(),
                            page.getSize(),
                            page.getTotalPages(),
                            page.getTotalElements()
                    ))
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    public static class PageInfo {
        private int page;
        private int size;
        private int totalPages;
        private long totalElements;
    }
}
