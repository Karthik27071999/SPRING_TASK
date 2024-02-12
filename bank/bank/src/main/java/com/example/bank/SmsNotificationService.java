package com.example.bank;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService {

    @Value("${twilio.account-sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth-token}")
    private String twilioAuthToken;

    @Value("${twilio.phone-number}")
    private String twilioPhoneNumber;

    public void sendSmsNotification(String recipientPhoneNumber, String messageBody) {
        Twilio.init(twilioAccountSid, twilioAuthToken);
        Message message = Message.creator(
                new PhoneNumber(recipientPhoneNumber),
                new PhoneNumber(twilioPhoneNumber),
                messageBody)
                .create();
        System.out.println("SMS notification sent successfully to " + recipientPhoneNumber);
    }


}
