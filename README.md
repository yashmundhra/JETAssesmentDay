# Restaurant Search Application - JET Assessment Day

This application allows users to search for restaurants by postcode. It consists of a simple HTML/JavaScript frontend and a Java Spring Boot backend.

## Project Structure
```
RestaurantFinderJET/
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
├── frontend/
│   └── index.html              # Simple HTML frontend
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── restaurantfinderjet/
│   │   │               ├── controller/
│   │   │               │   └── RestaurantController.java
│   │   │               ├── model/
│   │   │               │   └── Restaurant.java
│   │   │               ├── service/
│   │   │               │   └── RestaurantService.java
│   │   │               └── RestaurantFinderJetApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── restaurantfinderjet/
│                       └── RestaurantFinderJetApplicationTests.java
├── .gitattributes
├── .gitignore
├── mvnw                        # Maven wrapper script (Unix)
├── mvnw.cmd                    # Maven wrapper script (Windows)
├── pom.xml                     # Maven project configuration
└── README.md                   
```


## How to Build, Compile, and Run

### Prerequisites

- Java JDK 17 or higher
- Maven (or use the included Maven wrapper)
- A web browser

### Backend (Spring Boot)

**Build and run the application:**

  ```shellscript
  # From the root directory (where pom.xml is located)
  
  # Run directly with Spring Boot
  ./mvnw spring-boot:run
  ```
The backend will start on [http://localhost:8080](http://localhost:8080)

### Frontend (HTML)

**Serve using a simple HTTP server:**

```shellscript
# Using Python's built-in HTTP server
cd frontend
python -m http.server 3000
```

Then access the frontend at [http://localhost:3000](http://localhost:3000)

## Usage

1. Enter a postcode in the search box
2. Click "Search"
3. View the list of restaurants that deliver to that postcode


## API Endpoints

- `GET /api/restaurants?postcode={postcode}` - Returns restaurants that deliver to the specified postcode

## Assumptions

- The definition of "cuisine" is not specified. The cuisine array also consists of other names such as "Deals", "Local Legends" etc. It was observed that in most scenarios the first two names in the array are real "cuisines" so it was chosen to only display the first two names.
- Assumed that address is constructed by combining firstLine and postalCode and city
- It is assumed that the Just Eat API will always return completed data and will always return data in the same format. Each restaurant object contains at least a name, cuisines (array), rating (number) and address field.
- It is assumed that port 8080 and 3000 are available for the frontend and backend services.

## Potential Improvements

### Feature-Specific Improvements

- **Restaurant Filtering and Sorting:**
  * **Filtering Options:** Allow users to filter restaurants by cuisine type, rating, distance and other fields
  * **Sorting Options:** Sort restaurants by proximity to the user, rating etc.


- **Restaurant Information Display:**
  - **Opening Hours:** Display whether a restaurant is open for delivery or not
  - **Special Offers:** Highlight restaurants with current promotions


- **User Experience Improvements:**
  - **Restaurant Comparison:** Allow selecting multiple restaurants to compare
  - **Favorites System:** Let users save favorite restaurants
  - **Accessibility Features:** Ensure the application is accessible to all users


- **Integration Possibilities:**
  - **Maps Integration:** Show restaurant locations on a map
  - **Loyalty Programs:** Integrate with restaurant loyalty programs
  - **Notification System:** Alert users about order status or special offers


### Backend Improvements

* Add pagination for large result sets
* Add unit tests for service and controller layers, add integration tests for API endpoints
* Implement test coverage reporting
* Add Swagger/OpenAPI documentation. Improve code comments and documentation
* Improve error handling with appropriate HTTP status codes and responses on the frontend
