class Student(name: String, age: Int) : Human(name, age){
    val courses = ArrayList<CourseRecord>()

    fun addCourse(course: CourseRecord) {
        courses.add(course)
    }

    fun weightedAverage(): Double {
        val sum = courses.map { it.grade * it.credits }.sum()
        val totalCredits = courses.map { it.credits }.sum()
        return sum / totalCredits
    }

    fun weightedAverage(year: Int): Double {
        val sum = courses.filter { it.yearCompleted == year }.map { it.grade * it.credits }.sum()
        val totalCredits = courses.filter { it.yearCompleted == year }.map { it.credits }.sum()
        return sum / totalCredits
    }

    fun minMaxGrades(): Pair<Double, Double> {
        val min = courses.map { it.grade }.minOrNull() ?: 0.0
        val max = courses.map { it.grade }.maxOrNull() ?: 0.0
        return Pair(min, max)
    }
}
