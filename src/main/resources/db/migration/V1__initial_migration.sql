CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE profiles (
                          id BIGINT NOT NULL PRIMARY KEY,
                          bio LONGTEXT NULL,
                          phone_number VARCHAR(15) NULL,
                          date_of_birth  date NULL,
                          weight INT NULL,
                          height INT NULL,
                          gender VARCHAR(10) NOT NULL
);

CREATE TABLE workouts(
                         id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description VARCHAR(255) NULL,
                         time TIME NOT NULL
);

CREATE TABLE workout_entries (
                                 id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                                 workout_id BIGINT NOT NULL,
                                 name VARCHAR(255) NOT NULL,
                                 description VARCHAR(255) NULL,
                                 sets INT NOT NULL,
                                 reps INT NOT NULL,
                                 weight DECIMAL(5,2),
                                 FOREIGN KEY (workout_id) REFERENCES workouts(id)
);

