import io.github.classgraph.ClassGraph

interface Config {

    fun <T> getImplClass(ifc: Class<T>): Class<T>
}

class KotlinConfig(private val packageToScan: String, private val classGraph: ClassGraph = ClassGraph()) : Config {

    override fun <T> getImplClass(ifc: Class<T>): Class<T> {
        val result = classGraph.acceptPackages(packageToScan)
            .scan()
            .allClasses.filter {
                it.implementsInterface(ifc.name)
            }
        if (result.size != 1) {
            throw RuntimeException("$ifc has 0 or more than one impl")
        }
        return result.loadClasses(ifc).first()
    }
}