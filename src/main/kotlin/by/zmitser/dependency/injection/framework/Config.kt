package by.zmitser.dependency.injection.framework

interface Config {

    fun <T> getImplClass(ifc: Class<T>): Class<T>
}

class KotlinConfig : Config {

    override fun <T> getImplClass(ifc: Class<T>): Class<T> {
        return this.javaClass.classLoader.loadClass(ifc.name) as Class<T>
    }
}