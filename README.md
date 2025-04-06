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

1. **Configure the API URL:**

   Open `src/main/resources/application.properties` and set your restaurant API URL:

   ```properties
   restaurant.api.url=YOUR_RESTAURANT_API_URL_HERE

2. **Build and run the application:**

    ```shellscript
    # From the root directory (where pom.xml is located)
    
    # Using Maven wrapper
    ./mvnw clean package
    java -jar target/restaurant-api-0.0.1-SNAPSHOT.jar
    
    # OR run directly with Spring Boot
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
