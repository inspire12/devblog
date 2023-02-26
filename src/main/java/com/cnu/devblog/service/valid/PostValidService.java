package com.cnu.devblog.service.valid;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostValidService {

    public boolean isValidPost(List<String> slangList, String postContent) {
        List<Boolean> result = new ArrayList<>();
        for (String slang : slangList) {
            if(postContent.contains(slang)) {
                result.add(true);
            }
        }
        return result.size() > 0;
    }

    public List<String> getSlangList() {
        return List.of("비속어", "비속어2");
    }
}
