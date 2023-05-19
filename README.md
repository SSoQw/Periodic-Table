# Interactive Java/JavaFX Periodic Table

This repository contains an interactive Java/JavaFX based periodic table application. The application allows users to explore and interact with the elements of the periodic table.

<p align="center">
  <img width="800" height="475" src="https://i.imgur.com/Y8KxuXn.png">
</p>

## Features

- Display of the entire periodic table with element symbols, atomic numbers, and element categories.
- Interactive elements: users can click on an element to view detailed information.
- Detailed information: users can access comprehensive information about each element, including atomic mass, electron configuration, and physical properties.
- Color-coded element categories: elements are color-coded based on their categories, making it easier to identify them.
- User-friendly interface: the application provides a simple and intuitive user interface for seamless navigation and exploration.

## Installation

1. Clone the repository to your local machine using the following command:

```GIT 
 git clone https://github.com/your-username/periodic-table.git
```

2. Ensure that you have Java Development Kit installed on your machinem as well as the [JavaFX](https://openjfx.io/) library. 

3. Open the project in your preferred IDE.

4. Add JavaFX moudles to your VM arguments.   

In [IntelliJ IDEA](https://www.jetbrains.com/idea/) you can do this by right-clicking the ``PeriodicTable.java`` tab, going to the ``More Run/Debug submenu``, and clicking ``Modify Run Configuration...``

<p align="center">
  <img width="800" height="500" src="https://i.imgur.com/NjV9q9g.png">
</p>

Once the Edit Run Configuration window is open, you can either hit ``Alt+V`` or selecting ``Add VM options`` from the ``Modify options`` menu

<p align="center">
  <img width="800" height="510" src="https://i.imgur.com/xbDixtd.png">
</p>

Then add the following options, ensure that you change ``module-path`` to the appropriate directory.

```
--module-path "C:\path\to\javafx-sdk-version\lib" --add-modules=javafx.base,javafx.controls,javafx.graphics
```

5. Build and compile the project.

## Usage

1. Run the application by executing the compiled Java file. (WIP)

2. The periodic table will be displayed, allowing you to explore the elements.

3. Click on an element to view its detailed information.

## Contributing

Contributions are welcome! If you would like to contribute to this project, please follow these steps:

1. Fork the repository.

2. Create a new branch for your feature or bug fix.

3. Make your changes and ensure they are well-documented and tested.

4. Commit and push your changes to your forked repository.

5. Submit a pull request, describing the changes you have made.

## License

This project is licensed under the [MIT License](LICENSE). You are free to use, modify, and distribute the code for personal and commercial purposes.

## Acknowledgments

- The periodic table data used in this application is sourced from [Wikipedia](https://www.wikipedia.org/).
- Inspiration and guidance from various open-source periodic table projects.

## Contriubters

- LeBlanc, Reilly
- Sanderson, Elijah
