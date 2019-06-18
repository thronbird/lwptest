package com.lwptest.basic.jackson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liwanping
 * @date 2018-11-19
 */
public class O implements Serializable {
    private static final long serialVersionUID = -3004824622398622080L;
    private String userName ;
    private String idNumber ;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public static void main (String[] args ){
        List O = new ArrayList();
        O.add(new O());
        O.add(new O());
    }
}
