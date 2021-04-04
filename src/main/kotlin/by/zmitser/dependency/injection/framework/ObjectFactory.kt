package by.zmitser.dependency.injection.framework

class ObjectFactory private constructor(private val config: Config = KotlinConfig()) {

    fun <T> createObject(type: Class<T>): T {
       return config.getImplClass(type).getDeclaredConstructor().newInstance()
    }

    companion object {
        val instance = ObjectFactory()
    }
}

