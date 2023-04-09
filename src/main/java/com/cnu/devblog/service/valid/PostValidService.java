package com.cnu.devblog.service.valid;

import com.cnu.devblog.entity.Slang;
import com.cnu.devblog.repository.persistence.slang.SlangRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostValidService {

    private final SlangRepository slangRepository;

    public PostValidService(SlangRepository slangRepository) {
        this.slangRepository = slangRepository;
    }

    public boolean isValidPost(List<String> slangList, String postContent) {
        List<Boolean> result = new ArrayList<>();
        for (String slang : slangList) {
//            result.add(PatternMatchUtils.simpleMatch(slang, postContent));
            if(postContent.contains(slang)) {
                result.add(true);
            }
        }
        return result.size() > 0;
    }

    public List<String> getSlangList() {
        List<String> result = new ArrayList<>();
        List<Slang> slangs = slangRepository.findAll();
        for (Slang slang: slangs) {
            result.add(slang.getSlang());
        }
        return result;
    }
}
