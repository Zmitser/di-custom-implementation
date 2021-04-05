package by.zmitser.dependency.injection.example

import by.zmitser.dependency.injection.framework.ObjectFactory

class UserNotificationService(
    private val emailService: EmailService = ObjectFactory.getInstance<EmailService>()
        .createObject(EmailService::class.java),
    private val smsService: SmsService = ObjectFactory.getInstance<SmsService>().createObject(SmsService::class.java)
) {


    fun notify(user: User, message: String) {
        emailService.sendEmail(message, user.email)
        smsService.sendSms(message, user.phone)
    }
}