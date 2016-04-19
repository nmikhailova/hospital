package menu.test;

import action.LoginAction;
import manager.ActionManager;
import manager.ClassManager;
import manager.Serv;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class RunnerManager {
    public static void main(String[] args) {
        System.out.println("manager");
        Object o = ClassManager.get(LoginAction.class);
        Serv s = ActionManager.findAction("login");
//        s.service("", "");
        System.out.println(o);
    }
}
