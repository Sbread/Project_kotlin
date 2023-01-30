package BBCodeAPI

import BBCodeDsl.BBCodeDsl

@BBCodeDsl
class BoldText(builder: BoldText.() -> String) : BBCElementInterface {
    private val text: String = builder(this)
    override fun toString() = buildString { append("**$text**") }
}

@BBCodeDsl
class ItalianText(builder: ItalianText.() -> String) : BBCElementInterface {
    private val text: String = builder(this)
    override fun toString() = buildString { append("*$text*") }
}

@BBCodeDsl
class DefaultText(builder: DefaultText.() -> String) : BBCElementInterface {
    private val text: String = builder(this)
    override fun toString() = buildString { append(text) }
}

@BBCodeDsl
class StrikethroughText(builder: StrikethroughText.() -> String) : BBCElementInterface {
    private val text: String = builder(this)
    override fun toString() = buildString { append("-$text-") }
}

@BBCodeDsl
class UnderlineText(builder: UnderlineText.() -> String) : BBCElementInterface {
    private val text: String = builder(this)
    override fun toString() = buildString { append("_").append(text).append("_") }
}

@BBCodeDsl
class CodeText(builder: CodeText.() -> String) : BBCElementInterface {
    private val text: String = builder(this)
    override fun toString() = buildString { append("`$text`") }
}

@BBCodeDsl
class QuoteText(builder: QuoteText.() -> String) : BBCElementInterface {
    private val text: String = builder(this)
    override fun toString() = buildString { append("~$text~") }
}
