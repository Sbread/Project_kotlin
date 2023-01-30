package BBCodeAPI

import BBCodeDsl.BBCodeDsl

@BBCodeDsl
class BBCUnorderedList : BBCListInterface {
    val items = ArrayList<BBCBaseElement>()
    override fun toString() = buildString {
        items.forEach { append("* $it").appendLine() }
    }
}

@BBCodeDsl
class BBCOrderedList : BBCListInterface {
    val items = ArrayList<BBCBaseElement>()
    override fun toString() = buildString {
        items.forEachIndexed {i, elem ->  append("${i + 1}. $elem").appendLine() }
    }
}
