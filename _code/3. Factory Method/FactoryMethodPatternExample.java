public class FactoryMethodPatternExample {
  public static void main(String[] args) {
    NotificationFactory emailFactory = new EmailNotificationFactory();
    emailFactory.sendNotification();

    NotificationFactory smsFactory = new SMSNotificationFactory();
    smsFactory.sendNotification();
  }
}
