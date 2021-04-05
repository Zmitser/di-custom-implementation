package by.zmitser.dependency.injection.framework

import by.zmitser.dependency.injection.example.EmailService
import by.zmitser.dependency.injection.example.SendGridEmailService

open class ObjectFactory<T> private constructor(
    private val config: Config<T> = KotlinConfig(
        "by.zmitser.dependency.injection.example",
        mutableMapOf(EmailService::class.java as Class<T> to SendGridEmailService::class.java as Class<T>)
    )
) {

    fun createObject(type: Class<T>): T {
        var implClass: Class<out T> = type
        if (type.isInterface) {
            implClass = config.getImplClass(type)
        }
        return implClass.getDeclaredConstructor().newInstance()
    }

    companion object {
        fun <T> getInstance() = ObjectFactory<T>()
    }
}

