package BBCodeAPI

import BBCodeDsl.BBCodeDsl

@BBCodeDsl
class Image(builder: Image.() -> String) : BBCElementInterface {
    private val image = builder(this)
    override fun toString() = buildString {
        append("[img] $image")
    }
}
