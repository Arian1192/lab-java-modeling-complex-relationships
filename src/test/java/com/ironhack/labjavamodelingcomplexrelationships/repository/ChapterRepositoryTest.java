package com.ironhack.labjavamodelingcomplexrelationships.repository;

import com.ironhack.labjavamodelingcomplexrelationships.enums.MemberStatus;
import com.ironhack.labjavamodelingcomplexrelationships.model.Association;
import com.ironhack.labjavamodelingcomplexrelationships.model.Chapter;
import com.ironhack.labjavamodelingcomplexrelationships.model.Member;
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
        Chapter chapter = new Chapter(1L, "nameChapter", "District-9", null, memberSet, association);
        chapterRepository.save(chapter);
        Member member1 = new Member(1L, "Pedro", MemberStatus.ACTIVE, new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), chapter);
        Member member2 = new Member(2L, "Pedro", MemberStatus.ACTIVE, new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), chapter);
        Member member3 = new Member(3L, "Maria", MemberStatus.ACTIVE, new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), chapter);
        memberSet.add(member1);
        memberSet.add(member2);
        memberSet.add(member3);
        memberRepository.saveAll(memberSet);

    }

    @AfterEach
    void tearDown() {
        chapterRepository.deleteAll();
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("Should return 2 for Pedro encounters")
    void findAllPeopleByName() {
        int maybeMemberCount = chapterRepository.getCountAllMembersCalledLike("Pedro");
        assertEquals(2, maybeMemberCount);
    }

    @Test
    @DisplayName("Should return 0 for Lapsed encounters")
    void findAllLapsedStatusOnaChapter() {
        int maybeMemberCount = chapterRepository.getCountAllMembersThatHaveLapsedStatus();
        assertEquals(0, maybeMemberCount);
    }
}
