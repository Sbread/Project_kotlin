package BBCodeAPI

import BBCodeDsl.BBCodeDsl

@BBCodeDsl
class BBCBaseElement : BBCElementInterface {
    lateinit var content: String
    override fun toString(): String = content
}
