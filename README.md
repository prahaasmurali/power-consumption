# ⚡ Power Consumption Service

A Spring Boot REST API service for managing and calculating electricity bills for houses based on their power consumption across different ESCOM (Electricity Supply Companies) providers.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Billing Logic](#billing-logic)
- [Project Structure](#project-structure)
- [Testing](#testing)

## 🎯 Overview

This service simulates a power consumption assessment system that:
- Manages 100 houses with randomly assigned ESCOMs (CESCOM, DESCOM, FESCOM)
- Tracks power consumption in units
- Calculates electricity bills based on ESCOM-specific rates and slabs

## ✨ Features

- **House Management**: Pre-populated database of 100 houses with unique IDs
- **ESCOM Assignment**: Each house is randomly assigned to one of three ESCOMs
- **Unit Tracking**: Random power consumption between 0-300 units per house
- **Bill Calculation**: Slab-based billing system with different rates per ESCOM
- **REST API**: Easy-to-use endpoints for querying house information and bills

## 🛠 Technology Stack

- **Java 17**
- **Spring Boot 3.0.0**
  - Spring Web
  - Spring Boot Starter
- **Maven** - Build tool
- **Lombok** - Reduce boilerplate code
- **In-Memory Storage** - HashMap-based data store

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone https://github.com/prahaasmurali/power-consumption.git
   cd power-consumption
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API**
   
   The application will start on `http://localhost:8080`

## 📡 API Endpoints

### 1. Get House ESCOM Information

```http
GET /api/houses/{id}
```

**Response:**
```json
{
  "houseId": 5,
  "escom": "CESCOM"
}
```

### 2. Calculate Bill for a House

```http
GET /api/bill/{id}
```

**Response:**
```json
{
  "houseId": 5,
  "escom": "CESCOM",
  "units": 150,
  "amount": 750.0
}
```

### Example Requests

Using **curl**:
```bash
# Get house ESCOM
curl http://localhost:8080/api/houses/5

# Get bill calculation
curl http://localhost:8080/api/bill/10
```

Using **PowerShell**:
```powershell
Invoke-WebRequest -Uri "http://localhost:8080/api/houses/5" | Select-Object -Expand Content
Invoke-WebRequest -Uri "http://localhost:8080/api/bill/10" | Select-Object -Expand Content
```

Or simply open in your browser:
- http://localhost:8080/api/houses/5
- http://localhost:8080/api/bill/10

## 💰 Billing Logic

The service uses a **slab-based billing system** where rates vary by ESCOM provider:

### CESCOM Rates
| Units Range | Rate per Unit |
|------------|---------------|
| 0-100      | ₹5.00        |
| 101-200    | ₹7.00        |
| 201+       | ₹10.00       |

### DESCOM Rates
| Units Range | Rate per Unit |
|------------|---------------|
| 0-100      | ₹6.00        |
| 101-200    | ₹8.00        |
| 201+       | ₹11.00       |

### FESCOM Rates
| Units Range | Rate per Unit |
|------------|---------------|
| 0-100      | ₹4.00        |
| 101-200    | ₹6.00        |
| 201+       | ₹9.00        |

**Example Calculation** (CESCOM, 250 units):
- First 100 units: 100 × ₹5 = ₹500
- Next 100 units: 100 × ₹7 = ₹700
- Remaining 50 units: 50 × ₹10 = ₹500
- **Total Bill: ₹1,700**

## 📁 Project Structure

```
power-consumption-service/
├── src/
│   └── main/
│       └── java/
│           └── com/example/powerconsumption/
│               ├── PowerConsumptionServiceApplication.java  # Main application
│               ├── controller/
│               │   └── BillController.java                  # REST endpoints
│               ├── dao/
│               │   ├── HouseDao.java                        # Data access interface
│               │   └── impl/
│               │       └── HouseDaoImpl.java                # In-memory data store
│               ├── model/
│               │   └── House.java                           # House entity
│               └── service/
│                   ├── BillService.java                     # Business logic interface
│                   └── impl/
│                       └── BillServiceImpl.java             # Bill calculation logic
├── pom.xml                                                  # Maven configuration
└── README.md                                                # This file
```

## 🧪 Testing

### Manual Testing

You can test the API using:

1. **Web Browser** - For GET requests, simply visit the URL
2. **curl** - Command-line HTTP client
3. **PowerShell** - Using `Invoke-WebRequest`
4. **Postman** - API testing tool
5. **VS Code REST Client** - Install the REST Client extension

### Sample Test Cases

- **Valid House IDs**: 1-100
- **Invalid House IDs**: Any number outside 1-100 (returns null/error)

```bash
# Test valid house
curl http://localhost:8080/api/bill/1

# Test boundary
curl http://localhost:8080/api/bill/100

# Test invalid
curl http://localhost:8080/api/bill/999
```

## 🎓 Learning Points

This project demonstrates:
- ✅ RESTful API design with Spring Boot
- ✅ Layered architecture (Controller → Service → DAO)
- ✅ Dependency Injection using Spring
- ✅ In-memory data management
- ✅ Business logic implementation (slab-based calculations)
- ✅ @PostConstruct for initialization
- ✅ Path variables in REST endpoints

## 📝 License

This project is open source and available for educational purposes.

## 👤 Author

**Prahaas Murali**
- GitHub: [@prahaasmurali](https://github.com/prahaasmurali)

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

---

⭐ If you find this project helpful, please give it a star!
