create table users
(
    id       BIGINT auto_increment
        primary key,
    name     VARCHAR(255) not null,
    email    VARCHAR(255) not null,
    password VARCHAR(255) not null
);

CREATE TABLE profiles (
                          id BIGINT NOT NULL PRIMARY KEY,
                          bio LONGTEXT NULL,
                          phone_number VARCHAR(15) NULL,
                          date_of_birth date NULL,
                          weight INT NULL,
                          height INT NULL,
                          gender VARCHAR(10) NOT NULL,
                          CONSTRAINT profiles_users_id_fk FOREIGN KEY (id) REFERENCES users (id)
);


CREATE TABLE workouts (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          date DATE NOT NULL,
                          time TIME NOT NULL,
                          user_id BIGINT NOT NULL,
                          CONSTRAINT workouts_users_id_fk FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE workout_entries (
                                 id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                                 workout_id BIGINT NOT NULL,
                                 name VARCHAR(255) NOT NULL,
                                 description VARCHAR(255) NULL,
                                 sets INT NOT NULL,
                                 reps INT NOT NULL,
                                 weight DECIMAL(5,2) NOT NULL,
                                 CONSTRAINT workout_entries_workouts_id_fk FOREIGN KEY (workout_id) REFERENCES workouts(id)
);
