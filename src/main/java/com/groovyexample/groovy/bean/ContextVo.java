package com.groovyexample.groovy.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContextVo implements Serializable {

    private Long amount;

    private String nextScenario;
}
