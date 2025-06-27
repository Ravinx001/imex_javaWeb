# 🚗 Imex Car Sale System

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JSP](https://img.shields.io/badge/JSP-007396?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![Servlet](https://img.shields.io/badge/Servlet-FF6B6B?style=for-the-badge&logo=apache&logoColor=white)

**A comprehensive Java-based vehicle marketplace with advanced admin management**

[🚀 Demo](#-screenshots) • [📖 Documentation](#-installation) • [🛠️ Setup](#️-installation) • [🤝 Contributing](#-contributing)

</div>

## 📋 Project Overview

Imex Car Sale is a **full-stack vehicle marketplace platform** built with Java JSP/Servlet architecture, featuring robust admin controls, secure user authentication, and comprehensive vehicle management capabilities.

### 🎯 **Key Highlights**
- 🔐 **Secure Authentication** - SHA-256 password hashing with session management
- 👨‍💼 **Admin Dashboard** - Complete CRUD operations for brands, categories & vehicles
- 🖼️ **Image Management** - Multi-image upload with file validation
- 🔍 **Advanced Search** - Multi-filter search functionality
- 📧 **Inquiry System** - Customer communication management
- 🛡️ **SQL Injection Protection** - Prepared statements & input validation

---

## 🏗️ System Architecture

```mermaid
graph TB
    subgraph "Frontend Layer"
        A[JSP Pages]
        B[Bootstrap UI]
        C[JavaScript]
    end
    
    subgraph "Backend Layer"
        D[Java Servlets]
        E[Service Classes]
        F[DAO Layer]
    end
    
    subgraph "Database Layer"
        G[(MySQL Database)]
        H[DBConnect Utility]
    end
    
    A --> D
    B --> D
    C --> D
    D --> E
    E --> F
    F --> H
    H --> G
    
    style A fill:#e1f5fe
    style D fill:#f3e5f5
    style G fill:#e8f5e8
```

---

## ✨ Feature Matrix

<table>
<tr>
<td width="50%">

### 🧩 **Core Modules**
| Module | Functionality |
|--------|---------------|
| 🏷️ **Brand Management** | CRUD operations with referential integrity |
| 📂 **Category System** | Hierarchical categorization & validation |
| 🚙 **Vehicle Management** | Full lifecycle management + multi-image support |
| 👤 **User Authentication** | Secure login with session handling |
| 📞 **Inquiry System** | Customer communication & lead management |

</td>
<td width="50%">

### 🔒 **Security Features**
- ✅ SHA-256 Password Encryption
- ✅ Session-based Authentication
- ✅ SQL Injection Prevention
- ✅ CSRF Protection
- ✅ Input Validation & Sanitization
- ✅ File Upload Security
- ✅ Role-based Access Control

</td>
</tr>
</table>

---

## 🖥️ Screenshots

<div align="center">

### Admin Dashboard
<img src="https://github.com/Ravinx001/imex_javaWeb/blob/main/images/adminDashboard.jpeg" alt="Admin Dashboard" width="45%"/>

### Vehicle Management
<img src="https://github.com/Ravinx001/imex_javaWeb/blob/main/images/vehiclesAdmin.jpeg" alt="Vehicle Listings" width="45%"/>
<img src="https://github.com/Ravinx001/imex_javaWeb/blob/main/images/uploadvehicleimageAdmin.jpeg" alt="Vehicle Image Upload" width="45%"/>
<img src="https://github.com/Ravinx001/imex_javaWeb/blob/main/images/updatevehicleAdmin.jpeg" alt="Vehicle Update Vehicle" width="45%"/>

### Brand Management
<img src="https://github.com/Ravinx001/imex_javaWeb/blob/main/images/brandsAdmin.jpeg" alt="Brand Management" width="45%"/>

### Categories Management
<img src="https://github.com/Ravinx001/imex_javaWeb/blob/main/images/categoriesAdmin.jpeg" alt="Categories Management" width="45%"/>

### User Experience
<img src="https://github.com/Ravinx001/imex_javaWeb/blob/main/images/allads.jpeg" alt="Search" width="45%"/>
<img src="https://github.com/Ravinx001/imex_javaWeb/blob/main/images/home.jpeg" alt="home" width="45%"/>
<img src="https://github.com/Ravinx001/imex_javaWeb/blob/main/images/vehicledetails.jpeg" alt="single add view" width="45%"/>

</div>

---

## ⚙️ Installation & Setup

### 📋 **Prerequisites**
```bash
☑️ Java 8+ (JDK)
☑️ Apache Tomcat 9+
☑️ MySQL 8.0+
☑️ Eclipse IDE / IntelliJ IDEA
☑️ Maven (optional)
```

### 🚀 **Quick Start**

<details>
<summary><b>📥 Step 1: Clone Repository</b></summary>

```bash
git clone https://github.com/yourusername/imex-car-sale.git
cd imex-car-sale
```
</details>

<details>
<summary><b>🗄️ Step 2: Database Setup</b></summary>

```sql
-- Create database
CREATE DATABASE imex_car_sale;
USE imex_car_sale;

-- Import provided SQL schema
SOURCE database/schema.sql;

-- Insert sample data (optional)
SOURCE database/sample_data.sql;
```
</details>

<details>
<summary><b>⚙️ Step 3: Configuration</b></summary>

Update database credentials in `src/config/DBConnect.java`:
```java
private static final String URL = "jdbc:mysql://localhost:3306/imex_car_sale";
private static final String USERNAME = "your_username";
private static final String PASSWORD = "your_password";
```
</details>

<details>
<summary><b>🚀 Step 4: Deploy & Run</b></summary>

1. Import project into your IDE
2. Configure Tomcat server
3. Deploy the application
4. Access: `http://localhost:8080/imex-car-sale`
</details>

---

## 🗃️ Database Schema

<details>
<summary><b>📊 Complete Database Structure</b></summary>

### **Core Tables**

```sql
-- Vehicle Management (Main Entity)
CREATE TABLE vehicle (
    vehicleId INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    price DOUBLE,
    manufactureYear YEAR,
    model VARCHAR(50),
    modelVariant VARCHAR(50),
    mileage VARCHAR(50),
    engineCapacity VARCHAR(45),
    description TEXT,
    categoryId INT NOT NULL,
    brandId INT NOT NULL,
    fuelTypeId INT NOT NULL,
    transmissionId INT NOT NULL,
    featuringId INT NOT NULL,
    userId INT NOT NULL,
    locationId INT NOT NULL,
    conditionId INT NOT NULL
);

-- Vehicle Images
CREATE TABLE vehimgpaths (
    vehimgpathsId INT PRIMARY KEY AUTO_INCREMENT,
    vehimgpath TEXT,
    vehicleId INT NOT NULL,
    FOREIGN KEY (vehicleId) REFERENCES vehicle(vehicleId) ON DELETE CASCADE
);

-- User Management
CREATE TABLE users (
    userId INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    password TEXT -- SHA-256 hashed passwords
);

-- Customer Inquiries
CREATE TABLE inquires (
    inquiryId INT PRIMARY KEY AUTO_INCREMENT,
    customerName VARCHAR(50),
    customerEmail VARCHAR(100),
    customerMobile VARCHAR(10),
    inquiry TEXT,
    vehicleId INT NOT NULL,
    FOREIGN KEY (vehicleId) REFERENCES vehicle(vehicleId) ON DELETE CASCADE
);
```

### **Reference/Lookup Tables**

```sql
-- Vehicle Categorization
CREATE TABLE brand (
    brandId INT PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(45)
);

CREATE TABLE category (
    categoryId INT PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(45)
);

-- Vehicle Specifications
CREATE TABLE fueltype (
    fuelTypeId INT PRIMARY KEY AUTO_INCREMENT,
    fuelType VARCHAR(45)
);

CREATE TABLE transmission (
    transmissionId INT PRIMARY KEY AUTO_INCREMENT,
    transmission VARCHAR(45)
);

CREATE TABLE conditions (
    conditionId INT PRIMARY KEY AUTO_INCREMENT,
    condition VARCHAR(45)
);

-- Additional Attributes
CREATE TABLE location (
    locationId INT PRIMARY KEY AUTO_INCREMENT,
    location VARCHAR(45)
);

CREATE TABLE featuring (
    featuringId INT PRIMARY KEY AUTO_INCREMENT,
    featuring VARCHAR(45) -- 'Recommended' or 'Normal'
);
```

### **Database Relationships**
```
vehicle (1) ←→ (M) vehimgpaths
vehicle (M) ←→ (1) brand
vehicle (M) ←→ (1) category
vehicle (M) ←→ (1) fueltype
vehicle (M) ←→ (1) transmission
vehicle (M) ←→ (1) conditions
vehicle (M) ←→ (1) location
vehicle (M) ←→ (1) featuring
vehicle (M) ←→ (1) users
vehicle (1) ←→ (M) inquires
```

### **Sample Data Overview**
| Table | Records | Examples |
|-------|---------|----------|
| **Brands** | 12 | Toyota, Honda, BMW, Tesla, Mercedes-Benz |
| **Categories** | 20 | SUV, Sedan, Truck, Electric, Convertible |
| **Fuel Types** | 11 | Petrol, Diesel, Electric, Hybrid, CNG |
| **Transmissions** | 11 | Manual, Automatic, CVT, Semi-Automatic |
| **Locations** | 41 | Colombo districts, major Sri Lankan cities |
| **Conditions** | 5 | Brand New (Registered/Unregistered), Used |

</details>

---

## 🌟 Roadmap & Development Status

### ✅ **Completed Features**
- [x] 🔐 User Authentication & Authorization
- [x] 🚗 Vehicle CRUD Operations
- [x] 🖼️ Multi-image Upload System
- [x] 🔍 Advanced Search & Filtering
- [x] 📊 Admin Dashboard
- [x] 📞 Customer Inquiry Management

### 🚧 **In Development**
- [ ] ⚡ Electric Vehicle Specialty Section
- [ ] 📱 Mobile Responsive Design
- [ ] 📈 Advanced Analytics Dashboard

### 🎯 **Future Enhancements**
- [ ] 🤖 AI-powered Vehicle Recommendations
- [ ] 🗺️ Location-based Search
- [ ] 📊 Market Price Analysis
- [ ] 🔄 Vehicle Comparison Tool

---

## 🛠️ Tech Stack

<div align="center">

| **Frontend** | **Backend** | **Database** | **Tools** |
|:------------:|:-----------:|:------------:|:---------:|
| ![JSP](https://img.shields.io/badge/JSP-007396?style=flat-square&logo=java) | ![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk) | ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white) | ![Tomcat](https://img.shields.io/badge/Tomcat-F8DC75?style=flat-square&logo=apache-tomcat&logoColor=black) |
| ![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=flat-square&logo=bootstrap&logoColor=white) | ![Servlet](https://img.shields.io/badge/Servlet-FF6B6B?style=flat-square) | ![JDBC](https://img.shields.io/badge/JDBC-007396?style=flat-square) | ![Eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=flat-square&logo=eclipse&logoColor=white) |
| ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black) | ![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven) | | ![Git](https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white) |

</div>

---

## 📖 API Documentation

<details>
<summary><b>🔗 Servlet Endpoints</b></summary>

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/login` | POST | User authentication |
| `/vehicles` | GET | Retrieve vehicle listings |
| `/vehicles/add` | POST | Add new vehicle |
| `/vehicles/edit` | PUT | Update vehicle details |
| `/vehicles/delete` | DELETE | Remove vehicle |
| `/brands` | GET/POST | Brand management |
| `/categories` | GET/POST | Category management |
| `/inquiries` | GET/POST | Customer inquiries |
| `/upload` | POST | Image upload handler |

</details>

---

## 🤝 Contributing

We welcome contributions! Here's how you can help:

<div align="center">

  ![GitHub repo size](https://img.shields.io/github/repo-size/Ravinx001/imex_javaWeb/?style=for-the-badge)
  ![GitHub stars](https://img.shields.io/github/stars/Ravinx001/imex_javaWeb/?style=for-the-badge)
  ![GitHub forks](https://img.shields.io/github/forks/Ravinx001/imex_javaWeb/?style=for-the-badge)
  ![GitHub issues](https://img.shields.io/github/issues/Ravinx001/imex_javaWeb/?style=for-the-badge)

</div>

1. 🍴 **Fork** the repository
2. 🔄 **Clone** your fork
3. 🌿 **Create** a feature branch
4. ✍️ **Commit** your changes
5. 📤 **Push** to your branch
6. 🎯 **Submit** a pull request

---

## 📄 License

<div align="center">

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

</div>

---

<div align="center">

### 🌟 **Star this repository if you found it helpful!**

[⭐ Star](https://github.com/yourusername/imex-car-sale) • [🐛 Report Bug](https://github.com/yourusername/imex-car-sale/issues) • [💡 Request Feature](https://github.com/yourusername/imex-car-sale/issues)

**Made with ❤️ by [Ravindu Amarasekara ](https://github.com/Ravinx001/)**

---

*Last updated: June 2025*

</div>
