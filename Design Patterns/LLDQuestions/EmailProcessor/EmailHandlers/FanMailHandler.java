package LLDQuestions.EmailProcessor.EmailHandlers;

import LLDQuestions.EmailProcessor.Email.Email;
import LLDQuestions.EmailProcessor.Email.EmailType;

public class FanMailHandler extends EmailHandler {

    public FanMailHandler(EmailHandler nextEmailHandler) {
        super(nextEmailHandler);
    }
    
    @Override
    public void handleMail(EmailType mailType, Email email) {
        if(mailType == EmailType.FAN_MAIL) {
            System.out.println("Fan-Mail: " + email.getContent() + ", Delivered to the CEO");
        } else {
            super.handleMail(mailType, email);
        }
    }
    
}
