package com.thornchg.rkt.entity.vo;

import lombok.Data;

@Data
public class ChoiceVo {
    private Integer index;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String key;
    private String answer;
    private Integer result;
}
