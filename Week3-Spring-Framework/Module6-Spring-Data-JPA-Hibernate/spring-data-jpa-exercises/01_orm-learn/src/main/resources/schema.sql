-- Country table
CREATE TABLE IF NOT EXISTS country (
    co_code VARCHAR(2)  PRIMARY KEY,
    co_name VARCHAR(100) NOT NULL
);

-- Payroll schema
CREATE TABLE IF NOT EXISTS department (
    dp_id   INT AUTO_INCREMENT PRIMARY KEY,
    dp_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS skill (
    sk_id   INT AUTO_INCREMENT PRIMARY KEY,
    sk_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee (
    em_id            INT AUTO_INCREMENT PRIMARY KEY,
    em_name          VARCHAR(100)   NOT NULL,
    em_salary        DECIMAL(10,2)  NOT NULL,
    em_permanent     BOOLEAN        NOT NULL DEFAULT FALSE,
    em_date_of_birth DATE,
    em_dp_id         INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

CREATE TABLE IF NOT EXISTS employee_skill (
    es_em_id INT NOT NULL,
    es_sk_id INT NOT NULL,
    PRIMARY KEY (es_em_id, es_sk_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

-- Stock table (Hands-on 2 file-2)
CREATE TABLE IF NOT EXISTS stock (
    st_id     INT AUTO_INCREMENT PRIMARY KEY,
    st_code   VARCHAR(10),
    st_date   DATE,
    st_open   DECIMAL(10,2),
    st_close  DECIMAL(10,2),
    st_volume BIGINT
);
