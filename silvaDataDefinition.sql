CREATE DATABASE truckingCompany;
USE truckingCompany;

CREATE TABLE Driver(
    driver_id SMALLINT UNSIGNED,
    first_Name VARCHAR(35),
    last_Name VARCHAR(35);
    birth_day DATE NOT NULL,
    truck_id SMALLINT UNSIGNED,
);

ALTER TABLE Driver
ADD CONSTRAINT PRIMARY KEY(driver_id);

ALTER TABLE Driver
MODIFY COLUMN driver_id SMALLINT UNSIGNED AUTO_INCREMENT;

CREATE TABLE Truck(
    truck_id SMALLINT UNSIGNED AUTO_INCREMENT UNIQUE,
    truck_type VARCHAR(35) DEFAULT 'Freight',
    miles_num MEDIUMINT UNSIGNED NOT NULL,
    driver_id SMALLINT UNSIGNED,
    PRIMARY KEY (truck_id),
    CONSTRAINT fk_truckid_driverid FOREIGN KEY Truck(truck_id) REFERENCES Driver(driver_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT 
);

ALTER TABLE Driver ADD CONSTRAINT fk_driverid_truckid
FOREIGN KEY (truck_id) REFERENCES Truck(truck_id);

CREATE TABLE Log(
    log_num SMALLINT UNSIGNED AUTO_INCREMENT,
    driver_id SMALLINT UNSIGNED,
    truck_id SMALLINT,
    date_in DATE,
    time_in TIME,
    time_out Time NOT NULL, 
    PRIMARY KEY (log_num),
    CONSTRAINT fk_log_truckid_driverid FOREIGN KEY (driver_id, truck_id) REFERENCES Driver(driver_id),Truck(truck_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

INSERT INTO Driver VALUES
(1, 'Miles', 'Brooks', '2016-01-26', 1);
