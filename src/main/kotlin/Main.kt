import java.lang.Thread.sleep

const val AFFIRMATIVE_ANSWER = "AFFIRMATIVE"
const val NEGATIVE_ANSWER = "NEGATIVE"
const val DOUBTFUL_ANSWER = "DOUBTFUL"

val answers = mapOf(
    "Yes" to AFFIRMATIVE_ANSWER,
    "It's true" to AFFIRMATIVE_ANSWER,
    "Totally" to AFFIRMATIVE_ANSWER,
    "Undoubtedly" to AFFIRMATIVE_ANSWER,
    "Ask in an other moment" to DOUBTFUL_ANSWER,
    "I can't say you in this moment" to DOUBTFUL_ANSWER,
    "Maybe yes, or maybe not" to DOUBTFUL_ANSWER,
    "It's not going to happen" to NEGATIVE_ANSWER,
    "Do not count on it" to NEGATIVE_ANSWER,
    "Definitely not" to NEGATIVE_ANSWER,
    "I don't believe it" to NEGATIVE_ANSWER
)

fun main(args: Array<String>) {
    println("This is a magic ball created with Kotlin. Select an option.")
    println("1. Ask a question")
    println("2. Show all answers")
    println("3. Exit")
    val userValue = readLine();
    when (userValue) {
        "1" -> askAQuestion()
        "2" -> showAnswers()
        "3" -> exit()
        else -> showError()
    }
}

fun askAQuestion() {
    println("What is your question? ⚆ _ ⚆")
    readLine();
    println("Interesting question... ")
    sleep(1000)
    println("Visualizing...")
    sleep(1000)
    val answer = answers.keys.random()
    println(answer)
}

fun showAnswers() {
    println("Select an option")
    println("1. Show all answers")
    println("2. Show affirmative answers")
    println("3. Show negative answers")
    println("4. Show doubtful answers")
    val input = readLine();
    when (input) {
        "1" -> showAnswersByType()
        "2" -> showAnswersByType(answerType = AFFIRMATIVE_ANSWER)
        "3" -> showAnswersByType(answerType = NEGATIVE_ANSWER)
        "4" -> showAnswersByType(answerType = DOUBTFUL_ANSWER)
        else -> println("Invalid answer, bye...")
    }
}

fun showAnswersByType(answerType : String = "ALL") {
    when(answerType) {
        "ALL" -> answers.keys.forEach { println(it) }
        AFFIRMATIVE_ANSWER -> answers.filterValues { it == AFFIRMATIVE_ANSWER }.also { affirmativeAnswers -> println(affirmativeAnswers.keys) }
        NEGATIVE_ANSWER -> answers.filterValues { it == NEGATIVE_ANSWER }.also { negativeAnswers -> println(negativeAnswers.keys) }
        DOUBTFUL_ANSWER -> answers.filterValues { it == DOUBTFUL_ANSWER }.also { doubtfulAnswers -> println(doubtfulAnswers.keys) }
    }
}

fun exit() {
    println("Bye...")
}

fun showError() {
    println("Incorrect option :/")
}