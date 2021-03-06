package hiro_JVM.codility_solution.Lesson7.Stacks_and_Queues

// you can also use imports, for example:
import java.util.*

object Nesting {
    fun solution_lesson7_2(S: String): Int {

        if (S.isEmpty())
            return 1
        else if (S.length % 2 == 1) return 0

        val st = Stack<Char>()

        for (i in 0 until S.length) {
            if (S[i] == '(') {
                st.push(')')
            } else if (S[i] == ')') {
                if (st.isEmpty()) {
                    return 0
                } else {
                    val temp = st.pop()
                    if (temp != ')') {
                        return 0
                    }
                }
            }
        }

        return if (!st.isEmpty())
            0
        else
            1
    }
}
