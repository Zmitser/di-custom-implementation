package by.zmitser.dependency.injection.framework

import io.github.classgraph.ClassGraph

interface Config<T> {

    fun getImplClass(ifc: Class<T>): Class<T>
}

class KotlinConfig<T>(
    private val packageToScan: String,
    private val ifcToImplClass: MutableMap<Class<T>, Class<T>> = mutableMapOf(),
    private val classGraph: ClassGraph = ClassGraph()
) : Config<T> {

    override fun getImplClass(ifc: Class<T>): Class<T> {
        return ifcToImplClass.getOrPut(ifc, {
            val result = classGraph.acceptPackages(packageToScan)
                .scan()
                .allClasses.filter {
                    it.implementsInterface(ifc.name)
                }
            if (result.size != 1) {
                throw RuntimeException("$ifc has 0 or more than one impl")
            }
            return result.loadClasses(ifc).first()
        })
    }
}