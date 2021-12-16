package org.liujiazhen.poi.entity;

import java.util.Date;

public class SalaryModel {
    private int id;
    private String status;
    private int createId;
    private String createName;
    private long createTime;
    private String createDateStr;
    private String createTimeStr;
    private int modifyId;
    private String modifyName;
    private String modifyTime;
    private String modifyDateStr;
    private String modifyTimeStr;
    private int cancelId;
    private String cancelName;
    private String cancelTime;
    private String cancelDateStr;
    private String cancelTimeStr;
    private int companyId;
    private String companyName;
    private int userId;
    private String userName;
    private int base;
    private int subsidy;
    private int deduction;
    private int reward;
    private int insurance;
    private int funds;
    private int specialDeduction;
    private double incomeTax;
    private double payWages;
    private String payDate;
    private String month;
    private String remark;
    private String businessRemark;
    private int linkId;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCreateId(int createId) {
        this.createId = createId;
    }

    public int getCreateId() {
        return createId;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setModifyId(int modifyId) {
        this.modifyId = modifyId;
    }

    public int getModifyId() {
        return modifyId;
    }

    public void setModifyName(String modifyName) {
        this.modifyName = modifyName;
    }

    public String getModifyName() {
        return modifyName;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyDateStr(String modifyDateStr) {
        this.modifyDateStr = modifyDateStr;
    }

    public String getModifyDateStr() {
        return modifyDateStr;
    }

    public void setModifyTimeStr(String modifyTimeStr) {
        this.modifyTimeStr = modifyTimeStr;
    }

    public String getModifyTimeStr() {
        return modifyTimeStr;
    }

    public void setCancelId(int cancelId) {
        this.cancelId = cancelId;
    }

    public int getCancelId() {
        return cancelId;
    }

    public void setCancelName(String cancelName) {
        this.cancelName = cancelName;
    }

    public String getCancelName() {
        return cancelName;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelDateStr(String cancelDateStr) {
        this.cancelDateStr = cancelDateStr;
    }

    public String getCancelDateStr() {
        return cancelDateStr;
    }

    public void setCancelTimeStr(String cancelTimeStr) {
        this.cancelTimeStr = cancelTimeStr;
    }

    public String getCancelTimeStr() {
        return cancelTimeStr;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getBase() {
        return base;
    }

    public void setSubsidy(int subsidy) {
        this.subsidy = subsidy;
    }

    public int getSubsidy() {
        return subsidy;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    public int getDeduction() {
        return deduction;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    public int getFunds() {
        return funds;
    }

    public void setSpecialDeduction(int specialDeduction) {
        this.specialDeduction = specialDeduction;
    }

    public int getSpecialDeduction() {
        return specialDeduction;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setPayWages(double payWages) {
        this.payWages = payWages;
    }

    public double getPayWages() {
        return payWages;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setBusinessRemark(String businessRemark) {
        this.businessRemark = businessRemark;
    }

    public String getBusinessRemark() {
        return businessRemark;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public int getLinkId() {
        return linkId;
    }

    @Override
    public String toString() {
        return "SalaryModel{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", createId=" + createId +
                ", createName='" + createName + '\'' +
                ", createTime=" + createTime +
                ", createDateStr='" + createDateStr + '\'' +
                ", createTimeStr='" + createTimeStr + '\'' +
                ", modifyId=" + modifyId +
                ", modifyName='" + modifyName + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", modifyDateStr='" + modifyDateStr + '\'' +
                ", modifyTimeStr='" + modifyTimeStr + '\'' +
                ", cancelId=" + cancelId +
                ", cancelName='" + cancelName + '\'' +
                ", cancelTime='" + cancelTime + '\'' +
                ", cancelDateStr='" + cancelDateStr + '\'' +
                ", cancelTimeStr='" + cancelTimeStr + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", base=" + base +
                ", subsidy=" + subsidy +
                ", deduction=" + deduction +
                ", reward=" + reward +
                ", insurance=" + insurance +
                ", funds=" + funds +
                ", specialDeduction=" + specialDeduction +
                ", incomeTax=" + incomeTax +
                ", payWages=" + payWages +
                ", payDate='" + payDate + '\'' +
                ", month=" + month +
                ", remark='" + remark + '\'' +
                ", businessRemark='" + businessRemark + '\'' +
                ", linkId=" + linkId +
                '}';
    }
}