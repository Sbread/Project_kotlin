package BBCodeDsl

import BBCodeAPI.BBCBaseElement
import BBCodeAPI.BBCOrderedList
import BBCodeAPI.BBCUnorderedList
import BBCodeAPI.BBCodeObject

@BBCodeDsl
fun BBCodeObject.ol(builder: BBCOrderedList.() -> Unit) = content.add(BBCOrderedList().apply(builder))

@BBCodeDsl
fun BBCodeObject.ul(builder: BBCUnorderedList.() -> Unit) = content.add(BBCUnorderedList().apply(builder))

@BBCodeDsl
fun BBCOrderedList.item(builder: BBCBaseElement.() -> String) =
    items.add(BBCBaseElement().apply { content = builder(this) })

@BBCodeDsl
fun BBCUnorderedList.item(builder: BBCBaseElement.() -> String) =
    items.add(BBCBaseElement().apply { content = builder(this) })
