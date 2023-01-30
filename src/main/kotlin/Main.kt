import BBCodeDsl.*

fun main() {
    val bbc = bbcobject {
        b { "text" }
        i { "text" }
        t { "text" }
        s { "text" }
        u { "text" }
        code { "text" }
        q { "text" }
        link { "https://www.reddit.com" }
        youtube { "E7d-3-uXlZM" }
        image { "panda.png" }
        table {
            th { item { "Country" }; item { "Capital" } }
            tr { item { "Russia" }; item { "Moscow" } }
            tr { item { "Japan" }; item { "Tokio" } }
        }
        ol {
            item { "first" }
            item { "second" }
            item { "third" }
        }
        ul {
            item { "first" }
            item { "second" }
            item { "third" }
        }
    }
    println(bbc)
}
