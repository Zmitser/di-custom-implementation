package by.zmitser.dependency.injection.framework

import Config
import KotlinConfig

class ObjectFactory private constructor(private val config: Config = KotlinConfig("by.zmitser.dependency.injection.example")) {

    fun <T> createObject(type: Class<T>): T {
        var implClass: Class<out T> = type
        if (type.isInterface) {
            implClass = config.getImplClass(type)
        }
        return implClass.getDeclaredConstructor().newInstance()
    }

    companion object {
        val instance = ObjectFactory()
    }
}

