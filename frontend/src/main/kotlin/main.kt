@JsModule("lodash")
external object Lodash {
    fun uniqueId(prefix: String? = definedExternally): String
}

fun main(args: Array<String>) {
    println(Lodash.uniqueId())
    println(Lodash.uniqueId("zwei_"))
}
