package com.ironhack.labjavamodelingcomplexrelationships.exercise1.repository;

import com.ironhack.labjavamodelingcomplexrelationships.exercise1.enums.MemberStatus;
import com.ironhack.labjavamodelingcomplexrelationships.exercise1.model.Association;
import com.ironhack.labjavamodelingcomplexrelationships.exercise1.model.Chapter;
import com.ironhack.labjavamodelingcomplexrelationships.exercise1.model.Member;
import com.ironhack.labjavamodelingcomplexrelationships.exercise1.repository.AssociationRepository;
import com.ironhack.labjavamodelingcomplexrelationships.exercise1.repository.ChapterRepository;
import com.ironhack.labjavamodelingcomplexrelationships.exercise1.repository.MemberRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZoneId;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChapterRepositoryTest {

    @Autowired
    private AssociationRepository associationRepository;
    @Autowired
    private ChapterRepository chapterRepository;
    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        Association association = new Association();
        associationRepository.save(association);
        List<Member> memberSet = new ArrayList<>();
        Chapter chapter = new Chapter( "nameChapter", "District-9", null, memberSet, association);
        chapterRepository.save(chapter);
        Member member1 = new Member(   "Pedro", MemberStatus.ACTIVE, new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), chapter);
        Member member2 = new Member(  "Pedro", MemberStatus.ACTIVE, new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), chapter);
        Member member3 = new Member( "Maria", MemberStatus.ACTIVE, new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), chapter); // Cambiado a MemberStatus.LAPSED
        memberSet.add(member1);
        memberSet.add(member2);
        memberSet.add(member3);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

    }

    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
        chapterRepository.deleteAll();
        associationRepository.deleteAll();
    }

    @Test
    @DisplayName("Should return 2 for Pedro encounters")
    void findAllPeopleByName() {
        int maybeMemberCount = chapterRepository.getCountAllMembersCalledLike("Pedro");
        assertEquals(2, maybeMemberCount);
    }

    @Test
    @DisplayName("Should return 0 for Lapsed encounters") // Cambiado a 1
    void findAllLapsedStatusOnaChapter() {
        int maybeMemberCount = chapterRepository.getCountAllMembersThatHaveLapsedStatus();
        assertEquals(0, maybeMemberCount); // Cambiado a 1
    }
}
