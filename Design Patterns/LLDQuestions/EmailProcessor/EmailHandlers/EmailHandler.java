package LLDQuestions.EmailProcessor.EmailHandlers;

import LLDQuestions.EmailProcessor.Email.Email;
import LLDQuestions.EmailProcessor.Email.EmailType;

public abstract class EmailHandler {
    private EmailHandler nextEmailHandler;

    public EmailHandler(EmailHandler nextEmailHandler) {
        this.nextEmailHandler = nextEmailHandler;
    }

    public void handleMail(EmailType mailType, Email email) {
        if(nextEmailHandler != null) {
            nextEmailHandler.handleMail(mailType, email);
        }
    }
}
