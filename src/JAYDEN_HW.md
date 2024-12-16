
# Elemental Clash Lite

**Elemental Clash Lite** is a 2D side-view fighting game built with Python's Pygame library. Players control fighters with unique elemental powers in exciting battles within interactive arenas. The game features local multiplayer and single-player story modes.

## Future Improvements (Homework)
- Players must be bounded to the screen, use `if-statement` to do it.
- Key down of `s` and `d` are duplicated with player 1's action, identify the bug and fix it. (`if-statement`)
- AI towards the right, not left, fix it by using mathematical concept, a transformation `reflection over y-axis`.
- Use `for-loop`, to randomly generate some obstacles in the arena.
- [extra] AI opponents in single-player mode.

## Features

### Gameplay Mechanics
- **Health System**: Each character starts with 100 HP.
- **Basic Attacks**: Perform punches and combine them with special moves for combos.
- **Special Moves**: Each fighter has two unique elemental abilities, such as fireballs or healing waves.
- **Interactive Arenas**: Fixed environments with potential hazards and effects.

### Game Modes
- **Story Mode**: A single-player campaign against 5 predefined enemies, culminating in a final boss fight.
- **Multiplayer Mode**: A local 2-player mode using the keyboard or two controllers.

## Controls

### Player 1
- **Movement**: Arrow keys (← →).
- **Jump**: Up Arrow (↑).
- **Basic Attack**: Space.
- **Special Move 1**: S.
- **Special Move 2**: D.

### Player 2
- **Movement**: WASD (A/D for left/right).
- **Jump**: W.
- **Basic Attack**: F.
- **Special Move 1**: G.
- **Special Move 2**: H.