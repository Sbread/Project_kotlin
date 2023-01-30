package BBCodeDsl

import BBCodeAPI.*

@BBCodeDsl
fun BBCodeObject.b(builder: BoldText.() -> String) {
    content.add(BoldText(builder))
}

@BBCodeDsl
fun BBCodeObject.i(builder: ItalianText.() -> String) {
    content.add(ItalianText(builder))
}

@BBCodeDsl
fun BBCodeObject.t(builder: DefaultText.() -> String) {
    content.add(DefaultText(builder))
}

@BBCodeDsl
fun BBCodeObject.s(builder: StrikethroughText.() -> String) {
    content.add(StrikethroughText(builder))
}

@BBCodeDsl
fun BBCodeObject.u(builder: UnderlineText.() -> String) {
    content.add(UnderlineText(builder))
}

@BBCodeDsl
fun BBCodeObject.code(builder: CodeText.() -> String) {
    content.add(CodeText(builder))
}

@BBCodeDsl
fun BBCodeObject.q(builder: QuoteText.() -> String) {
    content.add(QuoteText(builder))
}
