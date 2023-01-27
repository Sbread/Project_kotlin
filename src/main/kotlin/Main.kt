import org.json.JSONArray
import org.json.JSONObject

infix fun Any.`-`(key: String): Any {
    if (this is JSONObject) {
        return get(key)
    }
    return this
}
class Json() : JSONObject() {

    constructor(init: Json.() -> Unit) : this() {
        this.init()
    }

    infix fun String.`+`(json: Json.() -> Unit) {
        put(this, Json().apply(json))
    }

    infix fun <T> String.`+`(value: T) {
        put(this, value)
    }

    infix fun <T> String.`+`(values: List<T>) {
        put(this, JSONArray().apply {
            values.forEach { put(it) }
        })
    }
}

fun main(args: Array<String>) {

    val json = Json {
        "name" `+` "Dan"
        "capitals" `+` {
            "Russia" `+` "Moscow"
            "USA" `+` "Washington"
        }
        "years" `+` 19
        "games" `+` listOf("CS", "DOTA", "HOTA")
    }
    val field = json `-` "name"
    println(field)
    val field2 = json `-` "capitals" `-` "Russia"
    println(field2)
    val field3 = json `-` "years"
    println(field3)
    println(json)

}
