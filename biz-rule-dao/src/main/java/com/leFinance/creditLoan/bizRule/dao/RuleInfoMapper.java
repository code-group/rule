package com.leFinance.creditLoan.bizRule.dao;

import com.leFinance.creditLoan.bizRule.bo.RuleVersionBo;
import com.leFinance.creditLoan.bizRule.domain.RuleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RuleInfoMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(RuleInfo record);

    int insertSelective(RuleInfo record);

    RuleInfo selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(RuleInfo record);

    int updateByPrimaryKey(RuleInfo record);

    /**
     * created by zhulili1, on 2017/10/16
     * @Description: 查询drl文件路径，drl的目标路径
     **/
    List<RuleInfo> listSelectResourceByRuleVersion(RuleVersionBo item);

    /**
     * created by zhulili1, on 2017/10/16
     * @Description: 查询kieModule文件路径，containerName
     **/
    RuleInfo selectRuleInfoByRuleVersion(RuleVersionBo ruleVersionBo);

    /**
     * created by zhulili1, on 2017/10/18
     * @Description: 查询规则信息
     **/
    List<RuleInfo> listSelectRuleInfoByRuleVersion(RuleVersionBo ruleVersionBo);

    /**
     * created by zhulili1, on 2017/10/18
     * @Description: 批量插入规则信息
     **/
    void batchInsert(List<RuleInfo> ruleInfoList);
}