# final_project

**Final project tasks**

1. All following test cases should be implemented with BDD using Page Object pattern
2. Logging and Reporting should be implemented
3. Should be abillity to run tests in 2 threads
4. Should be ability to pass browser, browser resolution, and thread count as parameters
5. All logical blocks on pages should be implemented as separate classes


**Test case #1 (Subscribe with invalid email)**
1. Go to the https://demo.prestashop.com/
2. On the buttom of the page fill 'Get our latest news and special sales' field with invalid email (like tttt@ttt)
3. Click on 'Subscribe' button
4. Check that 'Invalid email address.' appear


**Test case #2 (Check languages)**
1. Go to the https://demo.prestashop.com/
2. Check that 44 langueges exists in 'Language' dropdown in the top menu
3. Check that 'Українська' language exist in dropdown


**Test case #3 (Registration with valid data)**
1. Go to the https://demo.prestashop.com/
2. Click on 'Sign in' button at the right corner of the page
3. Click on 'No account? Create one here' link
4. Fill the form with valid data
5. Click on 'Save' button
6. Check your name appear near cart button


**Test case #4 (Registration with invalid data)**
1. Go to the https://demo.prestashop.com/
2. Click on 'Sign in' button at the right corner of the page
3. Click on 'No account? Create one here' link
4. Fill 'First name' field with 'James8'
5. Fill the rest fields valid data
6. Check that 'First name' higlighted in red
7. Check that pop-up with text 'Invalid name' appear under field


**Test case #5 (Check categories)**
1. Go to the https://demo.prestashop.com/
2. Hover mouse over 'CLOTHES'
3. Check that 'MEN' and 'WOMEN' sub menu items appears
4. Hover mouse over 'ACCESSORIES'
5. Check that 'STATIONERY' and 'HOME ACCESSORIES' sub menu items appears
6. Hover mouse over 'ART'
7. Check that no any sub category appears


**Test case #6 (Check popular products)**
1. Go to the https://demo.prestashop.com/
2. Check that 8 products exist in 'POPULAR PRODUCTS' section
3. Check that every product has name
4. Check that every product has price
5. Check that all prices bigger than 0.00


**Test case #7 (Price drop check)**
1. Go to the https://demo.prestashop.com/
2. At the bottom of the page click on 'Prices drop' link
3. Check that every product has old and new price
4. Check that promo price for every product calculates correct


**Test case #8 (Sorting check)**
1. Go to the https://demo.prestashop.com/
2. Click on the 'All products >' under the 'POPULAR PRODUCTS' section
3. Sort products as 'Name, A to Z'
4. Check that sorting is correct
5. Sort products as 'Name, Z to A'
6. Check that sorting is correct
7. Sort products as 'Price, low to high'
8. Check that sorting is correct
9. Sort products as 'Price, high to low'
10. Check that sorting is correct


**Test case #9 (Adding to cart)**
1. Go to the https://demo.prestashop.com/
2. In the search field enter 'Bear' and press 'Enter'
3. On the 'SEARCH RESULTS' page click on 'Brown Bear Notebook'
4. Change 'Paper type' to 'Doted'
5. Change 'Quantity' to '5'
6. Click 'ADD TO CART' button
7. Check that new window with title 'Product successfully added to your shopping cart' appears
8. Check that correct 'Paper Type' and 'Quantity' is shown on the left side of the window
9. Check that 'Total' calculated correct


**Test case #10 (Checkout end-to-end)**
1. Go to the https://demo.prestashop.com/
2. In the search field enter 'Mug' and press 'Enter'
3. On the 'SEARCH RESULTS' page click on 'Customizable Mug'
4. Enter 'Best mug ever' in 'Product customization' field
5. Click 'SAVE CUSTOMIZATION'
6. Change 'Quantity' to '1' if not '1' already
7. Click 'ADD TO CART' button
8. On the next window click 'CONTINUE SHOPPING'
9. In the search field enter 'T-Shirt' and press 'Enter'
10. On the 'SEARCH RESULTS' page click on 'Hummingbird Printed T-Shirt'
11. Select 'Black' color
12. Click 'ADD TO CART' button
13. On the next window click 'PROCEED TO CHECKOUT'
14. On the 'SHOPPING CART' page check that 'Total' calculated correct
15. Click 'PROCEED TO CHECKOUT'
16. Fill 'PERSONAL INFORMATION' form with valid data (without password)
17. Click 'CONTINUE'
18. Fill the 'ADDRESSES' form with valid data
19. Click 'CONTINUE'
20. On the 'SHIPPING METHOD' section select 'My carrier'
21. Click 'CONTINUE'
22. On the 'PAYMENT' section select 'Pay by Check'
23. Check that Amount equal Subtotal+Shipping
24. Click on 'I agree..' checkbox
25. Click on 'Order with an obligation to pay'
26. Check that 'YOUR ORDER IS CONFIRMED' appered on the next page
27. Check that 'TOTAL' calculated correct