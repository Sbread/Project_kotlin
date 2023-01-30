package BBCodeAPI

import BBCodeDsl.BBCodeDsl

@BBCodeDsl
class BBCUnorderedList : BBCListInterface {
    val items = ArrayList<BBCBaseElement>()
    override fun toString(): String {
        return buildString {
            items.forEach { append("* $it\n") }
        }
    }
}

@BBCodeDsl
class BBCOrderedList : BBCListInterface {
    val items = ArrayList<BBCBaseElement>()
    override fun toString(): String {
        return buildString {
            items.forEachIndexed {i, elem ->  append("${i + 1}. $elem\n") }
        }
    }
}
