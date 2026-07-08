# 🚀 100 Days of Jetpack Compose

Welcome to my daily tracking repository for learning **Jetpack Compose**! Here, I document my progress, key concepts learned, and code snippets as I build modern, declarative Android UIs every day.

---

## 📅 Daily Progress Log

### 🔹 Day 1: State Management Basics (`mutableStateOf` & `remember`)

Today, I dived into how state works in Jetpack Compose. Since Compose is declarative, it needs a way to know when data changes so it can redraw the UI (recomposition).

#### 💡 Key Concept Breakdown
* **`mutableStateOf(value)`**: Creates a observable `MutableState` holder. When its value changes, Compose automatically triggers a **recomposition** for any composable reading that value.
* **`remember { ... }`**: Guards your state against recomposition. Without `remember`, the state would reset back to its initial value every single time the function is redrawn.

> **Analogy:** Think of `mutableStateOf` as the whiteboard where the data is written, and `remember` as the memory that prevents Compose from erasing the whiteboard every time it blinks.

#### 🛠️ Code Snippet
Here is a simple counter example implementing both concepts:

```kotlin
@Composable
private fun TextFieldFunction() {
    val state = remember { mutableStateOf("") }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
            Log.d("12345", "TextFieldFunction: $it")
        },
        placeholder = { Text("Enter text") }
    )
}