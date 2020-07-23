public class ECD7071Output {
    private String serialNo;
    private String retCode;
    private String retMsg;
    /**
     * 票据号码
     */
    private String draftNo;
    /**
     * 票面金额
     */
    private String isseAmount;
    /**
     * 出票日期
     */
    private String isseDate;
    /**
     * 到期日
     */
    private String dueDate;
    /**
     * 票据状态
     */
    private String draftStatus;
    /**
     * 出票人账号
     */
    private String drwrAcctid;
    /**
     * 出票人名称
     */
    private String drwrName;
    /**
     * 出票人开户行行号
     */
    private String drwrAcctsvcr;
    /**
     * 出票人开户行名称
     */
    private String drwrAcctsvcrName;
    /**
     * 收款人账号
     */
    private String pyeeAcctid;
    /**
     * 收款人名称
     */
    private String pyeeName;
    /**
     * 收款人开户行行号
     */
    private String pyeeAcctsvcr;
    /**
     * 收款人开户行名称
     */
    private String pyeeAcctsvcrName;
    /**
     * 承兑人账号
     */
    private String accptrAcctid;
    /**
     * 承兑人名称
     */
    private String accptrName;
    /**
     * 承兑人开户行行号
     */
    private String accptrAcctsvcr;
    /**
     * 承兑人开户行名称
     */
    private String accptrAcctsvcrName;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getDraftNo() {
        return draftNo;
    }

    public void setDraftNo(String draftNo) {
        this.draftNo = draftNo;
    }

    public String getIsseAmount() {
        return isseAmount;
    }

    public void setIsseAmount(String isseAmount) {
        this.isseAmount = isseAmount;
    }

    public String getIsseDate() {
        return isseDate;
    }

    public void setIsseDate(String isseDate) {
        this.isseDate = isseDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDraftStatus() {
        return draftStatus;
    }

    public void setDraftStatus(String draftStatus) {
        this.draftStatus = draftStatus;
    }

    public String getDrwrAcctid() {
        return drwrAcctid;
    }

    public void setDrwrAcctid(String drwrAcctid) {
        this.drwrAcctid = drwrAcctid;
    }

    public String getDrwrName() {
        return drwrName;
    }

    public void setDrwrName(String drwrName) {
        this.drwrName = drwrName;
    }

    public String getDrwrAcctsvcr() {
        return drwrAcctsvcr;
    }

    public void setDrwrAcctsvcr(String drwrAcctsvcr) {
        this.drwrAcctsvcr = drwrAcctsvcr;
    }

    public String getDrwrAcctsvcrName() {
        return drwrAcctsvcrName;
    }

    public void setDrwrAcctsvcrName(String drwrAcctsvcrName) {
        this.drwrAcctsvcrName = drwrAcctsvcrName;
    }

    public String getPyeeAcctid() {
        return pyeeAcctid;
    }

    public void setPyeeAcctid(String pyeeAcctid) {
        this.pyeeAcctid = pyeeAcctid;
    }

    public String getPyeeName() {
        return pyeeName;
    }

    public void setPyeeName(String pyeeName) {
        this.pyeeName = pyeeName;
    }

    public String getPyeeAcctsvcr() {
        return pyeeAcctsvcr;
    }

    public void setPyeeAcctsvcr(String pyeeAcctsvcr) {
        this.pyeeAcctsvcr = pyeeAcctsvcr;
    }

    public String getPyeeAcctsvcrName() {
        return pyeeAcctsvcrName;
    }

    public void setPyeeAcctsvcrName(String pyeeAcctsvcrName) {
        this.pyeeAcctsvcrName = pyeeAcctsvcrName;
    }

    public String getAccptrAcctid() {
        return accptrAcctid;
    }

    public void setAccptrAcctid(String accptrAcctid) {
        this.accptrAcctid = accptrAcctid;
    }

    public String getAccptrName() {
        return accptrName;
    }

    public void setAccptrName(String accptrName) {
        this.accptrName = accptrName;
    }

    public String getAccptrAcctsvcr() {
        return accptrAcctsvcr;
    }

    public void setAccptrAcctsvcr(String accptrAcctsvcr) {
        this.accptrAcctsvcr = accptrAcctsvcr;
    }

    public String getAccptrAcctsvcrName() {
        return accptrAcctsvcrName;
    }

    public void setAccptrAcctsvcrName(String accptrAcctsvcrName) {
        this.accptrAcctsvcrName = accptrAcctsvcrName;
    }

    @Override
    public String toString() {
        return "ECD7071Output{" +
                "serialNo='" + serialNo + '\'' +
                ", retCode='" + retCode + '\'' +
                ", retMsg='" + retMsg + '\'' +
                ", draftNo='" + draftNo + '\'' +
                ", isseAmount='" + isseAmount + '\'' +
                ", isseDate='" + isseDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", draftStatus='" + draftStatus + '\'' +
                ", drwrAcctid='" + drwrAcctid + '\'' +
                ", drwrName='" + drwrName + '\'' +
                ", drwrAcctsvcr='" + drwrAcctsvcr + '\'' +
                ", drwrAcctsvcrName='" + drwrAcctsvcrName + '\'' +
                ", pyeeAcctid='" + pyeeAcctid + '\'' +
                ", pyeeName='" + pyeeName + '\'' +
                ", pyeeAcctsvcr='" + pyeeAcctsvcr + '\'' +
                ", pyeeAcctsvcrName='" + pyeeAcctsvcrName + '\'' +
                ", accptrAcctid='" + accptrAcctid + '\'' +
                ", accptrName='" + accptrName + '\'' +
                ", accptrAcctsvcr='" + accptrAcctsvcr + '\'' +
                ", accptrAcctsvcrName='" + accptrAcctsvcrName + '\'' +
                '}';
    }
}