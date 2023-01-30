package BBCodeAPI

import BBCodeDsl.BBCodeDsl

@BBCodeDsl
class Link(builder: Link.() -> String) : BBCElementInterface {
    private val link = builder(this)
    override fun toString(): String {
        return buildString {
            append("[url] $link")
        }
    }
}

@BBCodeDsl
class Youtube(builder: Youtube.() -> String) : BBCElementInterface {
    private val name = builder(this)
    override fun toString(): String {
        return buildString {
            append("[youtube] $name")
        }
    }
}
