package ui

interface ButtonClickable {
    fun call(action: () -> Unit)
}