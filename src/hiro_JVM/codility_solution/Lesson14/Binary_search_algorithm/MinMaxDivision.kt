package hiro_JVM.codility_solution.Lesson14.Binary_search_algorithm

object MinMaxDivision {
    fun solution_lesson14_1(K: Int, M: Int, A: IntArray): Int {
        var minSum = 0
        var maxSum = 0

        for (aA in A) {
            maxSum += aA
            minSum = Math.max(minSum, aA)
        }

        var possibleResult = maxSum

        while (minSum <= maxSum) {

            val midSum = (minSum + maxSum) / 2

            val ok = checkDivisable(midSum, K, A)

            if (ok) {
                possibleResult = midSum
                maxSum = midSum - 1
            } else {
                minSum = midSum + 1
            }
        }

        return possibleResult
    }

    private fun checkDivisable(mid: Int, k: Int, a: IntArray): Boolean {
        var numBlockAllowed = k
        var currentBlockSum = 0

        for (anA in a) {
            currentBlockSum += anA

            if (currentBlockSum > mid) {
                numBlockAllowed--
                currentBlockSum = anA
            }

            if (numBlockAllowed == 0) {
                return false
            }
        }
        return true
    }
}
