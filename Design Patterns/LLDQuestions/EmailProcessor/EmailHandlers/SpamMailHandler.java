package LLDQuestions.EmailProcessor.EmailHandlers;

import LLDQuestions.EmailProcessor.Email.Email;
import LLDQuestions.EmailProcessor.Email.EmailType;

public class SpamMailHandler extends EmailHandler {
    public SpamMailHandler(EmailHandler nextEmailHandler) {
        super(nextEmailHandler);
    }

    @Override
    public void handleMail(EmailType mailType, Email email) {
        if(mailType == EmailType.SPAM_MAIL) {
            System.out.println("Spam-Mail: " + email.getContent() + ", Deleted");
        } else {
            super.handleMail(mailType, email);
        }
    }
}
