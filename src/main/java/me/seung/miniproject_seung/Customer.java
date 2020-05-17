package me.seung.miniproject_seung;

public class Customer {
    
    Integer custId;

    String custName;
    String address;
    String custType;
    Integer lineAmt;

    Integer ssan;
    Integer phoneNum;

    Integer corpRegistNum;
    Integer corpPhoneNum;
    String representName;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public Integer getLineAmt() {
        return lineAmt;
    }

    public void setLineAmt(Integer lineAmt) {
        this.lineAmt = lineAmt;
    }

    public Integer getSsan() {
        return ssan;
    }

    public void setSsan(Integer ssan) {
        this.ssan = ssan;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCorpRegistNum() {
        return corpRegistNum;
    }

    public void setCorpRegistNum(Integer corpRegistNum) {
        this.corpRegistNum = corpRegistNum;
    }

    public Integer getCorpPhoneNum() {
        return corpPhoneNum;
    }

    public void setCorpPhoneNum(Integer corpPhoneNum) {
        this.corpPhoneNum = corpPhoneNum;
    }

    public String getRepresentName() {
        return representName;
    }

    public void setRepresentName(String representName) {
        this.representName = representName;
    }

}