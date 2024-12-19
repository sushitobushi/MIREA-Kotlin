package pr1

fun main() {
    val expenses1: InfoExpenses = InfoExpenses(
        sum = 1000,
        category = "Развлечение",
        date = "24.09.2024"
    )

    val expenses2: InfoExpenses = InfoExpenses(
        sum = 1500,
        category = "Развлечение",
        date = "26.09.2024"
    )

    val expenses3: InfoExpenses = InfoExpenses(
        sum = 300,
        category = "Развлечение",
        date = "26.09.2024"
    )

    val expensesNone = InfoExpenses (
        sum = 0,
        category = "none",
        date = "none"
    )

    val expensesPrime: fullExpenses = fullExpenses(
        list = mutableListOf(expensesNone)
    )

    expensesPrime.addNewExpenses(expenses1)
    expensesPrime.addNewExpenses(expenses2)
    expensesPrime.addNewExpenses(expenses3)
    //expensesPrime.printContacts(expensesPrime.list)
    expensesPrime.checkSum(expensesPrime.list, "Развлечение")

}