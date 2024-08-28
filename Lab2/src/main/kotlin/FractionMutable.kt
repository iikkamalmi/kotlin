class FractionMutable(var numerator: Int, var denominator: Int, sign: Int = 1) {

    init {
        require(denominator != 0) { "Denominator cannot be zero" }
        require(sign == 1 || sign == -1) { "Sign must be 1 or -1" }

        if (denominator < 0) {
            denominator = -denominator
            numerator = -numerator
        }

        this.numerator *= sign
        normalize()
    }

    private fun normalize() {
        val gcd = gcd(Math.abs(numerator), denominator)
        numerator /= gcd
        denominator /= gcd
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    fun negate() {
        numerator = -numerator
    }

    fun add(other: FractionMutable) {
        numerator = numerator * other.denominator + other.numerator * denominator
        denominator *= other.denominator
        normalize()
    }

    fun mult(other: FractionMutable) {
        numerator *= other.numerator
        denominator *= other.denominator
        normalize()
    }

    fun div(other: FractionMutable) {
        require(other.numerator != 0) { "Cannot divide by zero" }
        numerator *= other.denominator
        denominator *= other.numerator
        if (denominator < 0) {
            denominator = -denominator
            numerator = -numerator
        }
        normalize()
    }

    override fun toString(): String {
        return if (numerator == 0) "0" else "$numerator/$denominator"
    }

    fun intPart(): Int {
        return numerator / denominator
    }
}
