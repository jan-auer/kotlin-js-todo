/**
 * Binding to the native lodash implementation (installed via npm).
 *
 * This requires a module loader that can provide the "lodash" module, likely
 * installed with "npm install lodash".
 *
 * Also, if webpack is configured correctly, tree shaking will make sure that
 * all unused lodash functions get eliminated in the final bundle to reduce
 * asset size.
 */
@JsModule("lodash")
external object Lodash {
    /**
     * Generates a unique ID. If prefix is given, the ID is appended to it
     */
    fun uniqueId(prefix: String = definedExternally): String;
}
