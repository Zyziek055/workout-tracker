create table users
(
    id       BIGINT auto_increment
        primary key,
    name     VARCHAR(255) not null,
    email    VARCHAR(255) not null,
    password VARCHAR(255) not null
);

create table workouts
(
    id          BIGINT auto_increment
        primary key,
    name        VARCHAR(255) not null,
    description VARCHAR(255) null,
    time        TIME         not null,
    user_id     BIGINT       not null,
    constraint workouts_users_id_fk
        foreign key (user_id) references users (id)
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

alter table profiles
    add user_id BIGINT not null;

alter table profiles
    add constraint profiles_users_id_fk
        foreign key (user_id) references users (id);

CREATE TABLE workout_entries (
                                 id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                                 workout_id BIGINT NOT NULL,
                                 name VARCHAR(255) NOT NULL,
                                 description VARCHAR(255) NULL,
                                 sets INT NOT NULL,
                                 reps INT NOT NULL,
                                 weight DECIMAL(5,2)
);

alter table workout_entries
    add constraint workout_entries_workouts_id_fk
        foreign key (workout_id) references workouts (id);
