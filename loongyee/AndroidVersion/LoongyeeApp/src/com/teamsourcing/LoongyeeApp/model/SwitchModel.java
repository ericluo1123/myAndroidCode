package com.teamsourcing.LoongyeeApp.model;

/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 2013/12/16
 * Time: 上午 9:53
 * To change this template use File | Settings | File Templates.
 */
public class SwitchModel {
    private int id;
    private String status;
    private String code;
    private String Keyid;

    public int getId() {
        return id;
    }
    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }
    public String getKeyid() {
        return Keyid;
    }

    public void setKeyid(String Keyid) {
        this.Keyid = Keyid;
    }
}
