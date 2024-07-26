package com.example.back.interfaces;

import com.example.back.entity.englishWord.word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface englishWordRepository extends JpaRepository<word,String> {

    @Query(value = "select * from english_words",nativeQuery = true)
    List<word> getByPage(Pageable pageable);

    //lowBorder是下界，upBorder是上界，如果要求等于某个值，则上下界一致
    @Query(value = "select * from english_words where if(?1 !='' ,name like %?1%,1=1) and if(?2 !='' ,translation like %?2%,1=1) and if(?4>0,count>=?3 and count<=?4,1=1)",nativeQuery = true)
    List<word> getWordBySelect(String name,String translation,int lowBorder,int upBorder,Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO english_words(name,count,translation) VALUES (?1,?2,?3)",nativeQuery = true)
    void insertWords(String name,int count,String translation);

    @Transactional
    @Modifying
    @Query(value = "UPDATE english_words SET count=?2,translation=?3 WHERE name = ?1",nativeQuery = true)
    int updateWords(String name,int count,String translation);
}
