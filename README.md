# ASPIS

Overview of project: This project created with using Selenium JAVA with Paga Object Model(POM) Freamwork and TestNG as well. As requrested in Assignment document, It covered the following functionalites on the DemoBlaze website:
1) Login page
2) Adding a product to the cart
3) Place a order
4) Checking the order confirmation
5) Log out

Project Structure:
-> base/BaseTest.java
    -  Set up Webdriver, before each test, initializes the driver, maximizes the window, and applies a default implicit wait.
    -  After each test, quits the driver if it’s not null.

-> pages/LoginPage.java
    - It have Locators and methods for login process.
    - The logic methods combines those actions to perform the login process.

-> pages/Addtocart.java
    - select particular item and add to cart
    - with method to accept javascript pop up aleart and add product to cart

-> pages/CartPage.java
    - Here we open cart, check product name, place order, check confirm message and log out

-> tests/LoginTest.java
    - Check login flow such as navigate website, loging with creditials and assert welcome message

-> tests/AddToCartTest.java
    - Here we tested add to cart by adding product and verify product added succesfully or not

-> tests/CartTest.java
    - Here we tested from Log in to add product, go to cart and check product to place order successful with log out functionality, full end to end key flow.






