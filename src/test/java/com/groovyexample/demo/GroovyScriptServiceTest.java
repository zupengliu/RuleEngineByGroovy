package com.groovyexample.demo;

import com.groovyexample.DemoApplication;
import com.groovyexample.groovy.bean.ContextVo;
import com.groovyexample.groovy.service.EngineGroovyModuleRule;
import com.groovyexample.groovy.service.impl.GroovyScriptServiceImpl;
import com.groovyexample.groovy.service.impl.RuleEngineGroovyModuleRuleExecutor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class GroovyScriptServiceTest {
    @Autowired(required = false)
    private GroovyScriptServiceImpl groovyScriptService;
    @Autowired
    private RuleEngineGroovyModuleRuleExecutor ruleEngineGroovyModuleRuleExecutor;

    @Test
    public void initGroovy(){

        String StrategyLogicUnit = "println(context.amount)\n" +
                "if(context.amount>=20000){\n" +
                "            context.nextScenario='A'\n" +
                "            println('Next Scenario is'+context.nextScenario)\n" +
                "            return true\n" +
                "        }\n" +
                "        else{return false}";
        boolean b = groovyScriptService.scriptTest(StrategyLogicUnit);
        EngineGroovyModuleRule enginescript_1267092278 = ruleEngineGroovyModuleRuleExecutor.getInstance("enginescript_34666177");
        //groovy语言 实体类
        ContextVo contextVo =new ContextVo();
        contextVo.setAmount(10000L);
        Boolean run = enginescript_1267092278.run(contextVo, null);
        log.info("b={}",run);
    }
}
