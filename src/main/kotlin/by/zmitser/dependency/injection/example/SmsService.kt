package by.zmitser.dependency.injection.example

interface SmsService {
    fun sendSms(message: String, phone: String)
}

class SimpleSmsService : SmsService {
    override fun sendSms(message: String, phone: String) {
        println("Sms sent to the phone number $phone with message = '$message'")
    }
}