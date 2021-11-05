package pers.xf.learn.designpattern.chain_of_responsibility.loginprocess;

import pers.xf.learn.designpattern.chain_of_responsibility.User;

public class LoginService {
    public void login(){
        Handler validateHandler = new ValidateHandler();
        Handler loginHandler = new LoginHandler();
        Handler authHandler = new AuthHandler();

        validateHandler.next(loginHandler);
        loginHandler.next(authHandler);

        validateHandler.doHandle(new User());
    }
}
