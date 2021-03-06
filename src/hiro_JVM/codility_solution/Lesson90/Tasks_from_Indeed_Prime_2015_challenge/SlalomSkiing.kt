package hiro_JVM.codility_solution.Lesson90.Tasks_from_Indeed_Prime_2015_challenge

import java.util.*

object SlalomSkiing {
    fun solution_lesson90_3(A: IntArray): Int {
        var i = 0
        val n = A.size
        var `val`: Int
        var max: Long = 0
        val b = LongArray(3 * n)

        while (i < n) {
            max = Math.max(max, A[i].toLong())
            i++
        }

        max++

        i = 0
        while (i < n) {
            `val` = A[i]
            b[3 * i] = 2 * max + `val`
            b[3 * i + 1] = 2 * max - `val`
            b[3 * i + 2] = `val`.toLong()
            i++
        }

        return findMaxIncreasingSequence(b)
    }

    private fun findMaxIncreasingSequence(a: LongArray): Int {
        var i = 0
        val n = a.size
        var index: Int
        var `val`: Long
        val maxIncreasing = ArrayList<Long>(n)

        while (i < n) {
            `val` = a[i]
            index = Collections.binarySearch(maxIncreasing, `val`)
            if (index < 0) index = index.inv()

            if (index == maxIncreasing.size)
                maxIncreasing.add(`val`)
            else
                maxIncreasing[index] = `val`
            i++
        }

        return maxIncreasing.size
    }
}
