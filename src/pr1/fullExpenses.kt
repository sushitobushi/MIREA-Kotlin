package pr1

class fullExpenses(
var list: MutableList<InfoExpenses>
) {


    fun printContacts(list: MutableList<InfoExpenses>) {
        for (i in list) {
            println("Сумма расхода - ${i.sum}₽\nКатегория - ${i.category}\nДата - ${i.date}\n")
        }
    }

    fun addNewExpenses(expenses: InfoExpenses) {
        list.add(expenses)
        //printContacts(list)
    }

    fun checkSum(list: MutableList<InfoExpenses>, word: String) {
        var sum = 0
        for (i in list) {
            if (i.category == word) {
                sum += i.sum
            }
        }
        println("Сумаа всех расходов по категории: '$word' = $sum₽")
    }
}