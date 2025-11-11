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
    public static class MissionHomeResDTO{
        private Long missionId;
        private String locationName;
        private String storeName;
        private String conditional;
        private Integer point;
        private LocalDate duration;
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
