
INSERT INTO member VALUES (10, 'Jackson', 'Elizabeth', 'elizbth123@gmail.com', 2062846783, '1985-09-07', true);
INSERT INTO member VALUES (11, 'Ran', 'Rose', 'rose3@gmail.com', 1234567895, '1990-09-05', true);
INSERT INTO member VALUES (12, 'Anderson', 'Jennifer', 'jnffr23@gmail.com', 9876543215, '1995-09-04', false);
INSERT INTO member VALUES (13, 'MacR', 'Micheal', 'mchl99@gmail.com', 7893214566, '1997-09-03', false);
INSERT INTO member VALUES (20, 'Yilmaz', 'Ali', 'aliylmaz@gmail.com', 5428974563, '1991-05-13', true);
INSERT INTO member VALUES (21, 'Zenkin', 'Sero', 'sero0303@gmail.com', 5412018978, '1998-01-06', true);
INSERT INTO member VALUES (22, 'Soylu', 'Sulo', 'sulo0606@gmail.com', 2514569872, '1985-07-03', false);
INSERT INTO member VALUES (23, 'Kara', 'Yaman', 'ymnkr15@gmail.com', 6524587962, '1991-06-24', false);


INSERT INTO groups VALUES ( 30, 'Tech', 10);
--INSERT INTO groups VALUES ( 30, 'Tech', 20);
--INSERT INTO groups VALUES ( 30, 'Tech', 11);
--INSERT INTO groups VALUES ( 31, 'WomenTech', 10);
INSERT INTO groups VALUES ( 31, 'WomenTech', 11);
--INSERT INTO groups VALUES ( 31, 'WomenTech', 12);
INSERT INTO groups VALUES ( 32, 'TechSolution', 12);

INSERT INTO group_member VALUES ( 10, 30);
INSERT INTO group_member VALUES ( 20, 30);
INSERT INTO group_member VALUES ( 11, 30);
INSERT INTO group_member VALUES ( 20, 32);
INSERT INTO group_member VALUES ( 10, 31);
INSERT INTO group_member VALUES ( 11, 31);
INSERT INTO group_member VALUES ( 12, 32);


INSERT INTO event VALUES (40, 'Fun' , 'Learn more information', '2021-11-10', 30, 10); 
INSERT INTO event VALUES (41, 'Funny' , 'Look, Learn more information', '2021-11-10', 31, 23); 
INSERT INTO event VALUES (42, 'Funnies' , 'Do not Learn more information', '2021-11-10', 32, 20); 

INSERT INTO event_member VALUES (20, 40);
INSERT INTO event_member VALUES (21, 40);
INSERT INTO event_member VALUES (22, 40);
INSERT INTO event_member VALUES (20, 41);
INSERT INTO event_member VALUES (21, 41);
INSERT INTO event_member VALUES (22, 41);

UPDATE event
SET start_date = '2021-12-01'
WHERE event_name = 'Funny';

UPDATE event
SET start_date = '2021-10-28'
WHERE event_name = 'Funnies';