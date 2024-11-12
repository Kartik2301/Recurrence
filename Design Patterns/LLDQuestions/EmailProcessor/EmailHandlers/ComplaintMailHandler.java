package LLDQuestions.EmailProcessor.EmailHandlers;

import LLDQuestions.EmailProcessor.Email.Email;
import LLDQuestions.EmailProcessor.Email.EmailType;

public class ComplaintMailHandler extends EmailHandler {
    public ComplaintMailHandler(EmailHandler nextEmailHandler) {
        super(nextEmailHandler);
    }

    @Override
    public void handleMail(EmailType mailType, Email email) {
        if(mailType == EmailType.COMPLAINT_MAIL) {
            System.out.println("Complaint-Mail: " + email.getContent() + ",  Delivered to the Legal Department");
        } else {
            super.handleMail(mailType, email);
        }
    }
}
