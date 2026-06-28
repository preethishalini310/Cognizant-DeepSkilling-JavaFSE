-- ─────────────────────────────────────────────────────────────────────────────
-- Country table seed data (Hands-on 1 file-1 + Hands-on 5 file-1)
-- ─────────────────────────────────────────────────────────────────────────────
INSERT INTO country (co_code, co_name) VALUES ('AF', 'Afghanistan');
INSERT INTO country (co_code, co_name) VALUES ('AL', 'Albania');
INSERT INTO country (co_code, co_name) VALUES ('DZ', 'Algeria');
INSERT INTO country (co_code, co_name) VALUES ('AS', 'American Samoa');
INSERT INTO country (co_code, co_name) VALUES ('AD', 'Andorra');
INSERT INTO country (co_code, co_name) VALUES ('AO', 'Angola');
INSERT INTO country (co_code, co_name) VALUES ('AR', 'Argentina');
INSERT INTO country (co_code, co_name) VALUES ('AU', 'Australia');
INSERT INTO country (co_code, co_name) VALUES ('AT', 'Austria');
INSERT INTO country (co_code, co_name) VALUES ('BD', 'Bangladesh');
INSERT INTO country (co_code, co_name) VALUES ('BE', 'Belgium');
INSERT INTO country (co_code, co_name) VALUES ('BR', 'Brazil');
INSERT INTO country (co_code, co_name) VALUES ('CA', 'Canada');
INSERT INTO country (co_code, co_name) VALUES ('CN', 'China');
INSERT INTO country (co_code, co_name) VALUES ('CO', 'Colombia');
INSERT INTO country (co_code, co_name) VALUES ('HR', 'Croatia');
INSERT INTO country (co_code, co_name) VALUES ('CZ', 'Czech Republic');
INSERT INTO country (co_code, co_name) VALUES ('DK', 'Denmark');
INSERT INTO country (co_code, co_name) VALUES ('EG', 'Egypt');
INSERT INTO country (co_code, co_name) VALUES ('ET', 'Ethiopia');
INSERT INTO country (co_code, co_name) VALUES ('FI', 'Finland');
INSERT INTO country (co_code, co_name) VALUES ('FR', 'France');
INSERT INTO country (co_code, co_name) VALUES ('DE', 'Germany');
INSERT INTO country (co_code, co_name) VALUES ('GH', 'Ghana');
INSERT INTO country (co_code, co_name) VALUES ('GR', 'Greece');
INSERT INTO country (co_code, co_name) VALUES ('HK', 'Hong Kong');
INSERT INTO country (co_code, co_name) VALUES ('HU', 'Hungary');
INSERT INTO country (co_code, co_name) VALUES ('IN', 'India');
INSERT INTO country (co_code, co_name) VALUES ('ID', 'Indonesia');
INSERT INTO country (co_code, co_name) VALUES ('IR', 'Iran, Islamic Republic of');
INSERT INTO country (co_code, co_name) VALUES ('IQ', 'Iraq');
INSERT INTO country (co_code, co_name) VALUES ('IE', 'Ireland');
INSERT INTO country (co_code, co_name) VALUES ('IL', 'Israel');
INSERT INTO country (co_code, co_name) VALUES ('IT', 'Italy');
INSERT INTO country (co_code, co_name) VALUES ('JP', 'Japan');
INSERT INTO country (co_code, co_name) VALUES ('KE', 'Kenya');
INSERT INTO country (co_code, co_name) VALUES ('MX', 'Mexico');
INSERT INTO country (co_code, co_name) VALUES ('MY', 'Malaysia');
INSERT INTO country (co_code, co_name) VALUES ('NL', 'Netherlands');
INSERT INTO country (co_code, co_name) VALUES ('NZ', 'New Zealand');
INSERT INTO country (co_code, co_name) VALUES ('NG', 'Nigeria');
INSERT INTO country (co_code, co_name) VALUES ('NO', 'Norway');
INSERT INTO country (co_code, co_name) VALUES ('PK', 'Pakistan');
INSERT INTO country (co_code, co_name) VALUES ('PE', 'Peru');
INSERT INTO country (co_code, co_name) VALUES ('PH', 'Philippines');
INSERT INTO country (co_code, co_name) VALUES ('PL', 'Poland');
INSERT INTO country (co_code, co_name) VALUES ('PT', 'Portugal');
INSERT INTO country (co_code, co_name) VALUES ('RO', 'Romania');
INSERT INTO country (co_code, co_name) VALUES ('RU', 'Russian Federation');
INSERT INTO country (co_code, co_name) VALUES ('SA', 'Saudi Arabia');
INSERT INTO country (co_code, co_name) VALUES ('ZA', 'South Africa');
INSERT INTO country (co_code, co_name) VALUES ('SS', 'South Sudan');
INSERT INTO country (co_code, co_name) VALUES ('ES', 'Spain');
INSERT INTO country (co_code, co_name) VALUES ('LK', 'Sri Lanka');
INSERT INTO country (co_code, co_name) VALUES ('SE', 'Sweden');
INSERT INTO country (co_code, co_name) VALUES ('CH', 'Switzerland');
INSERT INTO country (co_code, co_name) VALUES ('TW', 'Taiwan, Province of China');
INSERT INTO country (co_code, co_name) VALUES ('TH', 'Thailand');
INSERT INTO country (co_code, co_name) VALUES ('TN', 'Tunisia');
INSERT INTO country (co_code, co_name) VALUES ('TR', 'Turkey');
INSERT INTO country (co_code, co_name) VALUES ('UA', 'Ukraine');
INSERT INTO country (co_code, co_name) VALUES ('AE', 'United Arab Emirates');
INSERT INTO country (co_code, co_name) VALUES ('GB', 'United Kingdom');
INSERT INTO country (co_code, co_name) VALUES ('US', 'United States');
INSERT INTO country (co_code, co_name) VALUES ('UY', 'Uruguay');
INSERT INTO country (co_code, co_name) VALUES ('UZ', 'Uzbekistan');
INSERT INTO country (co_code, co_name) VALUES ('VN', 'Viet Nam');
INSERT INTO country (co_code, co_name) VALUES ('ZM', 'Zambia');
INSERT INTO country (co_code, co_name) VALUES ('ZW', 'Zimbabwe');
-- Bouvet Island, Djibouti, Guadeloupe - for 'ou' search test
INSERT INTO country (co_code, co_name) VALUES ('BV', 'Bouvet Island');
INSERT INTO country (co_code, co_name) VALUES ('DJ', 'Djibouti');
INSERT INTO country (co_code, co_name) VALUES ('GP', 'Guadeloupe');
INSERT INTO country (co_code, co_name) VALUES ('GS', 'South Georgia and the South Sandwich Islands');
INSERT INTO country (co_code, co_name) VALUES ('LU', 'Luxembourg');
INSERT INTO country (co_code, co_name) VALUES ('TF', 'French Southern Territories');
INSERT INTO country (co_code, co_name) VALUES ('UM', 'United States Minor Outlying Islands');

-- ─────────────────────────────────────────────────────────────────────────────
-- Payroll schema seed data (Hands-on 3,4,5,6 file-2 / file-3)
-- ─────────────────────────────────────────────────────────────────────────────
INSERT INTO department (dp_name) VALUES ('Engineering');
INSERT INTO department (dp_name) VALUES ('Finance');
INSERT INTO department (dp_name) VALUES ('HR');

INSERT INTO skill (sk_name) VALUES ('Java');
INSERT INTO skill (sk_name) VALUES ('Spring Boot');
INSERT INTO skill (sk_name) VALUES ('SQL');
INSERT INTO skill (sk_name) VALUES ('Python');
INSERT INTO skill (sk_name) VALUES ('React');

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES ('Alice Johnson', 85000.00, true,  '1990-04-15', 1);
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES ('Bob Smith',    72000.00, true,  '1988-07-22', 2);
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES ('Carol White',  63000.00, false, '1995-01-10', 3);
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES ('David Brown',  91000.00, true,  '1985-11-30', 1);
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES ('Eva Green',    78000.00, false, '1993-06-05', 2);

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 3);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 4);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (4, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (4, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (4, 3);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (5, 5);
