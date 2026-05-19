🧭 MazeSafetyPlanner — Intelligent Maze Pathfinding & Safety Planning (Java)

A Java-based intelligent maze planning system that visualizes grids, hazards, and optimal safe paths using AI-based logic and classic pathfinding algorithms.
The project includes a graphical UI, a maze builder engine, and efficient pathfinding (A* with Manhattan heuristic), making it ideal for simulations, AI demonstrations, and safety-planning research.

🚀 Key Features
🧱 Maze Builder

Customizable grid

Dynamic cell editing

Multiple tile types (walls, empty, hazard, goal, start)

🤖 AI & Algorithms

A* Pathfinding implementation

Manhattan Distance Heuristic

Tile-type prioritization

Intelligent safety evaluation

🗺️ Safety Planning

Detect hazards

Compute safest path

Avoid unsafe zones

Visual feedback in the GUI

🖥️ Graphical User Interface

Full Java Swing GUI

Click-to-edit maze tiles

Buttons to generate & solve maze

Real-time result visualization

🧩 Modular & Scalable Design

Clear separation:

model → Maze structure

ai → safety + logic

pathfinding → A* algorithm

ui → graphical interface

utils → heuristics & helpers

📁 Project Structure
MazeSafetyPlanner/
 ├── src/
 │   ├── ai/                # Intelligent hazard & safety logic
 │   ├── main/              # Main application entry point
 │   │   └── Main.java
 │   ├── model/             # MazeBuilder, Tiles, Types
 │   │   ├── MazeBuilder.java
 │   │   ├── Tile.java
 │   │   └── TileType.java
 │   ├── pathfinding/       # A* Algorithm
 │   │   └── AStar.java
 │   ├── ui/                # Graphical Interface
 │   │   └── MazeGUI.java
 │   └── utils/             # Manhattan heuristic, helpers
 │       └── Manhattan.java
 ├── bin/
 └── README.md

🧠 Algorithms & AI
⭐ A* Pathfinding

The algorithm used to find the optimal path from start → goal.

Priority = g(n) + h(n)

g(n) = cost from start

h(n) = Manhattan Distance heuristic

⭐ Manhattan Heuristic

Perfect for grid environments:

h(n) = |x1 - x2| + |y1 - y2|

⭐ Safety Logic

Maze tiles are classified:

Safe

Unsafe

Hazard

Wall

The planner avoids:

Dangerous areas

Impassable walls

Dead ends

🖥️ GUI Features

Grid visualization

Color-coded tiles

Buttons:

Build Maze

Mark Hazard

Run A*

Clear Grid

Animated solution rendering

Error handling for invalid mazes

▶️ How to Run Locally
1️⃣ Clone the Repository
git clone https://github.com/Abo-AL-Yaseen/MazeSafetyPlanner

2️⃣ Open in any Java IDE

Recommended:

IntelliJ IDEA

Eclipse

VSCode (Java Extensions)

3️⃣ Build & Run

Run the file:

src/main/Main.java

4️⃣ GUI will launch automatically

Start editing the maze and run the AI solver!

🖼️ Screenshots (Optional)
Feature	Preview
Maze UI	(screenshot here)
Hazard Placement	(screenshot here)
A* Solution Path	(screenshot here)


🔮 Future Improvements

Add BFS, DFS, Dijkstra

Add heatmaps for hazard levels

Animated step-by-step A* visualization

Saving/loading maze configurations

Export solution reports

Smarter AI using weighted risks

👨‍💻 Developer

Mahmoud Yaseen
Computer Engineering Student @ An-Najah University
AI enthusiast, problem solver, and software developer.
Passionate about algorithms, optimization, and intelligent systems.
