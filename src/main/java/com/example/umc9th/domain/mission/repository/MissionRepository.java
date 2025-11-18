package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entitiy.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    @Query("""
        select new com.example.umc9th.domain.mission.dto.res.MissionResDTO.MissionHomeResDTO(
            m.id,
            l.name,
            s.name,
            m.missionName,
            m.conditional,
            m.point,
            m.startDate,
            m.endDate
        )
        from Mission m
        join m.store s
        join s.location l 
        where l.id = :locationId
        order by m.createdAt desc 
    """)
    Page<MissionResDTO.MissionHomeResDTO> findMissionsByLocationId(
            @Param("locationId") Long locationId,
            Pageable pageable
    );
}
