package com.example.umc9th.domain.mission.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class MissionResDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MissionHomeResDTO {
        private Long missionId;      // m.id
        private String locationName; // l.name
        private String storeName;    // s.name
        private String missionName;  // m.missionName
        private String conditional;  // m.conditional
        private Integer point;       // m.point
        private LocalDate startDate; // m.startDate
        private LocalDate endDate;   // m.endDate
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MissionPageResDTO{
        private List<MissionHomeResDTO> missions;
        private int currentPage;
        private int totalPages;
        private long totalElements;

        public static MissionPageResDTO fromPage(Page<MissionHomeResDTO> page) {
            return MissionPageResDTO.builder()
                    .missions(page.getContent())
                    .currentPage(page.getNumber())
                    .totalPages(page.getTotalPages())
                    .totalElements(page.getTotalElements())
                    .build();
        }
    }
}
