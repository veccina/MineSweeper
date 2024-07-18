# Deutsch
# MineSweeper

Dieses Projekt implementiert das klassische Minesweeper-Spiel als konsolenbasierte Java-Anwendung. Der Benutzer gibt die Anzahl der Zeilen und Spalten an, um das Spiel zu starten, und versucht, alle sicheren Zellen aufzudecken, ohne auf Minen zu treten.

## Erste Schritte

Diese Anweisungen helfen Ihnen, das Projekt auf Ihrem lokalen Rechner in Betrieb zu nehmen.

### Voraussetzungen

- Java Development Kit (JDK) installiert. [Hier herunterladen](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- Eine IDE oder ein Texteditor (IntelliJ IDEA, Eclipse, VSCode, etc.)

### Installation

1. Klonen Sie das Repository auf Ihren lokalen Rechner:
    ```bash
    git clone
    ```

2. Navigieren Sie in das Projektverzeichnis:
    ```bash
    cd minesweeper
    ```

3. Führen Sie die `Main`-Klasse aus:
    - Wenn Sie eine IDE verwenden, öffnen und führen Sie die `Main`-Klasse aus.
    - Wenn Sie die Kommandozeile verwenden:
      ```bash
      javac Main.java MineSweeper.java
      java Main
      ```

## Nutzung

1. Wenn das Programm startet, geben Sie die Anzahl der Zeilen und Spalten ein.
2. Das Spielbrett wird erstellt und leere Zellen werden durch `-` dargestellt.
3. Geben Sie die Zeile und Spalte ein, um eine Zelle aufzudecken.
4. Wenn Sie auf eine Mine treten, ist das Spiel vorbei.
5. Wenn Sie alle sicheren Zellen aufdecken, gewinnen Sie das Spiel.

### Spielbrett

Zellen auf dem Spielbrett sind wie folgt dargestellt:
- `-`: Unentdeckte Zelle
- `0`: Zelle ohne Minen in der Umgebung
- `1-8`: Zelle mit der angegebenen Anzahl von Minen in der Umgebung
- `M`: Mine (wird angezeigt, wenn das Spiel vorbei ist)

## Verwendete Technologien

- **Java**: Die primäre Programmiersprache für das Projekt.
- **JDK**: Java Development Kit, verwendet zum Kompilieren und Ausführen von Java-Anwendungen.
- **IDE**: Integrierte Entwicklungsumgebungen wie IntelliJ IDEA, Eclipse, VSCode, etc., können zur Entwicklung des Projekts verwendet werden.

## Code-Beschreibung

### Main.java

Die `Main`-Klasse legt den Startpunkt des Spiels fest, fordert den Benutzer auf, die Anzahl der Zeilen und Spalten einzugeben, und verwendet die `MineSweeper`-Klasse, um das Spiel zu starten und zu spielen.

### MineSweeper.java

Die `MineSweeper`-Klasse verwaltet das Spielbrett und die Spiellogik:

- `initializeGame()`: Initialisiert das Spielbrett und die Minen.
- `placeMines()`: Platziert die Minen zufällig auf dem Brett.
- `displayBoard(char[][] board)`: Druckt das Spielbrett auf den Bildschirm.
- `playGame()`: Spielt das Spiel, fordert den Benutzer zur Eingabe von Zeilen und Spalten auf und überprüft das Spielergebnis.
- `uncoverCell(int row, int col)`: Deckt eine bestimmte Zelle auf und überprüft die umliegenden Zellen.
- `countMinesAround(int row, int col)`: Zählt die Minen um eine bestimmte Zelle herum.
- `isGameWon()`: Überprüft, ob das Spiel gewonnen wurde.

## Beitrag

Wenn Sie beitragen möchten, senden Sie bitte eine Pull-Anfrage oder öffnen Sie ein Issue.

-----------------------------------------------------------------------------------------------

#English
# MineSweeper

This project implements the classic Minesweeper game as a console-based Java application. The user specifies the number of rows and columns to start the game and tries to uncover all safe cells without stepping on any mines.

## Getting Started

These instructions will help you get the project up and running on your local machine.

### Prerequisites

- Java Development Kit (JDK) installed. [Download here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- An IDE or text editor (IntelliJ IDEA, Eclipse, VSCode, etc.)

### Installation

1. Clone the repository to your local machine:
    ```bash
    git clone
    ```

2. Navigate to the project directory:
    ```bash
    cd minesweeper
    ```

3. Run the `Main` class:
    - If using an IDE, open and run the `Main` class.
    - If using the command line:
      ```bash
      javac Main.java MineSweeper.java
      java Main
      ```

## Usage

1. When the program starts, enter the number of rows and columns.
2. The game board will be created, and empty cells will be represented by `-`.
3. Enter the row and column to uncover a cell.
4. If you hit a mine, the game is over.
5. If you uncover all safe cells, you win the game.

### Game Board

Cells on the game board are represented as follows:
- `-`: Uncovered cell
- `0`: Cell with no mines around it
- `1-8`: Cell with the specified number of mines around it
- `M`: Mine (revealed when the game is over)

## Technologies Used

- **Java**: The primary programming language for the project.
- **JDK**: Java Development Kit, used to compile and run Java applications.
- **IDE**: Integrated Development Environments like IntelliJ IDEA, Eclipse, VSCode, etc., can be used to develop the project.

## Code Description

### Main.java

The `Main` class sets the starting point of the game, prompts the user to enter the number of rows and columns, and uses the `MineSweeper` class to start and play the game.

### MineSweeper.java

The `MineSweeper` class manages the game board and the game logic:

- `initializeGame()`: Initializes the game board and mines.
- `placeMines()`: Places mines randomly on the board.
- `displayBoard(char[][] board)`: Prints the game board to the screen.
- `playGame()`: Plays the game, prompts the user for row and column input, and checks the game result.
- `uncoverCell(int row, int col)`: Uncovers a specified cell and checks the surrounding cells.
- `countMinesAround(int row, int col)`: Counts the mines around a specified cell.
- `isGameWon()`: Checks if the game is won.

## Contributing

If you want to contribute, please send a pull request or open an issue.
