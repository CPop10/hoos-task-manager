package uva.girlshoohack.controller;

import uva.girlshoohack.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private SendEmailService emailService;

    // This endpoint accepts email details from the user
    @PostMapping("/send")
    public String sendEmail(@RequestParam String recipient, @RequestParam String subject, @RequestParam String body) {
        try {
            emailService.sendEmail(recipient, body, subject);  // Call the email service
            return "Email sent successfully to " + recipient;
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }
    }
}

