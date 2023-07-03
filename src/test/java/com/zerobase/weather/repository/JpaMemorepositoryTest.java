package com.zerobase.weather.repository;

import com.zerobase.weather.domain.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaMemorepositoryTest {
    @Autowired
    JpaMemorepository jpaMemorepository;

    @Test
    void insertMemoTest() {
        //given
        Memo newMemo = new Memo(10, "this is jpa memo");
        //when
        jpaMemorepository.save(newMemo);
        //then
        List<Memo> memoList = jpaMemorepository.findAll();
        assertTrue(memoList.size() > 0);
    }
    
    @Test
    void findByIdTest() {
        //given
        Memo newmemo = new Memo(11, "jpa");
        //when
        Memo memo = jpaMemorepository.save(newmemo);
        //then
        Optional<Memo> result = jpaMemorepository.findById(memo.getId());
        assertEquals(result.get().getText(), "jpa");
    }
}