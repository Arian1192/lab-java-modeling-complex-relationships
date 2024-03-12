package com.ironhack.labjavamodelingcomplexrelationships.repository;

import com.ironhack.labjavamodelingcomplexrelationships.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    @Query("SELECT COUNT(m) FROM Chapter c JOIN c.members m WHERE m.name = :memberName")
    int getCountAllMembersCalledLike(@Param("memberName") String memberName);

    @Query("SELECT COUNT(m) FROM Chapter c Join c.members m WHERE m.status = LAPSED")
    int getCountAllMembersThatHaveLapsedStatus();
}
