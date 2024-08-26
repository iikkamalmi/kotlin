class Major(val name: String) {
    val students = ArrayList<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun stats(): Triple<Double, Double, Double> {
        val averages = students.map { it.weightedAverage() }
        return if (averages.isNotEmpty()) {
            Triple(
                averages.minOrNull()!!,
                averages.maxOrNull()!!,
                averages.average()
            )
        } else {
            Triple(0.0, 0.0, 0.0)
        }
    }
    fun stats(courseName: String): Triple<Double, Double, Double> {
        val courseAverages = students.map { student ->
            student.courses.filter { it.name == courseName }
                .let { filteredCourses ->
                    if (filteredCourses.isNotEmpty()) {
                        student.weightedAverage()
                    } else {
                        0.0
                    }
                }
        }

        val filteredAverages = courseAverages.filter { it > 0.0 }
        return if (filteredAverages.isNotEmpty()) {
            Triple(filteredAverages.minOrNull()!!, filteredAverages.maxOrNull()!!, filteredAverages.average())
        } else {
            Triple(0.0, 0.0, 0.0)
        }
    }

}

