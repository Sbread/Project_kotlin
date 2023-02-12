package BBCodeDsl

import BBCodeAPI.BBCodeObject
import BBCodeAPI.Image

@BBCodeDsl
fun BBCodeObject.image(builder: Image.() -> String) {
    content.add(Image(builder))
}
