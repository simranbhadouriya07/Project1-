
# Instagram backend basic application :

## Overview

This project provides a basic design for the backend of Instagram. It includes the following features:

- User authentication (sign up, sign in ,sing out)
- User profile management (update user details)
- Post management (save and retrieve posts)

## Table of Contents

- [Introduction](#introduction)
- [dependency](#dependency)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Installation](#installation)
- [Usage](#usage)
  - [API Endpoints](#api-endpoints)
- [Contributing](#contributing)


## Introduction

The Instagram backend application  simplifies the creating a user and like sing up the user and sing in the user and Authenticate every time while facting the user details.

## Dependency
- Spring web 
- Lombok
- validation
- spring JPA
- Swagger 
- MySql drivers 
## Features
- User sing up with encrypting password .
- USer sing in and Authenticate and receive a token.
-
## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed.
- Mavan jar depandancy file created by spring initializr .
- Your favorite Integrated Development Environment (IDE) for Java (e.g., IntelliJ IDEA, Eclipse).
- A REST client (e.g., Postman, cURL) for testing API endpoints.

## Getting Started

Follow these steps to set up and run the  User Management System:

### Installation

1. Clone the repository to your local machine:

   ```shell
   git clone https://github.com/shashanklodhi1999/week_test.git
Open the project in your preferred IDE.

Run the Spring Boot application.

Using Maven:

shell
Copy code
mvn spring-boot:run
The application will start on http://localhost:8080.

 ## The following API endpoints are available:

### user controller 

- Post :- sing up
  URL: /userSingup 

- Post :- sing in
  URL: /userSingIn

- Delete :- sing out
  URL: /usersingOut

### Post controller 
- post intragram post 
  URL: /Post
- Get : get posts 
  URL: /posts

- Get : get psot by id 
  URL: /post  

# Contributing
Contributions are welcome! Feel free to open issues or submit pull requests to improve this project.