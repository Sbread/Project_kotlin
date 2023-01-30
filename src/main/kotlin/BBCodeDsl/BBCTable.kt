package BBCodeDsl

import BBCodeAPI.BBCTable
import BBCodeAPI.BBCodeObject
import BBCodeAPI.Row

@BBCodeDsl
fun BBCodeObject.table(builder: BBCTable.() -> Unit) = content.add(BBCTable().apply(builder))

@BBCodeDsl
fun BBCTable.th(builder: Row.() -> Unit) {
    this.columnsNames = Row().apply(builder)
}

@BBCodeDsl
fun BBCTable.tr(builder: Row.() -> Unit) {
    this.rows.add(Row().apply(builder))
}

@BBCodeDsl
fun Row.item(builder: Row.() -> String) = cells.add(builder.invoke(this))
