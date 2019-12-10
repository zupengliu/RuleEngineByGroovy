package com.groovyexample.contorller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 动态加载规则
 */
@RestController
@RequestMapping("/engine")
@Slf4j
public class DymicLoadRuleController {
    @Autowired
    private com.groovyexample.groovy.service.impl.RuleEngineGroovyModuleRuleExecutor ruleEngineGroovyModuleRuleExecutor;

    @GetMapping("/load")
    public String dymicLoad(){
        String scriptText = "println(context.amount)\n" +
                "if(context.amount>=30000){\n" +
                "            context.nextScenario='A'\n" +
                "            println('Next Scenario is'+context.nextScenario)\n" +
                "            return true\n" +
                "        }\n" +
                "        else{return false}";
        try {
            String className = "enginescript_" + Math.abs(scriptText.hashCode());
            ruleEngineGroovyModuleRuleExecutor.praseAndCache(className,scriptText);
            return className;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @GetMapping("/calcRule")
    public boolean calcRule(String className, long amt){
        com.groovyexample.groovy.service.EngineGroovyModuleRule enginescript_1267092278 =
                ruleEngineGroovyModuleRuleExecutor.getInstance(className);
        //groovy语言 实体类
        com.groovyexample.groovy.bean.ContextVo contextVo =new com.groovyexample.groovy.bean.ContextVo();
        contextVo.setAmount(amt);
        Boolean run = enginescript_1267092278.run(contextVo, null);
        log.info("b={}",run);
        return run;
    }
}
