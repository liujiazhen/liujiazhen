package com.shanshoufu.connector.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * DRAFT_REGIST
 * @author 
 */
@Data
public class DraftRegist implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 电子票据号码
     */
    private String draftNo;

    /**
     * 票据种类-AC01银承;AC02商承
     */
    private String draftType;

    /**
     * 票面金额
     */
    private BigDecimal draftAmount;

    /**
     * 货币-默认CNY
     */
    private String draftCurrencyCode;

    /**
     * 出票日期
     */
    private Date draftIsseDate;

    /**
     * 票据到期日
     */
    private Date draftDueDate;

    /**
     * 不得转让标记-EM00可再转让;EM01不得转让
     */
    private String draftBanendrsmtmk;

    /**
     * 票据状态
     */
    private String draftStatus;

    /**
     * 交易合同号
     */
    private String draftTxlctrctnb;

    /**
     * 承兑人类别
     */
    private String accptrRole;

    /**
     * 承兑人名称
     */
    private String accptrName;

    /**
     * 承兑人组织机构代码
     */
    private String accptrCmonid;

    /**
     * 承兑人账户账号
     */
    private String accptrAcctId;

    /**
     * 承兑人账户开户行行号
     */
    private String accptrAcctSvcr;

    /**
     * 承兑人账户开户行名称
     */
    private String accptrAcctSvcrName;

    /**
     * 承兑人承接行行号
     */
    private String accptrAgcyAcctSvcr;

    /**
     * 承兑人承接行名称
     */
    private String accptrAgcyAcctSvcrName;

    /**
     * 承兑人信用等级
     */
    private String accptrCdtratgs;

    /**
     * 承兑人评级机构
     */
    private String accptrCdtratgAgcy;

    /**
     * 承兑人评级到期日
     */
    private Date accptrCdtratgDuedate;

    /**
     * 出票人类别-RC00接入行
RC01企业
RC02人民银行
RC03被代理行
RC04被代理财务公司
RC05接入财务公司
     */
    private String drwrRole;

    /**
     * 出票人名称
     */
    private String drwrName;

    /**
     * 出票人组织机构代码
     */
    private String drwrCmonid;

    /**
     * 出票人账户账号
     */
    private String drwrAcctId;

    /**
     * 出票人账户开户行行号
     */
    private String drwrAcctSvcr;

    /**
     * 出票人账户开户行名称
     */
    private String drwrAcctSvcrName;

    /**
     * 出票人承接行行号
     */
    private String drwrAgcyAcctSvcr;

    /**
     * 出票人承接行名称
     */
    private String drwrAgcyAcctSvcrName;

    /**
     * 出票人信用等级
     */
    private String drwrCdtratgs;

    /**
     * 出票人评级机构
     */
    private String drwrCdtratgAgcy;

    /**
     * 出票人评级到期日
     */
    private Date drwrCdtratgDuedate;

    /**
     * 收款人类别-RC00接入行
RC01企业
RC02人民银行
RC03被代理行
RC04被代理财务公司
RC05接入财务公司
     */
    private String payeeRole;

    /**
     * 收款人名称
     */
    private String payeeName;

    /**
     * 收款人组织机构代码
     */
    private String payeeCmonid;

    /**
     * 收款人账户账号
     */
    private String payeeAcctId;

    /**
     * 收款人账户开户行行号
     */
    private String payeeAcctSvcr;

    /**
     * 收款人账户开户行名称
     */
    private String payeeAcctSvcrName;

    /**
     * 收款人承接行行号
     */
    private String payeeAgcyAcctSvcr;

    /**
     * 收款人承接行名称
     */
    private String payeeAgcyAcctSvcrName;

    /**
     * 流水号
     */
    private String busiNo;

    /**
     * 业务类型
     */
    private String busiType;

    /**
     * 业务状态
     */
    private String busiStatus;

    /**
     * 业务日期
     */
    private Date busiDate;

    /**
     * 业务时间
     */
    private Date busiTime;

    /**
     * 业务处理信息
     */
    private String busiMsg;

    /**
     * 业务备注
     */
    private String busiRemark;

    /**
     * 创建时间
     */
    private Date busiCreateTime;

    /**
     * 创建日期
     */
    private Date busiCreateDate;

    /**
     * 创建机构名称
     */
    private String busiCreateOname;

    /**
     * 创建机构id
     */
    private String busiCreateOid;

    /**
     * 创建用户名称
     */
    private String busiCreateUname;

    /**
     * 创建用户id
     */
    private String busiCreateUid;

    /**
     * 平台服务类型-provider-服务方，consumer-消费方
     */
    private String servicetype;

    /**
     * 交易渠道-股份资金系统，票据系统
     */
    private String channel;

    /**
     * 创建时间
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;
}