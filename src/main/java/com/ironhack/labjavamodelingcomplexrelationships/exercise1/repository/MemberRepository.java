package com.ironhack.labjavamodelingcomplexrelationships.exercise1.repository;

import com.ironhack.labjavamodelingcomplexrelationships.exercise1.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM Member m JOIN m.chapter c WHERE c.name = :chapterName AND m.name = :memberName")
    Optional<Member> isThisMemberInThatChapterReturns(@Param("chapterName") String chapterName, @Param("memberName") String memberName);
}
