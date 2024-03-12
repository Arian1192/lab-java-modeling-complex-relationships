package com.ironhack.labjavamodelingcomplexrelationships.repository;

import com.ironhack.labjavamodelingcomplexrelationships.enums.MemberStatus;
import com.ironhack.labjavamodelingcomplexrelationships.model.Association;
import com.ironhack.labjavamodelingcomplexrelationships.model.Chapter;
import com.ironhack.labjavamodelingcomplexrelationships.model.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {


    @Autowired
    private AssociationRepository associationRepository;
    @Autowired
    private ChapterRepository chapterRepository;
    @Autowired
    private MemberRepository memberRepository;

    private Member  member3;

    @BeforeEach
    void setUp() {
        Association association = new Association();
        associationRepository.save(association);
        Member president = new Member();
        memberRepository.save(president);

        List<Member> listMember = new ArrayList<>();
        Chapter chapter = new Chapter(1L, "Lunara", "Lunara-district", president, listMember, association );
        Member member1 = new Member(1L, "Pedro", MemberStatus.ACTIVE, new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), chapter);
        Member member2 = new Member(2L, "Pedro", MemberStatus.ACTIVE, new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), chapter);
        member3 = new Member(3L, "Maria", MemberStatus.ACTIVE, new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), chapter);
        listMember.add(member1);
        listMember.add(member2);
        listMember.add(member3);
        chapterRepository.save(chapter);
        memberRepository.saveAll(listMember);

    }

    @AfterEach
    void tearDown() {
        chapterRepository.deleteAll();
        associationRepository.deleteAll();
    }

    @Test
    void isInChapterMaria() {
        Optional<Member> maybeFound = memberRepository.isThisMemberInThatChapterReturns("Lunara", "Maria");
        assertTrue(maybeFound.isPresent());
        assertEquals(member3.getName(), maybeFound.get().getName());
    }
}