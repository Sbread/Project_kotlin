package BBCodeAPI

import BBCodeDsl.BBCodeDsl

@BBCodeDsl
class Row : BBCElementInterface {
    val cells = ArrayList<String>()
    override fun toString(): String {
        return buildString {
            append("| ")
            cells.forEach { append("$it | ") }
            append("\n")
        }
    }
}

@BBCodeDsl
class BBCTable : BBCTableInterface {
    var columnsNames: Row = Row()
    val rows = ArrayList<Row>()
    override fun toString(): String {
        return buildString {
            append(columnsNames.toString())
            rows.forEach { append(it.toString()) }
        }
    }
}
