CREATE DATABASE vehicle_services;

USE vehicle_services;

CREATE TABLE vehicle (
    vehicle_id INT PRIMARY KEY,
    owner_name VARCHAR(100),
    model VARCHAR(100),
    service_cost FLOAT,
    fuel_type CHAR(1)
);

CREATE TABLE booking (
    booking_id INT PRIMARY KEY,
    vehicle_id INT,
    service_date DATE,
    status VARCHAR(50),
    estimated_cost FLOAT
);

INSERT INTO vehicle VALUES
(1, 'Rahul Sharma', 'Honda City', 3500.0, 'P'),
(2, 'Anjali Mehta', 'Hyundai i20', 2700.5, 'D'),
(3, 'Karan Verma', 'Maruti Swift', 1800.0, 'P'),
(4, 'Neha Gupta', 'Toyota Innova', 4200.0, 'D'),
(5, 'Ravi Kumar', 'Tata Nexon', 3000.0, 'P'),
(6, 'Meena Roy', 'Kia Seltos', 3300.0, 'P'),
(7, 'Siddharth Rao', 'Mahindra XUV500', 4500.0, 'D'),
(8, 'Ayesha Khan', 'Ford EcoSport', 3100.0, 'P'),
(9, 'Vikram Singh', 'Renault Duster', 2950.0, 'D'),
(10, 'Pooja Rani', 'MG Hector', 3700.0, 'P');

INSERT INTO booking VALUES
(101, 1, '2025-05-10', 'Completed', 3400.0),
(102, 2, '2025-05-11', 'Pending', 2700.5),
(103, 3, '2025-05-12', 'Completed', 1750.0),
(104, 4, '2025-05-13', 'In Progress', 4100.0),
(105, 5, '2025-05-13', 'Pending', 2900.0),
(106, 6, '2025-05-14', 'Completed', 3200.0),
(107, 7, '2025-05-14', 'Pending', 4450.0),
(108, 8, '2025-05-15', 'Completed', 3000.0),
(109, 9, '2025-05-15', 'In Progress', 2900.0),
(110, 10, '2025-05-16', 'Completed', 3600.0);

SELECT* FROM vehicle;
SELECT* FROM booking;






