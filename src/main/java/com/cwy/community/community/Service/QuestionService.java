package com.cwy.community.community.Service;

import com.cwy.community.community.dto.QuestionDTO;
import com.cwy.community.community.mapper.QuesstionMapper;
import com.cwy.community.community.mapper.UserMapper;
import com.cwy.community.community.model.Quess;
import com.cwy.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuesstionMapper qusm;

    @Autowired
    private UserMapper userMapper;
    public List<QuestionDTO> List() {
        List<Quess> list = qusm.List();
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Quess quess:list) {
            User user = userMapper.finByID(quess.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties("quess",questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }
}
