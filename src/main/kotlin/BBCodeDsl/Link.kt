package BBCodeDsl

import BBCodeAPI.BBCodeObject
import BBCodeAPI.Link
import BBCodeAPI.Youtube

@BBCodeDsl
fun BBCodeObject.link(builder: Link.() -> String) {
    content.add(Link(builder))
}

@BBCodeDsl
fun BBCodeObject.youtube(builder: Youtube.() -> String) {
    content.add(Youtube(builder))
}
