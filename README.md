
# 📦 Controle de Estoque - JavaFX

A simple yet elegant desktop application for inventory management, built with JavaFX. This project was developed as an assignment for the Object-Oriented Programming course at PUC Goiás, demonstrating key OOP concepts and the Model-View-Controller (MVC) architecture.

✨ Key Features

Product Visualization: Displays a list of products in a clean, organized table.

Detailed Information: Shows the name, price (R$), and quantity for each item.

Automated Calculation: Automatically calculates and displays the total value of all products in stock.

MVC Architecture: A well-structured codebase separating data (Model), UI (View), and logic (Controller).

# 📸 Screenshot
Here's a look at the application in action:

<img width="611" height="439" alt="image" src="https://github.com/user-attachments/assets/562c950c-3e6c-462e-b168-e9d9f37aa8ad" />


# 🛠️ Technologies Used
This project was built using:

Java: The core programming language.

JavaFX: The framework used for creating the modern graphical user interface.

Maven: For managing project dependencies and the build process.

FXML: For defining the user interface structure in an XML-based format.

# 🚀 How to Run This Project

To get this project running on your local machine, follow these steps.

### Prerequisites

Java Development Kit (JDK): Version 21 or higher.

JavaFX SDK: Version 21 or higher. Download here.

Apache Maven: Make sure it is installed and configured in your IDE.

An IDE like IntelliJ IDEA or Eclipse.

1. Clone the Repository

First, clone this repository to your local machine using Git:
git clone [https://github.com/your-username/ControleDeEstoque.git](https://github.com/your-username/ControleDeEstoque.git)
cd ControleDeEstoque


2. Open in Your IDE

Open the cloned folder as a new project in your IDE. It should automatically detect it as a Maven project and download the required dependencies.

3. Configure the Run Options (Important!)

Since JavaFX is no longer bundled with the JDK, you must tell your IDE where to find it.
Go to Run -> Edit Configurations....

Find the VM options field.

Paste the following line, replacing the path with the actual path to the lib folder of your JavaFX SDK:

--module-path "C:\path\to\your\javafx-sdk-21\lib" --add-modules javafx.controls,javafx.fxml

4. Run the Application

Now, you can run the Main.java file located in src/main/java/org/principal/.

### This project was created as part of the N1 evaluation for the CMP2108 course, taught by Professor Daniel Corrêa da Silva.

