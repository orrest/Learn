package pers.xf.learn.designpattern.chain_of_responsibility;

import pers.xf.learn.designpattern.chain_of_responsibility.loginprocess.LoginService;

public class Test {
    public static void main(String[] args) {
        new LoginService().login();
    }
}
