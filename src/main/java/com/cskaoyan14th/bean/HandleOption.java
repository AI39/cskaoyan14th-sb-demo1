package com.cskaoyan14th.bean;

public class HandleOption {

    boolean cancel;

    boolean delete;

    boolean pay;

    boolean comment;

    boolean confirm;

    boolean refund;

    boolean rebuy;

    public HandleOption() {
    }

    public HandleOption(boolean cancel, boolean delete, boolean pay, boolean comment, boolean confirm, boolean refund, boolean rebuy) {
        this.cancel = cancel;
        this.delete = delete;
        this.pay = pay;
        this.comment = comment;
        this.confirm = confirm;
        this.refund = refund;
        this.rebuy = rebuy;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public boolean isComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    public boolean isRebuy() {
        return rebuy;
    }

    public void setRebuy(boolean rebuy) {
        this.rebuy = rebuy;
    }
}
