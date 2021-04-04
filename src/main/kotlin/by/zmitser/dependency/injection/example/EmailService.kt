package by.zmitser.dependency.injection.example

interface EmailService {
    fun sendEmail(message: String, receiver: String)
}

class SimpleEmailService() : EmailService {
    override fun sendEmail(message: String, receiver: String) {
        println("Email sent to $receiver with message = '$message'")
    }
}