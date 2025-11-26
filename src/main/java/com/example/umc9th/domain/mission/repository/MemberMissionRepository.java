package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.res.MemberMissionResponse;
import com.example.umc9th.domain.mission.entitiy.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    @Query("""
select new com.example.umc9th.domain.mission.dto.res.MemberMissionResponse(
    mm.id,
    m.id,
    m.missionName,
    m.conditional,
    m.point,
    m.startDate,
    m.endDate,
    mm.isComplete,
    new com.example.umc9th.domain.mission.dto.res.MemberMissionResDTO.StoreInfo(
        s.id,
        s.name,
        s.bossNumber,
        s.address
    )
)
from MemberMission mm
join mm.mission m
join m.store s
where mm.member.id = :memberId
and (:status is null or 
    (:status = 'ONGOING' and mm.isComplete = false) or
    (:status = 'COMPLETED' and mm.isComplete = true))
order by m.createdAt desc
""")
    Page<MemberMissionResDTO.MemberMissionInfoDTO> findeMemberMissionByMemeberId(
            @Param("memberId") Long memberId,
            @Param("status") String status,
            Pageable pageable
    );

    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}
