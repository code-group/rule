import com.leFinance.creditLoan.bizRule.dto.RuleReqDto;
import com.leFinance.creditLoan.bizRule.interfaces.impl.RuleInterfaceImpl;
import com.leFinance.creditLoan.bizRule.web.config.drools.DroolsConfig;
import data.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhulili1
 * @date: 2017/10/11
 * @description:
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = com.leFinance.creditLoan.bizRule.web.Application.class)
public class RuleRequestTest {

    @Autowired
    private RuleInterfaceImpl ruleInterfaceImpl;

    @Test
    public void testContractBizRule(){
        RuleReqDto ruleReqDto = new RuleReqDto();
        ruleReqDto.setGroupId("fm.leFinance.creditLoan");
        ruleReqDto.setArtifactId("contract");
        ruleReqDto.setVersion("1.0.1");
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("feeValue", new BigDecimal(1));
        dataMap.put("something", "haha");
        ruleReqDto.setDataMap(dataMap);
        try{
            Message<Map<String, Object>> message = ruleInterfaceImpl.callRule(ruleReqDto);
            log.info("{}", message.getData());

        } catch(Exception e){
            log.error("{}", e.getMessage(), e);

        }
    }

}