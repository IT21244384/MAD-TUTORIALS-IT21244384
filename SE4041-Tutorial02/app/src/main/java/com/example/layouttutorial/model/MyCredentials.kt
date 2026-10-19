package com.example.layouttutorial.model

/**
 * Classroom demo only: keeps the registered account in memory for the life of
 * the app process. NOT secure and NOT persistent - never store real passwords
 * like this.
 */
object MyCredentials {
    var username: String = ""
    var email: String = ""
    private var password: String = ""

    fun setPassword(password: String, rePassword: String): Boolean {
        if (password.isBlank() || password != rePassword) {
            return false
        }

        this.password = password
        return true
    }

    fun matchesPassword(candidate: String): Boolean {
        return password == candidate
    }

    fun clear() {
        username = ""
        email = ""
        password = ""
    }
}
