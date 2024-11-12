package LLDQuestions.EmailProcessor.EmailHandlers;

import LLDQuestions.EmailProcessor.Email.Email;
import LLDQuestions.EmailProcessor.Email.EmailType;

public class RequestsMailHandler extends EmailHandler {
    public RequestsMailHandler(EmailHandler nextEmailHandler) {
        super(nextEmailHandler);
    }

    @Override
    public void handleMail(EmailType mailType, Email email) {
        if(mailType == EmailType.REQUEST_MAIL) {
            System.out.println("Request-Mail: " + email.getContent() + ",  Delivered to the Business Development Department");
        } else {
            super.handleMail(mailType, email);
        }
    }
}
