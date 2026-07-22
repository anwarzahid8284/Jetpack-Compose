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
```

### 🔹 Day 2: Layout Basics (`Column`, `Row`, `Box`) & Positioning

Today, I learned how to structure layouts in Jetpack Compose using the three core layout composables: **Column**, **Row**, and **Box**. I also explored how to position items inside them using **Arrangement** and **Alignment**.

---

## 📐 The Big Three Layouts

| Layout | Direction | Description |
| :--- | :--- | :--- |
| **`Column`** | ⬇️ Vertical | Stacks items sequentially from top to bottom. |
| **`Row`** | ➡️ Horizontal | Places items sequentially from left to right. |
| **`Box`** | 🔲 Z-Axis (Stacked) | Stacks items on top of each other (like layers). Useful for overlays. |
---

## 🔀 Arrangement vs. Alignment

It is easy to mix these up! Here is the golden rule to remember:
* **Arrangement:** Controls how items are spaced out along the **Main Axis** (the direction the layout moves).
* **Alignment:** Controls how items are positioned along the **Cross Axis** (the perpendicular direction).

### 1. Column Positioning
* **Main Axis (Vertical):** Controlled by `verticalArrangement` (e.g., `Arrangement.SpaceEvenly`, `Arrangement.Center`).
* **Cross Axis (Horizontal):** Controlled by `horizontalAlignment` (e.g., `Alignment.CenterHorizontally`, `Alignment.Start`).

### 2. Row Positioning
* **Main Axis (Horizontal):** Controlled by `horizontalArrangement` (e.g., `Arrangement.SpaceEvenly`, `Arrangement.End`).
* **Cross Axis (Vertical):** Controlled by `verticalAlignment` (e.g., `Alignment.CenterVertically`, `Alignment.Top`).

---

## 🛠️ Code Snippets & Implementation

### 🏙️ Column & Row Arrangements
Here is how `Column` and `Row` distribute elements evenly using `SpaceEvenly`:

```kotlin
@Composable
private fun ColumnViewFunction() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("A", fontSize = 40.sp)
        Text("B", fontSize = 40.sp)
    }
}

@Composable
private fun RowViewFunction() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("A", fontSize = 40.sp)
        Text("B", fontSize = 40.sp)
    }
}
```

### 🔹 Day 3: Displaying Lists (`Column` vs. `LazyColumn`)

Today, I explored how to display lists of items in Jetpack Compose. I compared using a standard `Column` with vertical scrolling against using a `LazyColumn` for dynamic data.

---

## 🆚 Column vs. LazyColumn: The Core Difference

When handling lists, performance is everything. Here is how they stack up:

| Feature | `Column` + `verticalScroll` | `LazyColumn` |
| :--- | :--- | :--- |
| **Android XML Equivalent** | Like a standard `ScrollView` / `ListView` | Like a **`RecyclerView`** |
| **Rendering Behavior** | Renders **all** list elements immediately, even if they are off-screen. | Renders **only** the items currently visible on the screen. |
| **Performance** | Poor for large lists (causes lag and high memory usage). | Excellent for large or infinite lists (recycles views efficiently). |
| **Best Used For** | Small, fixed sets of items (e.g., settings screens). | Large, dynamic, or unpredictable datasets (e.g., feeds, item logs). |

---



## 🛠️ Code Snippet & Implementation

Inside Compose, `LazyColumn` exposes a `LazyListScope` DSL, using functions like `items()` to dynamically load data instead of standard Kotlin loops like `forEach`.

```kotlin
@Preview(heightDp = 500, widthDp = 300)
@Composable
fun PreviewItem() {
    
    // 💡 OPTION 1: LazyColumn (Best Practice for dynamic lists - Recycler View equivalent)
    LazyColumn {
        items(getBlogList()) { blog ->
            BlogCategory(blog.img, blog.title, blog.description)
        }
    }

    /* // ⚠️ OPTION 2: Column + ScrollState (Not ideal for large lists - ScrollView equivalent)
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        getBlogList().forEach { blog ->
            BlogCategory(blog.img, blog.title, blog.description)
        }
    }
    */
}
```

### 🔹 Day 4: State Management Part 2 (State Hoisting & Unidirectional Data Flow)

Today, I took state management a step further by learning **State Hoisting**, **Unidirectional Data Flow (UDF)**, and the difference between `remember` and `rememberSaveable`.

---

## 🔄 Core Concepts

### 1. Unidirectional Data Flow (UDF)
In Jetpack Compose, data flows down, and events flow up:
* **Data (State) flows down:** Parent composables pass values down to child composables.
* **Events flow up:** Child composables notify the parent when an action occurs (e.g., button click) via lambdas.

### 2. State Hoisting
State hoisting is the pattern of moving state to a caller (parent) to make a composable **stateless**.
* **Stateless composables** are easier to test, reuse, and maintain because they don't manage their own internal state.

### 3. `remember` vs `rememberSaveable`
* **`remember`:** Survives recomposition, but **loses state on screen rotation** or configuration changes.
* **`rememberSaveable`:** Survives both recomposition **and configuration changes** (like screen rotation) by saving state in a `Bundle`.

---

## 🛠️ Code Snippet & Implementation

In this example, `PreviewFunction` holds (hoists) the state and passes `counter.value` down to `NotificationCounter` and `MessageBar`. When the button inside `NotificationCounter` is clicked, an event is sent back up to update the count.

```kotlin
@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun PreviewFunction() {
    // 💡 Using rememberSaveable so state survives screen rotation!
    val counter: MutableState<Int> = rememberSaveable { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // State flows down (counter.value), event flows up (lambda update)
            NotificationCounter(
                count = counter.value,
                onIncrement = { counter.value++ }
            )
            
            // Reuses the same hoisted state
            MessageBar(count = counter.value)
        }
    }
}