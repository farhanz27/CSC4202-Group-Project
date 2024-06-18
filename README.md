# Earthquake Response Optimization System

## Table of Contents
- [Introduction](#introduction)
- [Problem Definition](#problem-definition)
- [Development of the Model](#development-of-the-model)
- [Algorithm Specification](#algorithm-specification)
- [Designing the Algorithm](#designing-the-algorithm)
- [Implementation](#implementation)
- [Program Testing](#program-testing)
- [Results and Analysis](#results-and-analysis)
- [Conclusion](#conclusion)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Introduction
This project aims to optimize the allocation of rescue teams in an urban area affected by an earthquake. The goal is to minimize response time and maximize the number of lives saved using a Greedy Algorithm.

## Problem Definition
**Scenario:** An earthquake has caused severe damage to buildings and roads in a densely populated urban area.

**Geographical Setting:** Densely populated urban area.

**Type of Disaster:** Earthquake.

**Damage Impact:** Severe damage to buildings and infrastructure, loss of life, and injuries.

**Importance of AAD:** Adaptive Automated Decision-making (AAD) can optimize the allocation of rescue teams and resources, improving efficiency and effectiveness.

**Goal:** Develop a model for optimal allocation of rescue teams to various affected locations to minimize response time and maximize the number of lives saved.

**Expected Output:** An optimized rescue operation plan, indicating which rescue teams should be deployed to which locations.

## Development of the Model
**Data Type:**
- Real-time data on affected locations.
- Availability and location of rescue teams.
- Road conditions and traffic data.

**Objective Function:** Minimize the total response time and maximize the number of lives saved.

**Constraints:** Limited number of rescue teams, road conditions, traffic constraints, and the severity of damage at each location.

## Algorithm Specification
**Algorithm Selected:** Greedy Algorithm for immediate rescue operations.

**Comparison of Options:**
- **Dynamic Programming (DP):** Provides an optimal solution but is computationally intensive.
- **Divide and Conquer:** Efficient for breaking down problems but may not handle interconnected subproblems well.
- **Greedy Algorithm:** Fast decision-making, suitable for real-time applications.

**Suitability:** The Greedy Algorithm is suitable for quick decision-making in real-time scenarios, essential for earthquake response.

## Designing the Algorithm
**Pseudocode:**
```java
1. Initialize a priority queue for rescue locations based on severity.
2. While there are rescue teams available:
   a. Dequeue the highest priority location.
   b. Assign the nearest available rescue team to this location.
   c. Update the status of the rescue team and the location.
3. Return the allocation plan.
