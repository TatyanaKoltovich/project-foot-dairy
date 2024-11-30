CREATE table if not exists users
(
    id       BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    email    VARCHAR(50)         NOT NULL
);

CREATE table if not exists roles
(
    id           BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    type_of_role VARCHAR(255),
    user_id      BIGINT
);

CREATE table if not exists products
(
    id            BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name          VARCHAR(255) UNIQUE NOT NULL,
    proteins      INTEGER NOT NULL,
    fats          INTEGER NOT NULL,
    carbohydrates INTEGER NOT NULL,
    calories      INTEGER NOT NULL
);

CREATE table if not exists dayplans
(
    id           BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id      BIGINT,
    calories     INTEGER NOT NULL
);

CREATE table if not exists dayfacts
(
    id            BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id       BIGINT,
    meal_type     VARCHAR(50) NOT NULL,
    product_id    BIGINT,
    product_count INTEGER,
    calories_count INTEGER
);
