package by.zmitser.dependency.injection.example

fun main() {
    val  notificationService = UserNotificationService()
    notificationService.notify(User("1@2.by", "+375299169985"), "Скидка на баклажаны")
}