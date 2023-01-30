package BBCodeDsl

import BBCodeAPI.BBCodeObject

@BBCodeDsl
fun bbcobject(builder: BBCodeObject.() -> Unit) = BBCodeObject().apply(builder)

