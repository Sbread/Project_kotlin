import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.BooleanNode
import com.fasterxml.jackson.databind.node.DoubleNode
import com.fasterxml.jackson.databind.node.IntNode
import com.fasterxml.jackson.databind.node.LongNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.node.TextNode
import com.fasterxml.jackson.databind.node.ValueNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

val mapper = jacksonObjectMapper()

@DslMarker
annotation class JsonMarker

@JsonMarker
abstract class JacksonElement(val node: JsonNode) {

    override fun hashCode(): Int = node.hashCode()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is JacksonElement) return false
        return node == other.node
    }

    override fun toString(): String = mapper.writeValueAsString(node)

}

@JsonMarker
class JacksonPrimitive(node: ValueNode) : JacksonElement(node) {
    infix fun `-`(key: String) = node.get(key)
}

@JsonMarker
class JacksonObject(node: ObjectNode = mapper.createObjectNode()) : JacksonElement(node) {

    fun json(key: String, value: JacksonObject.() -> Unit): JacksonObject = `+`(key, JacksonObject().apply(value).node)

    fun array(key: String, value: JacksonArray.() -> Unit): JacksonObject = `+`(key, JacksonArray().apply(value).node)

    infix fun String.`+`(value: String): JacksonObject = `+`(this, TextNode(value))
    infix fun String.`+`(value: Int): JacksonObject = `+`(this, IntNode(value))
    infix fun String.`+`(value: Long): JacksonObject = `+`(this, LongNode(value))
    infix fun String.`+`(value: Double): JacksonObject = `+`(this, DoubleNode(value))
    infix fun String.`+`(value: Boolean): JacksonObject = `+`(this, BooleanNode.valueOf(value))
    infix fun String.`+`(value: JacksonElement): JacksonObject = `+`(this, value.node)

    private fun `+`(key: String, value: JsonNode) = (node as ObjectNode).replace(key, value).let { this }

    infix fun `-`(key: String) = (node as ObjectNode).get(key)
}

@JsonMarker
class JacksonArray(array: ArrayNode = mapper.createArrayNode()) : JacksonElement(array) {

    fun json(value: JacksonObject.() -> Unit): JacksonArray = `+`(JacksonObject().apply(value).node)

    fun array(value: JacksonArray.() -> Unit): JacksonArray = `+`(JacksonArray().apply(value).node)

    fun `+`(value: String): JacksonArray = `+`(TextNode(value))
    fun `+`(value: Int): JacksonArray = `+`(IntNode(value))
    fun `+`(value: Long): JacksonArray = `+`(LongNode(value))
    fun `+`(value: Double): JacksonArray = `+`(DoubleNode(value))
    fun `+`(value: Boolean): JacksonArray = `+`(BooleanNode.valueOf(value))
    fun `+`(value: JacksonElement): JacksonArray = `+`(value.node)

    private fun `+`(node: JsonNode) = (this.node as ArrayNode).add(node).let { this }
    infix fun `-`(key: String) = (node as ArrayNode).get(key)


}

fun json(init: JacksonObject.() -> Unit): JacksonObject = JacksonObject().apply(init)

fun array(init: JacksonArray.() -> Unit): JacksonArray = JacksonArray().apply(init)


fun main(args: Array<String>) {

    val json = json {
        "name" `+` "Dan"
        "capitals" `+` json {
            "Russia" `+` "Moscow"
            "USA" `+` "Washington"
        }
        "years" `+` 19
        "games" `+` array {
            `+`("CS")
            `+`(2)
        }
    }
    val field = json `-` "name"
    println(field)
    val field2 = json `-` "capitals"
    println(field2)
    println(json)

}
