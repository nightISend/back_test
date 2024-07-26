package com.example.back.controller;

import com.example.back.entity.englishWord.word;
import com.example.back.entity.englishWord.wordRequest;
import com.example.back.entity.englishWord.wordResponse;
import com.example.back.interfaces.englishWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/englishWord")
//注意所有的地址前面都要加/englishWord
public class englishWord {

    @Autowired
    private englishWordRepository EnglishWordRepository;

    @GetMapping("/getAll")
    public wordResponse getAllWords(int pageNumber){
        wordResponse result=new wordResponse();
        //获取总页数
        int total=0;
        while (total>=0){
            Pageable page= PageRequest.of(total, 14);
            List<word> wordList=EnglishWordRepository.getByPage(page);
            if (!wordList.isEmpty()){
                total=total+1;
            }
            else {
                if(total>0){
                    result.setTotalPage(total-1);
                    break;
                }
                else {
                    result.setTotalPage(0);
                    break;
                }
            }
        }
        Pageable page= PageRequest.of(pageNumber, 14);
        List<word> wordList=EnglishWordRepository.getByPage(page);
        result.setSuccess(true);
        result.setCondition("获取所有的数据的第"+pageNumber+"页");
        result.setData(wordList);
        return result;
    }

    @GetMapping("/getBySelect")
    public wordResponse getWordsBySelect(String name,String translation,int lowBorder,int upBorder,int pageNumber){
        wordResponse result=new wordResponse();
//获取总页数
        int total=0;
        while (total>=0){
            Pageable page= PageRequest.of(total, 14);
            List<word> wordList=EnglishWordRepository.getWordBySelect(name,translation,lowBorder,upBorder,page);
            if (!wordList.isEmpty()){
                total=total+1;
            }
            else {
                if(total>0){
                    result.setTotalPage(total-1);
                    break;
                }
                else {
                    result.setTotalPage(0);
                    break;
                }
            }
        }
        Pageable page= PageRequest.of(pageNumber, 14);
        List<word> wordList=EnglishWordRepository.getWordBySelect(name,translation,lowBorder,upBorder,page);
        result.setSuccess(true);
        result.setCondition("获取次数范围数据的第"+pageNumber+"页");
        result.setData(wordList);
        return result;
    }

    @DeleteMapping("/delete")
    public void deleteByName(@RequestBody word[] data){
        for(word row:data){
            EnglishWordRepository.delete(row);
        }
    }

    @PostMapping("/create")
    public void createWord(@RequestBody word[] data){
        for(word row:data){
            EnglishWordRepository.insertWords(row.getName(),row.getCount(),row.getTranslation());
        }
    }

    @PutMapping("/update")
    public void updateWord(@RequestBody word[] data){
        for(word row:data){
            EnglishWordRepository.updateWords(row.getName(),row.getCount(),row.getTranslation());
        }
    }
}
