package com.cskaoyan14th.bean;

/**
 * @author Yuechao Yang
 * @version 2019-07-09-16:16
 */
public class WxHandleOption {
    private boolean cancel;
    private boolean comment;
    private boolean confirm;
    private boolean delete;
    private boolean pay;
    private boolean rebuy;
    private boolean refund;

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
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

    public boolean isRebuy() {
        return rebuy;
    }

    public void setRebuy(boolean rebuy) {
        this.rebuy = rebuy;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    public WxHandleOption() {
    }

    public WxHandleOption(boolean cancel, boolean comment, boolean confirm, boolean delete, boolean pay, boolean rebuy, boolean refund) {
        this.cancel = cancel;
        this.comment = comment;
        this.confirm = confirm;
        this.delete = delete;
        this.pay = pay;
        this.rebuy = rebuy;
        this.refund = refund;
    }

    @Override
    public String toString() {
        return "WxHandleOption{" +
                "cancel=" + cancel +
                ", comment=" + comment +
                ", confirm=" + confirm +
                ", delete=" + delete +
                ", pay=" + pay +
                ", rebuy=" + rebuy +
                ", refund=" + refund +
                '}';
    }
}
