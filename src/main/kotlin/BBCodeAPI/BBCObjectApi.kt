package BBCodeAPI

import BBCodeDsl.BBCodeDsl
import java.io.File

@BBCodeDsl
class BBCodeObject {
    val content = ArrayList<BBCElementInterface>()

    override fun toString() = buildString {
        content.forEach { append(it.toString()).appendLine() }
    }

    fun writeToFile(name: String) {
        File(name).writeText(toString())
    }
}
