package by.zmitser.dependency.injection.example

import by.zmitser.dependency.injection.framework.ObjectFactory

class UserNotificationService(
    private val emailService: EmailService = ObjectFactory.instance.createObject(EmailService::class.java),
    private val smsService: SmsService = ObjectFactory.instance.createObject(SmsService::class.java)
) {


    fun notify(user: User, message: String) {
        emailService.sendEmail(message, user.email)
        smsService.sendSms(message, user.phone)
    }
}