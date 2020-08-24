package org.liujiazhen.poi.test;

public enum DraftMessageEnum {
    /**
     * 交易渠道
     */
    MESSAGE_CHANNEL_FINANCE("finance", "股份资金系统"),
    MESSAGE_CHANNEL_DRAFT("draft", "票据系统"),

    /**
     * 平台服务类型
     */
    MESSAGE_SERVICETYPE_PROVIDER("provider", "提供方"),
    MESSAGE_SERVICETYPE_CONSUMER("consumer", "消费方"),

    /**
     * 有无错误信息
     */
    MESSAGE_ERRORFLAG_0("0", "无错误信息"),
    MESSAGE_ERRORFLAG_1("1", "有错误信息"),

    /**
     * 报文请求类型
     */
    REQUESTTYPE_SYNC("sync", "同步请求"),
    REQUESTTYPE_ASYNC("async", "异步请求"),
    REQUESTTYPE_RESULTQUERY("resultQuery", "异步请求结果查询"),

    /**
     * 报文内容类型
     */
    MSGTYPE_REGIST("001", "出票信息登记"),
    MSGTYPE_ACCEPT("002", "提示承兑申请报文"),
    MSGTYPE_ISSUANCE("003", "提示收票申请报文"),
    MSGTYPE_DESTRUCTION("004", "撤票申请报文"),
    MSGTYPE_REGIST_CONFIRM("005", "出票信息登记确认报文"),
    MSGTYPE_ENDORSEMENT("010", "转让背书申请报文"),
    MSGTYPE_DISCOUNT("011", "贴现申请报文"),
    MSGTYPE_DISCOUNT_BACK("012", "回购式贴现赎回申请报文"),
    MSGTYPE_DISCOUNT_CIRCULATION("013", "转贴现申请报文"),
    MSGTYPE_DISCOUNT_CIRCULATION_BACK("014", "回购式转贴现赎回申请报文"),
    MSGTYPE_REDISCOUNT("015", "再贴现申请报文"),
    MSGTYPE_REDISCOUNT_CIRCULATION_BACK("016", "回购式再贴现赎回申请报文"),
    MSGTYPE_GUARANTEE("017", "保证申请报文"),
    MSGTYPE_COLLZTN("018", "质押申请报文"),
    MSGTYPE_RPDCOLLZTN("019", "质押解除申请报文"),
    MSGTYPE_PRESENTATION("020", "提示付款申请报文"),
    MSGTYPE_PAY_OVERDUE("021", "逾期提示付款申请报文"),
    MSGTYPE_RECOURSE("022", "追索通知报文"),
    MSGTYPE_RECOURSEAGREEMENT("023", "追索同意清偿申请报文"),
    MSGTYPE_GENERATEBANK("025", "央行卖出商业汇票申请报文"),
    MSGTYPE_GENERATE_REPLY("031", "通用回复报文"),
    MSGTYPE_GENERATE_DESTRUCTION("032", "通用撤销报文"),
    MSGTYPE_GENERATE_CONFIRM("033", "通用确认报文"),
    MSGTYPE_GENERATE_FORWARDING("034", "通用票据转发"),

    /**
     * 交易码
     */
    TRANCODE_DRAFT_REGINFO("3101", "出票登记"),
    TRANCODE_ACCEPT_NOTICE("3102", "提示承兑"),
    TRANCODE_ISSUANCE_NOTICE("3103", "提示收票"),
    TRANCODE_ACCEPT_SIGN("3204", "承兑签收"),
    TRANCODE_ISSUANCE_SIGN("3201", "收票签收"),
    TRANCODE_ENDORSE_APPLY("3001", "背书申请"),
    TRANCODE_ENDORSE_SIGN("3202", "背书签收"),
    TRANCODE_DISCOUNT_APPLY("3002", "贴现申请"),
    TRANCODE_DISCOUNT_SIGN("3205", "贴现签收"),
    TRANCODE_PAYAPPLY_NOTICE("3003", "提示付款申请"),
    TRANCODE_DUEPAY_SIGN("3203", "到期付款签收"),
    TRANCODE_OVERDUEPAY_APPLY("3004", "逾期提示付款申请"),
    TRANCODE_OVERDUEPAY_SIGN("3210", "逾期付款签收"),
    TRANCODE_GUARANTE_APPLY("3106", "保证申请"),
    TRANCODE_GUARANTE_SIGN("3206", "保证签收"),
    TRANCODE_COLLZTN_APPLY("3107", "质押申请"),
    TRANCODE_COLLZTN_SIGN("3207", "质押签收"),
    TRANCODE_RPDCOLLZTN_RELEASE_APPLY("3108", "质押解除申请"),
    TRANCODE_RPDCOLLZTN_RELEASE_SIGN("3208", "质押解除签收"),
    TRANCODE_RECOURSE_APPLY("3109", "追索申请"),
    TRANCODE_RECOURSE_DEAL("3209", "追索处理"),
    TRANCODE_PAYOFF_AGREEMENT_APPLY("3111", "同意清偿申请"),
    TRANCODE_PAYOFF_AGREEMENT_SIGN("3211", "同意清偿签收"),
    TRANCODE_BUSINESS_DRAWBACK("1201", "业务撤销"),
    TRANCODE_DESTRUCTION_APPLY("3104", "撤票申请"),
    TRANCODE_DRAFT_GENERATE_INFO("7071", "票据基本信息查询"),
    TRANCODE_DRAFT_FRONTAGE_INFO("7072", "票据正面信息查询"),
    TRANCODE_DRAFT_BACK_INFO("7073", "票据背面信息查询"),
    TRANCODE_DRAFT_WAIT_SIGN("7074", "待签收票据查询"),
    TRANCODE_ASYNC_RESULT("7075", "异步请求结果查询"),
    TRANCODE_GUARANTE_INFO("7076", "保证信息查询"),
    TRANCODE_LIMIT_INFO("8001", "额度查询"),
    TRANCODE_COREACCOUNT_INFO("7078", "查询核心账户信息"),


    BSNCODE_DRAFT_REGINFO("ECD3101", "出票登记"),
    BSNCODE_ACCEPT_NOTICE("ECD3102", "提示承兑"),
    BSNCODE_ISSUANCE_NOTICE("ECD3103", "提示收票"),
    BSNCODE_ACCEPT_SIGN("ECD3204", "承兑签收"),
    BSNCODE_ISSUANCE_SIGN("ECD3201", "收票签收"),
    BSNCODE_ENDORSE_APPLY("ECD3001", "背书申请"),
    BSNCODE_ENDORSE_SIGN("ECD3202", "背书签收"),
    BSNCODE_DISCOUNT_APPLY("ECD3002", "贴现申请"),
    BSNCODE_DISCOUNT_SIGN("ECD3205", "贴现签收"),
    BSNCODE_PAYAPPLY_NOTICE("ECD3003", "提示付款申请"),
    BSNCODE_DUEPAY_SIGN("ECD3203", "到期付款签收"),
    BSNCODE_OVERDUEPAY_APPLY("ECD3004", "逾期提示付款申请"),
    BSNCODE_OVERDUEPAY_SIGN("ECD3210", "逾期付款签收"),
    BSNCODE_GUARANTE_APPLY("ECD3106", "保证申请"),
    BSNCODE_GUARANTE_SIGN("ECD3206", "保证签收"),
    BSNCODE_COLLZTN_APPLY("ECD3107", "质押申请"),
    BSNCODE_COLLZTN_SIGN("ECD3207", "质押签收"),
    BSNCODE_RPDCOLLZTN_RELEASE_APPLY("ECD3108", "质押解除申请"),
    BSNCODE_RPDCOLLZTN_RELEASE_SIGN("ECD3208", "质押解除签收"),
    BSNCODE_RECOURSE_APPLY("ECD3109", "追索申请"),
    BSNCODE_RECOURSE_DEAL("ECD3209", "追索处理"),
    BSNCODE_PAYOFF_AGREEMENT_APPLY("ECD3111", "同意清偿申请"),
    BSNCODE_PAYOFF_AGREEMENT_SIGN("ECD3211", "同意清偿签收"),
    BSNCODE_BUSINESS_DRAWBACK("ECD1201", "业务撤销"),
    BSNCODE_DESTRUCTION_APPLY("ECD3104", "撤票申请"),
    BSNCODE_DRAFT_GENERATE_INFO("ECD7071", "票据基本信息查询"),
    BSNCODE_DRAFT_FRONTAGE_INFO("ECD7072", "票据正面信息查询"),
    BSNCODE_DRAFT_BACK_INFO("ECD7073", "票据背面信息查询"),
    BSNCODE_DRAFT_WAIT_SIGN("ECD7074", "待签收票据查询"),
    BSNCODE_ASYNC_RESULT("ECD7075", "异步请求结果查询"),
    BSNCODE_GUARANTE_INFO("ECD7076", "保证信息查询"),
    BSNCODE_LIMIT_INFO("ECD8001", "额度查询"),
    BSNCODE_COREACCOUNT("ECD7078", "核心账户查询"),
    BSNCODE_DRAFTSTATUS_CHECK("ECD7077", "票据状态核对"),
    /**
     * 业务类型busitype-适配ECDS的bizkind
     */
    BUSITYPE_BK01("BK01","出票登记"),
    BUSITYPE_BK02("BK02","提示承兑申请"),
    BUSITYPE_BK03("BK03","提示承兑签收"),
    BUSITYPE_BK04("BK04","提示收票申请"),
    BUSITYPE_BK05("BK05","提示收票签收"),
    BUSITYPE_BK06("BK06","撤票申请"),
    BUSITYPE_BK07("BK07","转让背书申请"),
    BUSITYPE_BK08("BK08","转让背书签收"),
    BUSITYPE_BK09("BK09","贴现申请"),
    BUSITYPE_BK10("BK10","贴现签收"),
    BUSITYPE_BK11("BK11","回购式贴现赎回申请"),
    BUSITYPE_BK12("BK12","回购式贴现赎回签收"),
    BUSITYPE_BK13("BK13","转贴现申请"),
    BUSITYPE_BK14("BK14","转贴现签收"),
    BUSITYPE_BK15("BK15","回购式转贴现赎回申请"),
    BUSITYPE_BK16("BK16","回购式转贴现赎回签收"),
    BUSITYPE_BK17("BK17","再贴现申请"),
    BUSITYPE_BK18("BK18","回购式再贴现赎回签收"),
    BUSITYPE_BK19("BK19","保证申请"),
    BUSITYPE_BK20("BK20","保证签收"),
    BUSITYPE_BK21("BK21","质押申请"),
    BUSITYPE_BK22("BK22","质押签收"),
    BUSITYPE_BK23("BK23","质押解除申请"),
    BUSITYPE_BK24("BK24","质押解除签收"),
    BUSITYPE_BK25("BK25","提示付款申请"),
    BUSITYPE_BK26("BK26","提示付款签收"),
    BUSITYPE_BK27("BK27","逾期提示付款申请"),
    BUSITYPE_BK28("BK28","逾期提示付款签收"),
    BUSITYPE_BK29("BK29","拒付追索申请"),
    BUSITYPE_BK40("BK40","非拒付追索申请"),
    BUSITYPE_BK30("BK30","追索通知"),
    BUSITYPE_BK31("BK31","买入央行票据"),
    BUSITYPE_BK32("BK32","转贴现报价发布"),
    BUSITYPE_BK33("BK33","票据行为撤销"),
    BUSITYPE_BK34("BK34","出票登记确认"),
    BUSITYPE_BK35("BK35","追索同意清偿申请"),
    BUSITYPE_BK36("BK36","追索同意清偿签收"),
    /**
     * 报文状态
     * haveResponse-已响应（适用于：同步请求sync，异步请求结果查询resultQuery）
     * haveReceive-已接收（适用于：异步请求async）
     * haveAccept-已受理（适用于：异步请求async）
     * haveAnswer-已回执（适用于：异步请求async）
     */
    STATUS_HAVERESPONSE("haveResponse", "已响应"),
    STATUS_HAVERECEIVE("haveReceive", "已接收"),
    STATUS_HAVEACCEPT("haveAccept", "已受理"),
    STATUS_HAVEANSWER("haveAnswer", "已回执"),

    /**
     * 点票类型
     */
    DRAFTTYPE_AC01("AC01","银承"),
    DRAFTTYPE_AC02("AC02","商承"),

    /**
     * 报文响应码
     */
    RETCODE_001("001", "成功"),
    RETCODE_000000("000000", "成功"),

    /**
     * 交易处理状态
     */
    TXTRANSSTATUS_00("00","已登记待提交"),
    TXTRANSSTATUS_01("01","已提交待复核"),
    TXTRANSSTATUS_02("02", "已提交待审批"),
    TXTRANSSTATUS_03("03", "已复核待审批"),
    TXTRANSSTATUS_11("11", "复核/审批通过待发送"),
    TXTRANSSTATUS_12("12", "发送失败"),
    TXTRANSSTATUS_13("13", "发送完成待ECDS确认"),
    TXTRANSSTATUS_21("21", "ECDS确认成功"),
    TXTRANSSTATUS_22("22", "ECDS确认失败"),
    TXTRANSSTATUS_31("31", "对方已签收"),
    TXTRANSSTATUS_32("32", "对方已拒绝"),
    TXTRANSSTATUS_33("33", "检查未通过"),
    TXTRANSSTATUS_41("41", "撤回已提交"),
    TXTRANSSTATUS_42("42", "撤回已提交待确认"),
    TXTRANSSTATUS_43("43", "撤回成功"),

    PICKUPTYPE_DRWR("drwr","按出票人查询"),
    PICKUPTYPE_HOLDER("holder", "按持有人查询"),

    BANENDRSMTMK_EM00("EM00","可再转让"),
    BANENDRSMTMK_EM01("EM01", "不得转让"),

    TXTRANSSTATUS_80("80","系统已接收待处理"),
    TXTRANSSTATUS_81("81", "系统处理中（draft系统审批中）"),
    TXTRANSSTATUS_82("82", "draft系统已将请求发往融通ECDS系统"),
    TXTRANSSTATUS_83("83", "draft系统处理异常"),
    TXTRANSSTATUS_84("84", "由于Ecds待确认时间超时而修改为确认失败"),

    DRAFTSTATUS_010004("010004","出票已登记"),
    DRAFTSTATUS_020001("020001", "提示承兑待签收"),
    DRAFTSTATUS_020006("020006", "提示承兑已签收"),
    DRAFTSTATUS_000002("000002", "票据已作废"),

    APPNO_SSFDRAFT("SsfDraft","闪收付平台"),

    CONSIGNMENTCODE_CC00("CC00","到期无条件支付委托"),

    ELCTRNCSGNTR_0("0","电子签名的默认值"),

    SIGNUPMARKCODE_SU00("SU00","同意签收"),
    SIGNUPMARKCODE_SU01("SU01","拒绝签收"),

    NEWHOEENAME_FINANCENAME("newhope","新希望财务有限公司"),

    BUSIFLAG_0("0", "未在业务中"),
    BUSIFLAG_1("1", "处于业务中"),

    GUARANTEETYPE_GT01("GT01", "出票保证"),
    GUARANTEETYPE_GT02("GT02", "承兑保证"),
    GUARANTEETYPE_GT03("GT03", "背书保证"),
    ;

    public static String getCommentByValue(String value) {
        for (DraftMessageEnum draftMessageEnum : DraftMessageEnum.values()) {
            if (value.equals(draftMessageEnum.getValue())) {
                return draftMessageEnum.getComment();
            }
        }
        return null;
    }

    private String value;
    private String comment;

    DraftMessageEnum(String value, String comment) {
        this.value = value;
        this.comment = comment;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
