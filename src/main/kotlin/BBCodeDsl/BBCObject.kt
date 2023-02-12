package BBCodeDsl

import BBCodeAPI.BBCodeObject

@BBCodeDsl
fun bbcobject(builder: BBCodeObject.() -> Unit) = BBCodeObject().apply(builder)

@Deprecated("Can't use bbcobject at this context", level = DeprecationLevel.ERROR)
fun BBCodeObject.bbcobject(builder: BBCodeObject.() -> Unit) {}
