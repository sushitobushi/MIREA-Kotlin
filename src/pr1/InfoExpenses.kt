package pr1

class InfoExpenses(
    val sum: Int,
    val category: String,
    val date: String,
) {
    fun show(expenses: InfoExpenses) {
        println("Сумма расхода - ${expenses.sum}₽\nКатегория - ${expenses.category}\nДата - ${expenses.date}")
    }

}