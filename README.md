# WitherStick

A lightweight Minecraft plugin for Paper servers that allows players to shoot wither skulls using a customizable "Wither Wand" stick.

## Features

- **Wither Skull Launcher**: Right-click with the Wither Wand to launch configurable wither skulls.
- **Highly Configurable**: Customize cooldown, velocity, sound effects, item properties, and messages.
- **Permission System**: Restrict usage with the `witherstick.use` permission.
- **Optimized Performance**: Efficient event handling and minimal resource usage.
- **Paper-Specific**: Built with Paper API for enhanced features and performance.

## Requirements

- **Server**: Paper 1.21.1+ (tested with 1.21.1; compatible with 1.21.x)
- **Java**: Java 22
- **Dependencies**: None (all included via Paper)

## Installation

1. Download the latest `witherstick-1.0.0.jar` from the [Releases](https://github.com/4K1D3V/WitherStick/releases) page.
2. Place the JAR file in your Paper server's `plugins` folder.
3. Restart your server or use a plugin manager to load it.

## Usage

### Commands
- `/witherstick` - Gives the player a Wither Wand.
  - **Permission**: `witherstick.use` (default: op-only)
  - **Description**: Grants the player the special stick to shoot wither skulls.

### How to Use
1. Run `/witherstick` to receive the Wither Wand.
2. Right-click while holding the Wither Wand to launch a wither skull.
3. Configure settings in `config.yml` to customize the experience.

## Configuration

The plugin generates a `config.yml` file in `plugins/WitherStick/` on first run. Below is the default configuration:

```yaml
cooldown-ticks: 60
skull-velocity: 1.5
wither-stick-name: "§5Wither Wand"
custom-model-data: 1001
unbreakable: false
charged-skull: false
sound-enabled: true
sound-effect: "entity.wither.shoot"
sound-volume: 1.0
sound-pitch: 1.0

messages:
  no-player: "§cThis command can only be used by players!"
  no-permission: "§cYou don't have permission to use this!"
  received: "§aYou received a Wither Wand!"
  cooldown: "§cWither Wand is on cooldown!"
  launched: "§dWither Skull launched!"
  error: "§cError launching wither skull!"
```

### Configuration Options
- `cooldown-ticks`: Cooldown between shots (in ticks, 20 ticks = 1 second).
- `skull-velocity`: Speed multiplier for launched skulls.
- `wither-stick-name`: Display name of the Wither Wand (supports § color codes).
- `custom-model-data`: Custom model data for resource pack support.
- `unbreakable`: Whether the Wither Wand is unbreakable.
- `charged-skull`: If true, launches charged (blue) wither skulls.
- `sound-enabled`: Enable/disable sound effects.
- `sound-effect`: Sound to play when shooting (e.g., `entity.wither.shoot`).
- `sound-volume`: Volume of the sound (0.0 to 1.0).
- `sound-pitch`: Pitch of the sound (0.5 to 2.0).
- `messages`: Customizable chat messages with § color code support.

## Permissions

- `witherstick.use`:
    - **Description**: Allows players to use the `/witherstick` command and shoot wither skulls.
    - **Default**: op-only

## Building from Source

### Prerequisites
- Java 22 JDK
- Maven 3.6+

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/4K1D3V/WitherStick.git
   cd WitherStick
   ```
2. Build the plugin:
   ```bash
   mvn clean package
   ```
3. Find the compiled JAR in `target/witherstick-1.0.0.jar`.

## Contributing

Contributions are welcome! Feel free to:
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m "Add your feature"`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

Please ensure your code follows the existing style and includes appropriate tests if applicable.

## Issues

Found a bug? Have a suggestion? Please open an issue on the [Issues](https://github.com/4K1D3V/WitherStick/issues) page.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Credits

- **Author**: KiteGG
- **Built with**: Paper API, Maven, Java 22
