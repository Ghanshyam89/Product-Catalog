# Product Catalog Application (Java + Angular)

The application is a product search platform that allows users to register, log in, and search for products. It provides search functionality, displays search results, and allows users to view product details. Registered users have additional features such as viewing prices, filtering products, and checking product serviceability based on their location.

## Features
1. Homepage
- Landing page with links for Registration and Login.
- Search box for customers to search for products.
![Home Page](./screenshots/Screenshot%202023-06-13%20100704.png)
![Search Box Page](./screenshots/Screenshot%202023-06-13%20101308.png)

2. Login Page
- User authentication and login functionality.
- Proper error handling for invalid authentication.
![Login Page](./screenshots/Screenshot%202023-06-13%20101511.png)
![Login Page](./screenshots/Screenshot%202023-06-13%20104856.png)

3. Registration Page
- User registration functionality.
- Validation for email address, password policy, and mandatory fields.
![Register Page](./screenshots/Screenshot%202023-06-13%20101533.png)

4. Product Search Page
- Search screen for users to search for products.
- Searches input text against specified parameters for matching products.
![Product Search Page](./screenshots/Screenshot%202023-06-13%20101426.png)

5. Results Page
- Displays search results using the API from the first application.
- Shows product image, name, and brand.
- Allows users to filter products by brand.

![Result Page](./screenshots/Screenshot%202023-06-13%20101135.png)
![Result Page](./screenshots/Screenshot%202023-06-13%20101232.png)

- Additional functionality for logged-in users:
    - View prices of products in search results.
    - Click on "View Details" link for each product.
    - Filter products by price range.
- Provides error messages if no results are found.
![Result Page](./screenshots/Screenshot%202023-06-13%20101557.png)

6. Product Details Page
- Detailed view of a selected product.
- Shows product image, name, description, brand, price, and serviceability check.
- Serviceability check allows logged-in users to enter their pincode and receive information on product delivery feasibility and expected delivery time.
![Product Details Page](./screenshots/Screenshot%202023-06-13%20101619.png)
![Product Details Page](./screenshots/Screenshot%202023-06-13%20101640.png)
![Product Details Page](./screenshots/Screenshot%202023-06-13%20101701.png)