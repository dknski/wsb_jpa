INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES (1, 'Wrocław', 'Wiśniowa', '12', '62-030');
INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES (2, 'Brzeg Dolny', 'Wrocławska', '2', '55-330');
INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES (3, 'Środa Śląska', 'Legnicka', '34', '50-120');
INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES (4, 'Oleśnica', 'Cisowa', '87', '14-430');

INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES (1, 'Paweł', 'Mnich', '123456789', 'pawel.mnich@gmail.com', 'D1', 'CARDIOLOGIST', 1);
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES (2, 'Zbigniew', 'Kowalski', '987654321', 'z.kowalski@gmail.com', 'D2', 'DERMATOLOGIST', 2);

INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, age) VALUES (1, 'Jan', 'Oko', '111222333', 'j.o@wp.com', 'P123', '1980-01-01', 3, 42);
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, age) VALUES (2, 'Katarzyna', 'Kajak', '444555666', 'k.k@o2.com', 'P456', '1975-05-15', 4, 21);

INSERT INTO visit (id, description, time, doctor_id, patient_id) VALUES (1, 'Wizyta kontrolna', '2024-05-01 10:00:00', 1, 1);
INSERT INTO visit (id, description, time, doctor_id, patient_id) VALUES (2, 'Badanie skóry', '2024-05-02 11:00:00', 2, 2);
INSERT INTO visit (id, description, time, doctor_id, patient_id) VALUES (3, 'Wizyta kontrolna', '2023-06-01 11:00:00', 1, 2);
INSERT INTO visit (id, description, time, doctor_id, patient_id) VALUES (4, 'Badanie skóry', '2023-07-01 12:00:00', 2, 1);

INSERT INTO medical_treatment (id, description, type, visit_id) VALUES (1, 'Pobranie krwi', 'DIAGNOSTIC', 1);
INSERT INTO medical_treatment (id, description, type, visit_id) VALUES (2, 'Wypalenie kurzajki', 'SURGICAL', 2);





--SELECT
--    v.id AS visit_id,
--    v.description AS visit_description,
--    v.time AS visit_time,
--    p.id AS patient_id,
--    p.first_name AS patient_first_name,
--    p.last_name AS patient_last_name,
--    d.id AS doctor_id,
--    d.first_name AS doctor_first_name,
--    d.last_name AS doctor_last_name
--FROM
--    visit v
--JOIN
--    patient p
--ON
--    v.patient_id = p.id
--JOIN
--    doctor d
--ON
--    v.doctor_id = d.id
--ORDER BY
--    v.id;


--SELECT
--    id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, age
--FROM
--    patient;
