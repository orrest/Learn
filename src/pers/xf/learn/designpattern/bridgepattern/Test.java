package pers.xf.learn.designpattern.bridgepattern;

/**
 * 也就是将消息的
 *      - 紧急程度
 *      - 类别
 * 作为了两个抽象分别来实现.
 * 这两个抽象上又分别有不同类型的具体的实现类.
 */
public class Test {
    public static void main(String[] args) {
        AbstractMessage smsButNormal = new NormalMessage(
                new SmsMessage(
                        "Fire in the hole!!!!",
                        "team member"));

        smsButNormal.sendMessage();

// ---

        AbstractMessage emailButUrgent = new UrgentMessage(
                new EmailMessage(
                        "Fire in the hole!!!!",
                        "team member"));

        emailButUrgent.sendMessage();
    }
}
