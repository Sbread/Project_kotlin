package BBCodeAPI

import BBCodeDsl.BBCodeDsl

@BBCodeDsl
class BBCodeObject {
    val content = ArrayList<BBCElementInterface>()

    override fun toString(): String {
        return buildString {
            content.forEach { append(it.toString()).append("\n") }
        }
    }
}
