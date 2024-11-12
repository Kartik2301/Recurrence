package LLDQuestions.EmailProcessor;

import LLDQuestions.EmailProcessor.Email.Email;
import LLDQuestions.EmailProcessor.Email.EmailType;
import LLDQuestions.EmailProcessor.EmailHandlers.ComplaintMailHandler;
import LLDQuestions.EmailProcessor.EmailHandlers.EmailHandler;
import LLDQuestions.EmailProcessor.EmailHandlers.FanMailHandler;
import LLDQuestions.EmailProcessor.EmailHandlers.RequestsMailHandler;
import LLDQuestions.EmailProcessor.EmailHandlers.SpamMailHandler;

public class Client {
    public static void main(String[] args) {
        EmailDetector detector = new EmailDetector();
        EmailHandler emailHandler = new FanMailHandler(new RequestsMailHandler(new ComplaintMailHandler(new SpamMailHandler(null))));

        Email email = new Email("Hi There poop");
        emailHandler.handleMail(detector.detectEmailType(email, EmailType.FAN_MAIL), email);

        email = new Email("Your machines are the worst, they stink");
        emailHandler.handleMail(detector.detectEmailType(email, EmailType.REQUEST_MAIL), email);

        email = new Email("I think this is a good machine");
        emailHandler.handleMail(detector.detectEmailType(email, EmailType.COMPLAINT_MAIL), email);

        email = new Email("You have won Rs. 234234");
        emailHandler.handleMail(detector.detectEmailType(email, EmailType.SPAM_MAIL), email);
    }
}
