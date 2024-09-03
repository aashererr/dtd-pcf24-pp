package com.twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


// This class sends an SMS message to a list of phone numbers
// using the Twilio API
// It is meant to be used in conjunction with a Twilio account
// and a valid Twilio number
public class SmsSender {

    //+18552549217
    public static final String ACCOUNT_SID = "AC644b4b417f3aa1a773964459c49476b0";
    public static final String AUTH_TOKEN = "1cbf6629e25f675427a7a3ba7d6377d0";
    public static final String MY_NUMBER = "+18552549217";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        String[] phoneNumbers = [
                "+16789102545", "+14435646878", "+14043535262", "+14049158005",
                "+14702639579", "+18438174250", "+17702430290", "+14232402441", "+14042165231," +
                "+18473239631", "+14047479768", "+18153126651", "+16785207344", "+17065082204",
                "+!6786870581", "+14704239540"
        ];

        for (String number : phoneNumbers) {
            Message message = Message.creator(
                    new PhoneNumber(number),
                    new PhoneNumber(MY_NUMBER),
                    "Test message"
                    ).create();
            System.out.println("Message sent to " + number + ": " + message.getSid());
        }

    }
}